/*
 * @(#)Users.java $version 2013年11月23日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.weibo.model.User;
import com.weibo.model.UserCount;

import lombok.extern.slf4j.Slf4j;

/**
 * DaLian Software weibo-api
 * com.weibo.api.Users.java
 * @author cuizuoli
 * @date 2013年11月23日
 */
@Slf4j
@Component
public class Users {

	private static final String USERS_SHOW_URL = "https://api.weibo.com/2/users/show.json";
	private static final String USERS_DOMAIN_SHOW_URL = "https://api.weibo.com/2/users/domain_show.json";
	private static final String USERS_COUNTS_URL = "https://api.weibo.com/2/users/counts.json";

	@Resource
	private RestTemplate restTemplate;

	/**
	 * http://open.weibo.com/wiki/2/users/show
	 * @param uid
	 * @param accessToken
	 * @return
	 */
	public User show(String uid, String accessToken) {
		String url = new StringBuffer()
			.append(USERS_SHOW_URL)
			.append("?uid=").append(uid)
			.append("&access_token=").append(accessToken)
			.toString();
		User user = restTemplate.getForObject(url, User.class);
		log.info(user.toString());
		return user;
	}

	/**
	 * http://open.weibo.com/wiki/2/users/show
	 * @param screenName
	 * @param accessToken
	 * @return
	 */
	public User showByName(String screenName, String accessToken) {
		String url = new StringBuffer()
			.append(USERS_SHOW_URL)
			.append("?screen_name=").append(screenName)
			.append("&access_token=").append(accessToken)
			.toString();
		User user = restTemplate.getForObject(url, User.class);
		log.info(user.toString());
		return user;
	}

	/**
	 * http://open.weibo.com/wiki/2/users/domain_show
	 * @param domain
	 * @param accessToken
	 * @return
	 */
	public User domainShow(String domain, String accessToken) {
		String url = new StringBuffer()
			.append(USERS_DOMAIN_SHOW_URL)
			.append("?domain=").append(domain)
			.append("&access_token=").append(accessToken)
			.toString();
		User user = restTemplate.getForObject(url, User.class);
		log.info(user.toString());
		return user;
	}

	/**
	 * http://open.weibo.com/wiki/2/users/counts
	 * @param uids
	 * @param accessToken
	 * @return
	 */
	public UserCount[] counts(String uids, String accessToken) {
		String url = new StringBuffer()
			.append(USERS_COUNTS_URL)
			.append("?uids=").append(uids)
			.append("&access_token=").append(accessToken)
			.toString();
		UserCount[] userCounts = restTemplate.getForObject(url, UserCount[].class);
		for (UserCount userCount : userCounts) {
			log.info(userCount.toString());
		}
		return userCounts;
	}

}
