/*
 * @(#)CommonTest.java $version 2014年1月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import java.util.Map;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

import com.weibo.api.test.AbstractTest;

/**
 * weibo-api
 * com.weibo.api.CommonTest.java
 * @author cuizuoli
 * @date 2014年1月23日
 */
@Slf4j
public class CommonTest extends AbstractTest {

	@Resource
	private Map<String, String> dataMap;

	@Resource
	private Common common;

	@Test
	public void getCountry() {
		Map<String, String>[] countries = common.getCountry(dataMap.get("accessToken"));
		for (Map<String, String> country : countries) {
			log.info(country.toString());
		}
	}

	@Test
	public void getProvince() {
		String country = "001";
		Map<String, String>[] provinces = common.getProvince(country, dataMap.get("accessToken"));
		for (Map<String, String> province : provinces) {
			log.info(province.toString());
		}
	}

	@Test
	public void getCity() {
		String province = "001011";
		Map<String, String>[] cities = common.getCity(province, dataMap.get("accessToken"));
		for (Map<String, String> city : cities) {
			log.info(city.toString());
		}
	}

}
