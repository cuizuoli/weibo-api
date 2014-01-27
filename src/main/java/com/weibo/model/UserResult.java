/*
 * @(#)UserResult.java $version 2014年1月27日
 *
 * Copyright 2014 Vip Journey. All rights Reserved.
 * Vip Journey PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import lombok.Data;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * vip-journey weibo-api
 * com.weibo.model.UserResult.java
 * @author cuizuoli
 * @date 2014年1月27日
 */
@Data
public class UserResult {
	private User[] users;
	@JsonProperty("next_custor")
	private int nextCursor;
	@JsonProperty("previous_cursor")
	private int previousCursor;
	@JsonProperty("total_number")
	private int totalNumber;
}
