/*
 * @(#)StatusesTest.java $version 2013年12月2日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.weibo.api.test.AbstractTest;

/**
 * DaLian Software weibo-api
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
		statuses.repost("3652070588614725", "Weibo-api Report Test", null, null, dataMap.get("accessToken"));
	}

	@Test
	public void destroy() {
		statuses.destroy("3652072421540206", dataMap.get("accessToken"));
	}

	@Test
	public void update() {
		statuses.update("Weibo-api Update Test", dataMap.get("accessToken"));
	}

	@Test
	public void upload() throws FileNotFoundException, IOException {
		statuses.upload("Weibo-api Update Test", "dhxlayout_progress.gif", dataMap.get("accessToken"));
	}

}
