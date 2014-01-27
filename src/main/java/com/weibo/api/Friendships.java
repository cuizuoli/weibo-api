/*
 * @(#)Friendships.java $version 2014年1月27日
 *
 * Copyright 2014 Vip Journey. All rights Reserved.
 * Vip Journey PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.weibo.http.client.WeiboHttpClient;
import com.weibo.model.UserResult;

/**
 * vip-journey weibo-api
 * com.weibo.api.Friendships.java
 * @author cuizuoli
 * @date 2014年1月27日
 */
@Component
public class Friendships {

	private static final String FRIENDSHIPS_FOLLOWERS_URL = "https://api.weibo.com/2/friendships/followers.json";

	@Resource
	private WeiboHttpClient weiboHttpClient;

	/**
	 * http://open.weibo.com/wiki/2/friendships/followers
	 * @param uid
	 * @param count
	 * @param cursor
	 * @param accessToken
	 * @return
	 */
	public UserResult followers(String uid, int count, int cursor, String accessToken) {
		String url = new StringBuffer()
			.append(FRIENDSHIPS_FOLLOWERS_URL)
			.append("?uid=").append(uid)
			.append("&access_token=").append(accessToken)
			.toString();
		return weiboHttpClient.get(url, UserResult.class);
	}

	/**
	 * http://open.weibo.com/wiki/2/friendships/followers
	 * @param screenName
	 * @param count
	 * @param cursor
	 * @param accessToken
	 * @return
	 */
	public UserResult followersByName(String screenName, int count, int cursor, String accessToken) {
		String url = new StringBuffer()
			.append(FRIENDSHIPS_FOLLOWERS_URL)
			.append("?screen_name=").append(screenName)
			.append("&access_token=").append(accessToken)
			.toString();
		return weiboHttpClient.get(url, UserResult.class);
	}

}
