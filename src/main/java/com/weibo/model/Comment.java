/*
 * @(#)Comment.java $version 2013年12月10日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * nhn weibo-api
 * com.weibo.model.Comment.java
 * @author st13902
 * @date 2013年12月10日
 */
@Data
public class Comment {
	@JsonProperty("created_at")
	private String createdAt;
	private String id;
	private String mid;
	private String idstr;
	private String text;
	private String source;
	private User user;
	private Status status;
}
