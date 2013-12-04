/*
 * @(#)StatusesTest.java $version 2013年12月2日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.weibo.api.test.AbstractTest;

/**
 * nhn weibo-api
 * com.weibo.api.StatusesTest.java
 * @author st13902
 * @date 2013年12月2日
 */
public class StatusesTest extends AbstractTest {

	@Resource
	private Map<String, String> dataMap;

	@Resource
	private Statuses statuses;

	@Test
	public void repost() {
		statuses.repost("105", "Weibo-api Report Test", null, null, dataMap.get("accessToken"));
	}

	@Test
	public void update() {
		statuses.update("Weibo-api Update Test", dataMap.get("accessToken"));
	}

	@Test
	public void destroy() {
		statuses.destroy("1", dataMap.get("accessToken"));
	}

}
