/*
 * @(#)UsersTest.java $version 2013年12月2日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.weibo.api.test.AbstractTest;

/**
 * weibo-api
 * com.weibo.api.UsersTest.java
 * @author st13902
 * @date 2013年12月2日
 */
public class UsersTest extends AbstractTest {

	@Resource
	private Map<String, String> dataMap;

	@Resource
	private Users users;

	@Test
	public void show() {
		users.show(dataMap.get("uid"), dataMap.get("accessToken"));
	}

	@Test
	public void showByName() {
		users.showByName(dataMap.get("name"), dataMap.get("accessToken"));
	}

	@Test
	public void domainShow() {
		users.domainShow(dataMap.get("domain"), dataMap.get("accessToken"));
	}

	@Test
	public void counts() {
		users.counts(dataMap.get("uids"), dataMap.get("accessToken"));
	}

}
