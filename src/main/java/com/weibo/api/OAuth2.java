/*
 * @(#)OAuth2.java $version 2013年11月23日
 *
 * Copyright 2013 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.weibo.enums.Display;
import com.weibo.http.client.WeiboHttpClient;
import com.weibo.model.AccessToken;
import com.weibo.model.ProfessionalTokenInfo;
import com.weibo.model.TokenInfo;

/**
 * weibo-api
 * com.weibo.api.OAuth2.java
 * @author cuizuoli
 * @date 2013年11月23日
 */
@Slf4j
@Component
public class OAuth2 {

	private static final String ALGORITHM_HMACSHA256 = "hmacSHA256";

	private static final String OAUTH2_AUTHORIZE = "https://api.weibo.com/oauth2/authorize";
	private static final String OAUTH2_ACCESS_TOKEN = "https://api.weibo.com/oauth2/access_token";
	private static final String OAUTH2_GET_TOKEN_INFO = "https://api.weibo.com/oauth2/get_token_info";
	private static final String OAUTH2_REVOKE_OAUTH2 = "https://api.weibo.com/oauth2/revokeoauth2";

	@Resource
	private WeiboHttpClient weiboHttpClient;

	@Resource
	private ObjectMapper weiboObjectMapper;

	/**
	 * http://open.weibo.com/wiki/Oauth2/authorize
	 * @param appKey
	 * @param redirectUri
	 * @param scope
	 * @param state
	 * @param display
	 * @return
	 */
	public String authorize(String appKey, String redirectUri, String scope, String state, Display display) {
		String authorizeUrl = new StringBuffer()
			.append(OAUTH2_AUTHORIZE)
			.append("?client_id=").append(appKey)
			.append("&redirect_uri=").append(redirectUri)
			.append("&scope=").append(scope)
			.append("&state=").append(state)
			.append("&display=").append(display.getCode())
			.toString();
		log.info(authorizeUrl);
		return authorizeUrl;
	}

	/**
	 * http://open.weibo.com/wiki/OAuth2/access_token
	 * @param appKey
	 * @param appSecret
	 * @param redirectUri
	 * @param code
	 * @return
	 */
	public AccessToken accessToken(String appKey, String appSecret, String redirectUri, String code) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("client_id", appKey);
		map.add("client_secret", appSecret);
		map.add("grant_type", "authorization_code");
		map.add("code", code);
		map.add("redirect_uri", redirectUri);
		String result = weiboHttpClient.postForm(OAUTH2_ACCESS_TOKEN, map, String.class);
		try {
			AccessToken accessToken = weiboObjectMapper.readValue(result, AccessToken.class);
			return accessToken;
		} catch (JsonParseException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (JsonMappingException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}

	/**
	 * http://open.weibo.com/wiki/Oauth2/get_token_info
	 * @param accessToken
	 * @return
	 */
	public TokenInfo getTokenInfo(String accessToken) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("access_token", accessToken);
		String result = weiboHttpClient.postForm(OAUTH2_GET_TOKEN_INFO, map, String.class);
		try {
			TokenInfo tokenInfo = weiboObjectMapper.readValue(result, TokenInfo.class);
			return tokenInfo;
		} catch (JsonParseException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (JsonMappingException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}

	/**
	 * http://open.weibo.com/wiki/Oauth2/revokeoauth2
	 * @param accessToken
	 * @return
	 */
	public String revokeOauth2(String accessToken) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("access_token", accessToken);
		return weiboHttpClient.postForm(OAUTH2_REVOKE_OAUTH2, map, String.class);
	}

	/**
	 * 解析站内应用post的signed_request split为part1和part2两部分
	 * @param signedRequest
	 * @param appSecret
	 * @return
	 */
	public ProfessionalTokenInfo parseSignedRequest(String signedRequest, String appSecret) {
		ProfessionalTokenInfo tokenInfo = null;
		String[] tokens = StringUtils.split(signedRequest, "\\.", 2);
		// base64Token
		String base64Token = tokens[0];
		// 为了和 url encode/decode 不冲突，base64url 编码方式会将
		// '+'，'/'转换成'-'，'_'，并且去掉结尾的'='。 因此解码之前需要还原到默认的base64编码，结尾的'='可以用以下算法还原
		int padding = (4 - base64Token.length() % 4);
		for (int i = 0; i < padding; i++) {
			base64Token += "=";
		}
		base64Token = StringUtils.replace(base64Token, "-", "+");
		base64Token = StringUtils.replace(base64Token, "_", "/");
		// base64Token1
		String token1 = tokens[1];
		SecretKey key = new SecretKeySpec(appSecret.getBytes(), ALGORITHM_HMACSHA256);
		try {
			Mac mac = Mac.getInstance(ALGORITHM_HMACSHA256);
			mac.init(key);
			mac.update(token1.getBytes());
			byte[] macResult = mac.doFinal();
			String base64Token1 = Base64.encodeBase64String(macResult);
			// access token
			if (StringUtils.equals(base64Token, base64Token1)) {
				tokenInfo = weiboObjectMapper.readValue(new String(Base64.decodeBase64(token1)), ProfessionalTokenInfo.class);
				log.info(tokenInfo.toString());
			}
		} catch (NoSuchAlgorithmException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (InvalidKeyException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (JsonParseException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (JsonMappingException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		}
		return tokenInfo;
	}

}
