/*
 * @(#)ErrorCode.java $version 2013年12月4日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * nhn weibo-api
 * http://open.weibo.com/wiki/Error_code
 * com.weibo.model.ErrorCode.java
 * @author st13902
 * @date 2013年12月4日
 */
@Data
public class ErrorCode {
	private String request;
	@JsonProperty("error_code")
	private String errorCode;
	private String error;
}
