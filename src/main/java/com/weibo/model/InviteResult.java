/*
 * @(#)InviteResult.java $version 2013年12月9日
 *
 * Copyright 2013 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * weibo-api
 * com.weibo.model.InviteResult.java
 * @author cuizuoli
 * @date 2013年12月9日
 */
@Data
public class InviteResult {
	private long id;
	private String type;
	@JsonProperty("recipient_id")
	private long recipientId;
	@JsonProperty("sender_id")
	private long senderId;
	@JsonProperty("created_at")
	private String createdAt;
	private String text;
	private InviteData data;
}
