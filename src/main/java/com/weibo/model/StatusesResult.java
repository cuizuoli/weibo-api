/*
 * @(#)StatusesResult.java $version 2014年6月20日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.model;

import lombok.Data;

/**
 * weibo-api
 * com.weibo.model.StatusesResult.java
 * @author cuizuoli
 * @date 2014年6月20日
 */
@Data
public class StatusesResult {
	private Status[] statuses;
}
