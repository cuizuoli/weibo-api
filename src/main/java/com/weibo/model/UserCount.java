/*
 * @(#)UserCount.java $version 2013年12月2日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * DaLian Software weibo-api
 * com.weibo.model.UserCount.java
 * @author st13902
 * @date 2013年12月2日
 */
@Data
public class UserCount {
	private String id;
	@JsonProperty("followers_count")
	private int followersCount;
	@JsonProperty("friends_count")
	private int friendsCount;
	@JsonProperty("statuses_count")
	private int statusesCount;
	@JsonProperty("private_friends_count")
	private int privateFriendsCount;
}
