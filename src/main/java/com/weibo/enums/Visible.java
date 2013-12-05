/*
 * @(#)Visible.java $version 2013年12月2日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.enums;

/**
 * DaLian Software weibo-api
 * com.weibo.enums.Visible.java
 * @author st13902
 * @date 2013年12月2日
 */
public enum Visible {
	ALL(0),
	MYSELF(1),
	FRIENDS(2),
	GROUP(3);
	private final int code;

	private Visible(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
