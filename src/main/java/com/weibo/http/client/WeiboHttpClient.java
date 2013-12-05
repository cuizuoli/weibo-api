/*
 * @(#)WeiboHttpClient.java $version 2013年12月4日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.http.client;

import java.lang.reflect.Field;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.weibo.handler.ErrorCodeHandler;
import com.weibo.model.ErrorCode;

import lombok.extern.slf4j.Slf4j;

/**
 * DaLian Software weibo-api
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
	 * postForm
	 * @param url
	 * @param request
	 * @param responseType
	 * @return
	 */
	public <T> T postForm(String url, Object request, Class<T> responseType) {
		if (!(request instanceof MultiValueMap)) {
			try {
				request = getBodyMap(request);
			} catch (IllegalArgumentException e) {
				log.error(ExceptionUtils.getFullStackTrace(e));
			} catch (IllegalAccessException e) {
				log.error(ExceptionUtils.getFullStackTrace(e));
			}
		}
		return post(url, request, responseType, MediaType.APPLICATION_FORM_URLENCODED);
	}

	/**
	 * postJson
	 * @param url
	 * @param request
	 * @param responseType
	 * @return
	 */
	public <T> T postJson(String url, Object request, Class<T> responseType) {
		return post(url, request, responseType, MediaType.APPLICATION_JSON);
	}

	/**
	 * post
	 * @param url
	 * @param request
	 * @param responseType
	 * @param mediaType
	 * @return
	 */
	public <T> T post(String url, Object request, Class<T> responseType, MediaType mediaType) {
		T result = null;
		try {
			log.info("post : " + url + "?" + request.toString());
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(mediaType);
			HttpEntity<? extends Object> httpEntity = new HttpEntity<Object>(request, headers);
			result = restTemplate.postForObject(url, httpEntity, responseType);
			log.info("result : " + result.toString());
		} catch (HttpStatusCodeException e) {
			ErrorCode errorCode = errorCodeHandler.handle(e);
			log.info("error : " + errorCode.toString());
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
		return get(url, null, responseType);
	}

	/**
	 * get
	 * @param url
	 * @param request
	 * @param responseType
	 * @param urlVariables
	 * @return
	 */
	public <T> T get(String url, Object request, Class<T> responseType) {
		T result = null;
		try {
			if (request != null) {
				url += getBody(request);
			}
			log.info("api - get: " + url);
			result = restTemplate.getForObject(url, responseType);
			log.info("result : " + result.toString());
		} catch (HttpStatusCodeException e) {
			ErrorCode errorCode = errorCodeHandler.handle(e);
			log.info("error : " + errorCode.toString());
		} catch (IllegalArgumentException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (IllegalAccessException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		}
		return result;
	}

	/**
	 * getBody
	 * @param object
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private String getBody(Object object) throws IllegalArgumentException, IllegalAccessException {
		StringBuffer body = new StringBuffer();
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.get(object) != null) {
				body.append("&").append(field.getName()).append("=").append(field.get(object));
			}
		}
		return StringUtils.replaceOnce(body.toString(), "&", "?");
	}

	/**
	 * getBodyMap
	 * @param object
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private MultiValueMap<String, String> getBodyMap(Object object) throws IllegalArgumentException,
			IllegalAccessException {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.get(object) != null) {
				map.add(String.valueOf(field.getName()), String.valueOf(field.get(object)));
			}
		}
		return map;
	}

}
