/*
 * @(#)IsComment.java $version 2013年12月5日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.enums;

/**
 * DaLian Software weibo-api
 * com.weibo.enums.IsComment.java
 * @author st13902
 * @date 2013年12月5日
 */
public enum IsComment {
	NO("0"),
	CURRENT("1"),
	ORIGINAL("2"),
	ALL("3");
	private final String code;

	private IsComment(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
