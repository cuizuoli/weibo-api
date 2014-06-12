/*
 * @(#)TokenInfo.java $version 2013年11月23日
 *
 * Copyright 2013 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * weibo-api
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
