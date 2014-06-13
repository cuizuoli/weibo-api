/*
 * @(#)Common.java $version 2014年1月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.weibo.http.client.WeiboHttpClient;

/**
 * weibo-api
 * com.weibo.api.Common.java
 * @author cuizuoli
 * @date 2014年1月23日
 */
@Component
public class Common {

	private static final String COMMON_GET_COUNTRY_URL = "https://api.weibo.com/2/common/get_country.json";
	private static final String COMMON_GET_PROVINCE_URL = "https://api.weibo.com/2/common/get_province.json";
	private static final String COMMON_GET_CITY_URL = "https://api.weibo.com/2/common/get_city.json";

	@Resource
	private WeiboHttpClient weiboHttpClient;

	/**
	 * http://open.weibo.com/wiki/2/common/get_country
	 * @param accessToken
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String>[] getCountry(String accessToken) {
		String url = new StringBuffer()
			.append(COMMON_GET_COUNTRY_URL)
			.append("?access_token=").append(accessToken)
			.toString();
		return weiboHttpClient.get(url, Map[].class);
	}

	/**
	 * http://open.weibo.com/wiki/2/common/get_province
	 * @param country - 国家的国家代码。
	 * @param accessToken
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String>[] getProvince(String country, String accessToken) {
		String url = new StringBuffer()
			.append(COMMON_GET_PROVINCE_URL)
			.append("?country=").append(country)
			.append("&access_token=").append(accessToken)
			.toString();
		return weiboHttpClient.get(url, Map[].class);
	}

	/**
	 * http://open.weibo.com/wiki/2/common/get_city
	 * @param province
	 * @param accessToken
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String>[] getCity(String province, String accessToken) {
		String url = new StringBuffer()
			.append(COMMON_GET_CITY_URL)
			.append("?province=").append(province)
			.append("&access_token=").append(accessToken)
			.toString();
		return weiboHttpClient.get(url, Map[].class);
	}

}
