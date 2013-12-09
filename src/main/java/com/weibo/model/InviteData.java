/*
 * @(#)InviteData.java $version 2013年12月9日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * DaLian Software weibo-api
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
