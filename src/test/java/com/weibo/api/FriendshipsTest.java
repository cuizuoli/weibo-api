/*
 * @(#)FriendshipsTest.java $version 2014年1月27日
 *
 * Copyright 2014 Vip Journey. All rights Reserved.
 * Vip Journey PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.weibo.api.test.AbstractTest;

/**
 * vip-journey weibo-api
 * com.weibo.api.FriendshipsTest.java
 * @author cuizuoli
 * @date 2014年1月27日
 */
public class FriendshipsTest extends AbstractTest {

	@Resource
	private Map<String, String> dataMap;

	@Resource
	private Friendships friendships;

	@Test
	public void followers() {
		friendships.followers("2138738095", 50, 1, dataMap.get("accessToken"));
	}

	@Test
	public void followersByName() {
		friendships.followersByName("竹叶青茶", 50, 1, dataMap.get("accessToken"));
	}

}
