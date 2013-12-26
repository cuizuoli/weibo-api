/*
 * @(#)StatusCount.java $version 2013年12月26日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import lombok.Data;

/**
 * nhn weibo-api
 * com.weibo.model.StatusCount.java
 * @author st13902
 * @date 2013年12月26日
 */
@Data
public class StatusCount {
	private long id;
	private int comments;
	private int reposts;
	private int attitudes;
}
