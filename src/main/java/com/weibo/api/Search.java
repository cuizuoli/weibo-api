/*
 * @(#)Search.java $version 2014年6月20日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import javax.annotation.Resource;

import com.weibo.http.client.WeiboHttpClient;
import com.weibo.model.StatusesResult;

/**
 * weibo-api
 * com.weibo.api.Search.java
 * @author cuizuoli
 * @date 2014年6月20日
 */
public class Search {

	private static final String SEARCH_TOPICS_URL = "https://api.weibo.com/2/search/topics.json";

	@Resource
	private WeiboHttpClient weiboHttpClient;

	/**
	 * http://open.weibo.com/wiki/2/search/topics
	 * @param q - 搜索的话题关键字，必须进行URLencode，utf-8编码。
	 * @param page - 搜索的话题关键字，必须进行URLencode，utf-8编码。 
	 * @param count - 单页返回的记录条数，默认为10，最大为50。 
	 * @param accessToken
	 * @return
	 */
	public StatusesResult topics(String q, int page, int count, String accessToken) {
		String url = new StringBuffer()
			.append(SEARCH_TOPICS_URL)
			.append("?q=").append(q)
			.append("&page=").append(page)
			.append("&count=").append(count)
			.append("&access_token=").append(accessToken)
			.toString();
		return weiboHttpClient.get(url, StatusesResult.class);
	}

}
