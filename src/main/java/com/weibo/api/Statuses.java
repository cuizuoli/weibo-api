/*
 * @(#)Statuses.java $version 2013年12月2日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.weibo.enums.Visible;
import com.weibo.http.client.WeiboHttpClient;
import com.weibo.model.Status;

/**
 * nhn weibo-api
 * com.weibo.api.Statuses.java
 * @author st13902
 * @date 2013年12月2日
 */
@Component
public class Statuses {

	private static final String STATUSES_UPDATE_URL = "https://api.weibo.com/2/statuses/update.json";
	private static final String STATUSES_DESTROY_URL = "https://api.weibo.com/2/statuses/destroy.json";

	@Resource
	private WeiboHttpClient weiboHttpClient;

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
		return weiboHttpClient.postForm(STATUSES_UPDATE_URL, map, Status.class);
	}

	/**
	 * http://open.weibo.com/wiki/2/statuses/destroy
	 * @param id
	 * @param accessToken
	 * @return
	 */
	public Status destroy(String id, String accessToken) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("id", id);
		map.add("access_token", accessToken);
		return weiboHttpClient.postForm(STATUSES_DESTROY_URL, map, Status.class);
	}

}
