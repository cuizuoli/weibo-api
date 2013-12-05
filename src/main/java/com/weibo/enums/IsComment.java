/*
 * @(#)IsComment.java $version 2013年12月5日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.enums;

/**
 * DaLian Software weibo-api
 * 是否在转发的同时发表评论，
 * 0：否
 * 1：评论给当前微博
 * 2：评论给原微博
 * 3：都评论，
 * 默认为0
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
