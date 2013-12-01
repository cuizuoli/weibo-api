/*
 * @(#)User.java $version 2013年11月23日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * DaLian Software weibo-api
 * com.weibo.model.User.java
 * @author cuizuoli
 * @date 2013年11月23日
 */
@Data
public class User {
	private String id;
	private String idstr;
	@JsonProperty("class")
	private int clzss;
	@JsonProperty("screen_name")
	private String screenName;
	private String name;
	private int province;
	private int city;
	private String location;
	private String description;
	private String url;
	@JsonProperty("profile_image_url")
	private String profileImageUrl;
	@JsonProperty("profile_url")
	private String profileUrl;
	private String domain;
	private String weihao;
	private String gender;
	@JsonProperty("followers_count")
	private int followersCount;
	@JsonProperty("friends_count")
	private int friendsCount;
	@JsonProperty("statuses_count")
	private int statusesCount;
	@JsonProperty("favourites_count")
	private int favouritesCount;
	@JsonProperty("created_at")
	private String createdAt;
	private boolean following;
	@JsonProperty("allow_all_act_msg")
	private boolean allowAllActMsg;
	@JsonProperty("geo_enabled")
	private boolean geoEnabled;
	private boolean verified;
	@JsonProperty("verified_type")
	private int verifiedType;
	private String remark;
	@JsonIgnore
	private Object status;
	private int ptype;
	@JsonProperty("allow_all_comment")
	private boolean allowAllComment;
	@JsonProperty("avatar_large")
	private String avatarLarge;
	@JsonProperty("avatar_hd")
	private String avatarHd;
	@JsonProperty("verified_reason")
	private String verifiedReason;
	@JsonProperty("follow_me")
	private boolean followMe;
	@JsonProperty("online_status")
	private int onlineStatus;
	@JsonProperty("bi_followers_count")
	private int biFollowersCount;
	private String lang;
	private int star;
	private int mbtype;
	private int mbrank;
	@JsonProperty("block_word")
	private String blockWord;
}
