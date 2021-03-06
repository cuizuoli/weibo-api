/*
 * @(#)Display.java $version 2013年11月23日
 *
 * Copyright 2013 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.enums;

/**
 * weibo-api
 * com.weibo.enums.Display.java
 * @author cuizuoli
 * @date 2013年11月23日
 */
public enum Display {
	DEFAULT("default"),
	MOBILE("mobile"),
	WAP("wap"),
	CLIENT("client"),
	APPONWEIBO("apponweibo");
	private final String code;

	private Display(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
