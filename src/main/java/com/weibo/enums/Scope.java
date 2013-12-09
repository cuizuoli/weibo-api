/*
 * @(#)Scope.java $version 2013年11月23日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.enums;

/**
 * DaLian Software weibo-api
 * com.weibo.enums.Scope.java
 * @author cuizuoli
 * @date 2013年11月23日
 */
public enum Scope {
	ALL("all"),
	EMAIL("email"),
	DIRECT_MESSAGES_WRITE("direct_messages_write"),
	DIRECT_MESSAGES_READ("direct_messages_read"),
	INVITATION_WRITE("invitation_write"),
	FRIENDSHIPS_GROUPS_READ("friendships_groups_read"),
	FRIENDSHIPS_GROUPS_WRITE("friendships_groups_write"),
	STATUSES_TO_ME_READ("statuses_to_me_read"),
	FOLLOW_APP_OFFICIAL_MICROBLOG("follow_app_official_microblog");
	private final String code;

	private Scope(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
