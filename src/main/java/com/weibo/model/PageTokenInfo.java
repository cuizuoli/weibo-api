/*
 * @(#)PageTokenInfo.java $version 2014年6月13日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import java.util.Date;

import lombok.Data;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * weibo-api
 * com.weibo.model.PageTokenInfo.java
 * @author cuizuoli
 * @date 2014年6月13日
 */
@Data
public class PageTokenInfo {
	@JsonIgnore
	private String user;
	private String algorithm;
	@JsonProperty("issued_at")
	private Date issuedAt;
	private int expires;
	@JsonProperty("oauth_token")
	private String oauthToken;
	@JsonProperty("user_id")
	private String userId;
	private String referer;
	private String scope;
	@JsonProperty("ext_data")
	private String extData;
	private String ouid;
}
