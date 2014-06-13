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
 * weibo-api
 * com.weibo.api.Comments.java
 * @author st13902
 * @date 2013年12月10日
 */
@Component
public class Comments {

	private static final String COMMENTS_SHOW_URL = "https://api.weibo.com/2/comments/show.json";
	private static final String COMMENTS_BY_ME_URL = "https://api.weibo.com/2/comments/by_me.json";
	private static final String COMMENTS_TO_ME_URL = "https://api.weibo.com/2/comments/to_me.json";
	private static final String COMMENTS_TIMELINE_URL = "https://api.weibo.com/2/comments/timeline.json";

	@Resource
	private WeiboHttpClient weiboHttpClient;

	/**
	 * show
	 * @param id - 需要查询的微博ID。 
	 * @param page - 返回结果的页码，默认为1。 
	 * @param count - 单页返回的记录条数，默认为50。 
	 * @param filterByAuthor - 作者筛选类型，0：全部、1：我关注的人、2：陌生人，默认为0。
	 * @param accessToken
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

	/**
	 * byMe
	 * @param page - 返回结果的页码，默认为1。 
	 * @param count - 单页返回的记录条数，默认为50。 
	 * @param filterBySource - 来源筛选类型，0：全部、1：来自微博的评论、2：来自微群的评论，默认为0。 
	 * @param accessToken
	 * @return
	 */
	public CommentsResult byMe(int page, int count, int filterBySource, String accessToken) {
		String url = new StringBuffer()
			.append(COMMENTS_BY_ME_URL)
			.append("?page=").append(page)
			.append("&count=").append(count)
			.append("&filter_by_source=").append(filterBySource)
			.append("&access_token=").append(accessToken)
			.toString();
		return weiboHttpClient.get(url, CommentsResult.class);
	}

	/**
	 * toMe
	 * @param page - 返回结果的页码，默认为1。
	 * @param count - 单页返回的记录条数，默认为50。 
	 * @param filterByAuthor - 作者筛选类型，0：全部、1：我关注的人、2：陌生人，默认为0。
	 * @param filterBySource - 来源筛选类型，0：全部、1：来自微博的评论、2：来自微群的评论，默认为0。
	 * @param accessToken
	 * @return
	 */
	public CommentsResult toMe(int page, int count, int filterByAuthor, int filterBySource, String accessToken) {
		String url = new StringBuffer()
			.append(COMMENTS_TO_ME_URL)
			.append("?page=").append(page)
			.append("&count=").append(count)
			.append("&filter_by_author=").append(filterByAuthor)
			.append("&filter_by_source=").append(filterBySource)
			.append("&access_token=").append(accessToken)
			.toString();
		return weiboHttpClient.get(url, CommentsResult.class);
	}

	/**
	 * timeline
	 * @param page - 返回结果的页码，默认为1。
	 * @param count - 单页返回的记录条数，默认为50。
	 * @param trimUser - 返回值中user字段开关，0：返回完整user字段、1：user字段仅返回user_id，默认为0。
	 * @param accessToken
	 * @return
	 */
	public CommentsResult timeline(int page, int count, int trimUser, String accessToken) {
		String url = new StringBuffer()
			.append(COMMENTS_TIMELINE_URL)
			.append("?page=").append(page)
			.append("&count=").append(count)
			.append("&trim_user=").append(trimUser)
			.append("&access_token=").append(accessToken)
			.toString();
		return weiboHttpClient.get(url, CommentsResult.class);
	}

}
