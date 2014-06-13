/*
 * @(#)CommentsResult.java $version 2013年12月10日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * weibo-api
 * com.weibo.model.CommentsResult.java
 * @author st13902
 * @date 2013年12月10日
 */
@Data
public class CommentsResult {
	private Comment[] comments;
	private Object[] marks;
	@JsonProperty("hasvisible")
	private boolean hasVisible;
	@JsonProperty("previous_cursor")
	private long previousCursor;
	@JsonProperty("next_cursor")
	private long nextCursor;
	@JsonProperty("total_number")
	private int totalNumber;
}
