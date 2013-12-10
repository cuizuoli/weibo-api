/*
 * @(#)CommentsTest.java $version 2013年12月10日
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
 * com.weibo.api.CommentsTest.java
 * @author st13902
 * @date 2013年12月10日
 */
public class CommentsTest extends AbstractTest {

	@Resource
	private Map<String, String> dataMap;

	@Resource
	private Comments comments;

	@Test
	public void show() {
		comments.show("3481474642286341", 1, 5, 0, dataMap.get("accessToken"));
	}

}
