/*
 * @(#)WeiboHttpClient.java $version 2013年12月4日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.http.client;

import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.weibo.handler.ErrorCodeHandler;
import com.weibo.model.ErrorCode;

import lombok.extern.slf4j.Slf4j;

/**
 * nhn weibo-api
 * com.weibo.http.client.WeiboHttpClient.java
 * @author st13902
 * @date 2013年12月4日
 */
@Slf4j
@Component
public class WeiboHttpClient {

	@Resource
	private RestTemplate restTemplate;

	@Resource
	private ErrorCodeHandler errorCodeHandler;

	/**
	 * post
	 * @param url
	 * @param map
	 * @param responseType
	 * @return
	 */
	public <T> T post(String url, MultiValueMap<String, ? extends Object> map, Class<T> responseType) {
		T result = null;
		try {
			log.info("weibo-api - post : " + url + "?" + map.toString());
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			HttpEntity<MultiValueMap<String, ? extends Object>> request = new HttpEntity<MultiValueMap<String, ? extends Object>>(map, headers);
			result = restTemplate.postForObject(url, request, responseType);
			log.info("weibo-api - result : " + result.toString());
		} catch (HttpStatusCodeException e) {
			ErrorCode errorCode = errorCodeHandler.handle(e);
			log.info("weibo-api - error : " + errorCode.toString());
		}
		return result;
	}

	/**
	 * get
	 * @param url
	 * @param responseType
	 * @return
	 */
	public <T> T get(String url, Class<T> responseType) {
		T result = null;
		try {
			log.info("api - get: " + url);
			result = restTemplate.getForObject(url, responseType);
			log.info("weibo-api - result : " + result.toString());
		} catch (HttpStatusCodeException e) {
			ErrorCode errorCode = errorCodeHandler.handle(e);
			log.info("weibo-api - error : " + errorCode.toString());
		}
		return result;
	}

}
