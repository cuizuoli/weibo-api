/*
 * @(#)Statuses.java $version 2013年12月2日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.weibo.enums.Visible;
import com.weibo.model.Status;

import lombok.extern.slf4j.Slf4j;

/**
 * nhn weibo-api
 * com.weibo.api.Statuses.java
 * @author st13902
 * @date 2013年12月2日
 */
@Slf4j
@Component
public class Statuses {

	private static final String STATUSES_UPDATE_URL = "https://api.weibo.com/2/statuses/update.json";

	@Resource
	private RestTemplate restTemplate;

	/**
	 * http://open.weibo.com/wiki/2/statuses/update
	 * @param status
	 * @param accessToken
	 * @return
	 */
	public Status update(String status, String accessToken) {
		return update(status, null, null, accessToken);
	}

	/**
	 * http://open.weibo.com/wiki/2/statuses/update
	 * @param status
	 * @param visible
	 * @param listId
	 * @param accessToken
	 * @return
	 */
	public Status update(String status, Visible visible, String listId, String accessToken) {
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("status", status);
		if (visible != null) {
			map.add("visible", visible.getCode());
			if (visible == Visible.GROUP) {
				map.add("list_id", listId);
			}
		}
		map.add("access_token", accessToken);
		log.info(map.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
		Status result = restTemplate.postForObject(STATUSES_UPDATE_URL, request, Status.class);
		log.info(result.toString());
		return result;
	}
}
