/*
 * @(#)InviteData.java $version 2013年12月9日
 *
 * Copyright 2013 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * weibo-api
 * com.weibo.model.InviteData.java
 * @author cuizuoli
 * @date 2013年12月9日
 */
@Data
public class InviteData {
	private String text;
	private String url;
	@JsonProperty("invite_logo")
	private String inviteLogo;
}
