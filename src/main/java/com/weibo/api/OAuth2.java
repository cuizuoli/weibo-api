/*
 * @(#)OAuth2.java $version 2013年11月23日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.weibo.enums.Display;
import com.weibo.http.client.WeiboHttpClient;
import com.weibo.model.AccessToken;
import com.weibo.model.TokenInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * DaLian Software weibo-api
 * com.weibo.api.OAuth2.java
 * @author cuizuoli
 * @date 2013年11月23日
 */
@Slf4j
@Component
public class OAuth2 {

	private static final String OAUTH2_AUTHORIZE = "https://api.weibo.com/oauth2/authorize";
	private static final String OAUTH2_ACCESS_TOKEN = "https://api.weibo.com/oauth2/access_token";
	private static final String OAUTH2_GET_TOKEN_INFO = "https://api.weibo.com/oauth2/get_token_info";
	private static final String OAUTH2_REVOKE_OAUTH2 = "https://api.weibo.com/oauth2/revokeoauth2";

	@Value("#{weiboProperties['weibo.appKey']}")
	private String appKey;

	@Value("#{weiboProperties['weibo.appSecret']}")
	private String appSecret;

	@Value("#{weiboProperties['weibo.redirectUri']}")
	private String redirectUri;

	@Resource
	private WeiboHttpClient weiboHttpClient;

	/**
	 * http://open.weibo.com/wiki/Oauth2/authorize
	 * @param scope
	 * @param state
	 * @param display
	 * @return
	 */
	public String authorize(String scope, String state, Display display) {
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
	 * @param code
	 * @return
	 */
	public AccessToken accessToken(String code) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("client_id", appKey);
		map.add("client_secret", appSecret);
		map.add("grant_type", "authorization_code");
		map.add("code", code);
		map.add("redirect_uri", redirectUri);
		String result = weiboHttpClient.postForm(OAUTH2_ACCESS_TOKEN, map, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			AccessToken accessToken = objectMapper.readValue(result, AccessToken.class);
			log.info(accessToken.toString());
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
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			TokenInfo tokenInfo = objectMapper.readValue(result, TokenInfo.class);
			log.info(tokenInfo.toString());
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

}
