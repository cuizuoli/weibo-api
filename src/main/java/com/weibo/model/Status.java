/*
 * @(#)Status.java $version 2013年12月2日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * weibo-api
 * com.weibo.model.Status.java
 * @author st13902
 * @date 2013年12月2日
 */
@Data
public class Status {
	@JsonProperty("created_at")
	private String createdAt;
	private String id;
	private String mid;
	private String idstr;
	private String text;
	private String source;
	private boolean favorited;
	private boolean truncated;
	@JsonProperty("in_reply_to_status_id")
	private String inReplyToStatusId;
	@JsonProperty("in_reply_to_user_id")
	private String inReplyToUserId;
	@JsonProperty("in_reply_to_screen_name")
	private String inReplyToScreenName;
	@JsonProperty("pic_urls")
	private PicUrl[] picUrls;
	@JsonProperty("thumbnail_pic")
	private String thumbnailPic;
	@JsonProperty("bmiddle_pic")
	private String bmiddlePic;
	@JsonProperty("original_pic")
	private String originalPic;
	private String geo;
	private User user;
	@JsonProperty("reposts_count")
	private int repostsCount;
	@JsonProperty("comments_count")
	private int commentsCount;
	@JsonProperty("attitudes_count")
	private int attitudesCount;
	private int mlevel;
	private Visible visible;
	private Object annotations;
	@JsonProperty("retweeted_status")
	private Status retweetedStatus;
}
