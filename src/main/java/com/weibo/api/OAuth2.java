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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.weibo.enums.Display;
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
public class OAuth2 {

	@Value("#{weiboProperties.appKey}")
	private String appKey;

	@Value("#{weiboProperties.appSecret}")
	private String appSecret;

	@Value("#{weiboProperties.redirectUri}")
	private String redirectUri;

	private static final String OAUTH2_AUTHORIZE = "https://api.weibo.com/oauth2/authorize";
	private static final String OAUTH2_ACCESS_TOKEN = "https://api.weibo.com/oauth2/access_token";
	private static final String OAUTH2_GET_TOKEN_INFO = "https://api.weibo.com/oauth2/get_token_info";

	@Resource
	private RestTemplate restTemplate;

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
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		String result = restTemplate.postForObject(OAUTH2_ACCESS_TOKEN, request, String.class);
		log.info(result);
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
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		String result = restTemplate.postForObject(OAUTH2_GET_TOKEN_INFO, request, String.class);
		log.info(result);
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

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
