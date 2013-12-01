/*
 * @(#)TokenInfo.java $version 2013年11月23日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * DaLian Software weibo-api
 * com.weibo.model.TokenInfo.java
 * @author cuizuoli
 * @date 2013年11月23日
 */
@Data
public class TokenInfo {
	private String uid;
	@JsonProperty("appkey")
	private String appKey;
	private String scope;
	@JsonProperty("create_at")
	private int createAt;
	@JsonProperty("expire_in")
	private int expireIn;
}
