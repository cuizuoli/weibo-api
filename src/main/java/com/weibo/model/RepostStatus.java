/*
 * @(#)RepostStatus.java $version 2013年12月4日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DaLian Software weibo-api
 * com.weibo.model.RepostStatus.java
 * @author cuizuoli
 * @date 2013年12月4日
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RepostStatus extends Status {
	@JsonIgnore
	private Object annotations;
	@JsonProperty("retweeted_status")
	private Status retweetedStatus;
}
