/*
 * @(#)Messages.java $version 2013年12月9日
 *
 * Copyright 2013 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.weibo.http.client.WeiboHttpClient;
import com.weibo.model.InviteData;
import com.weibo.model.InviteResult;

import lombok.extern.slf4j.Slf4j;

/**
 * weibo-api
 * com.weibo.api.Messages.java
 * @author cuizuoli
 * @date 2013年12月9日
 */
@Slf4j
@Component
public class Messages {

	private static final String MESSAGES_INVITE_URL = "https://m.api.weibo.com/2/messages/invite.json";

	@Resource
	private WeiboHttpClient weiboHttpClient;

	/**
	 * http://open.weibo.com/wiki/2/messages/invite
	 * @param uid
	 * @param data
	 * @param accessToken
	 * @return
	 */
	public InviteResult invite(String uid, InviteData data, String accessToken) {
		String jsonData = StringUtils.EMPTY;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			jsonData = objectMapper.writeValueAsString(data);
		} catch (JsonGenerationException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (JsonMappingException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		}
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("uid", uid);
		map.add("data", jsonData);
		map.add("access_token", accessToken);
		return weiboHttpClient.postForm(MESSAGES_INVITE_URL, map, InviteResult.class);
	}

}
