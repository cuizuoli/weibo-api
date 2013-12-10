/*
 * @(#)Comments.java $version 2013年12月10日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.weibo.http.client.WeiboHttpClient;
import com.weibo.model.CommentsResult;

/**
 * nhn weibo-api
 * com.weibo.api.Comments.java
 * @author st13902
 * @date 2013年12月10日
 */
@Component
public class Comments {

	private static final String COMMENTS_SHOW_URL = "https://api.weibo.com/2/comments/show.json";

	@Resource
	private WeiboHttpClient weiboHttpClient;

	/**
	 * show
	 * @param id - 需要查询的微博ID。 
	 * @param page - 返回结果的页码，默认为1。 
	 * @param count - 单页返回的记录条数，默认为50。 
	 * @param filterByAuthor - 作者筛选类型，0：全部、1：我关注的人、2：陌生人，默认为0。
	 * @return
	 */
	public CommentsResult show(String id, int page, int count, int filterByAuthor, String accessToken) {
		String url = new StringBuffer()
			.append(COMMENTS_SHOW_URL)
			.append("?id=").append(id)
			.append("&page=").append(page)
			.append("&count=").append(count)
			.append("&filter_by_author=").append(filterByAuthor)
			.append("&access_token=").append(accessToken)
			.toString();
		return weiboHttpClient.get(url, CommentsResult.class);
	}

}
