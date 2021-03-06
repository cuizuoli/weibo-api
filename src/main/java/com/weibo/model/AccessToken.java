/*
 * @(#)AccessToken.java $version 2013年11月23日
 *
 * Copyright 2013 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * weibo-api
 * com.weibo.model.AccessToken.java
 * @author cuizuoli
 * @date 2013年11月23日
 */
@Data
public class AccessToken {
	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("expires_in")
	private int expiresIn;
	@JsonProperty("remind_in")
	private int remindIn;
	private String uid;
	private String scope;
}
