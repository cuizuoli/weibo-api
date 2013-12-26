/*
 * @(#)ProfessionalTokenInfo.java $version 2013年12月26日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * nhn weibo-api
 * com.weibo.model.ProfessionalTokenInfo.java
 * @author st13902
 * @date 2013年12月26日
 */
@Data
public class ProfessionalTokenInfo {
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
	@JsonIgnore
	private String referer;

}
