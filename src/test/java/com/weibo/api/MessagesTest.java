/*
 * @(#)MessagesTest.java $version 2013年12月9日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.weibo.api.test.AbstractTest;
import com.weibo.model.InviteData;

/**
 * DaLian Software weibo-api
 * com.weibo.api.MessagesTest.java
 * @author cuizuoli
 * @date 2013年12月9日
 */
public class MessagesTest extends AbstractTest {

	@Resource
	private Map<String, String> dataMap;

	@Resource
	private Messages messages;

	@Test
	public void invite() {
		InviteData data = new InviteData();
		data.setText("这个游戏太好玩了，加入一起玩吧");
		data.setUrl("http://app.sina.com.cn/appdetail.php?appID=770915");
		data.setInviteLogo("http://hubimage.com2us.com/hubweb/contents/123_499.jpg");
		messages.invite("1835113525", data, dataMap.get("accessToken"));
	}

}
