/*
 * @(#)StatusesTest.java $version 2013年12月2日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.weibo.api.test.AbstractTest;
import com.weibo.model.StatusCount;

import lombok.extern.slf4j.Slf4j;

/**
 * weibo-api
 * com.weibo.api.StatusesTest.java
 * @author st13902
 * @date 2013年12月2日
 */
@Slf4j
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
		statuses.upload("微博测试1111验33333", "dhxlayout_progress.gif", dataMap.get("accessToken"));
	}

	@Test
	public void count() {
		StatusCount[] statusCounts = statuses.count("3481474642286341,3478931308682632,3479600589793135", "2.00RDYo1CY_6O6B80e36ffe28a7QynC");
		log.info(statusCounts[0].toString());
	}

}
