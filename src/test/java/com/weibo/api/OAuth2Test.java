/*
 * @(#)OAuth2Test.java $version 2013年12月2日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.weibo.api.test.AbstractTest;

/**
 * weibo-api
 * com.weibo.api.OAuth2Test.java
 * @author st13902
 * @date 2013年12月2日
 */
public class OAuth2Test extends AbstractTest {

	@Resource
	private Map<String, String> dataMap;

	@Resource
	private OAuth2 oAuth2;

	@Test
	public void getTokenInfo() {
		oAuth2.getTokenInfo(dataMap.get("accessToken"));
	}

	@Test
	public void revokeOauth2() {
		oAuth2.revokeOauth2(dataMap.get("accessToken"));
	}

	@Test
	public void parseSignedRequest() throws InvalidKeyException, NoSuchAlgorithmException {
		String signedRequest = "z5Hx0p5tOrgPzxRRgaFhvs0-Jovf7OvKseOOpWlSXRM.eyJ1c2VyIjp7ImNvdW50cnkiOiJjbiIsImxvY2FsZSI6IiIsInZlcnNpb24iOjV9LCJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImlzc3VlZF9hdCI6MTM2MTU4NzQyNywiZXhwaXJlcyI6MTU3NjY4MDExLCJvYXV0aF90b2tlbiI6IjIuMDBSRFlvMUNGek9HTkIxZjFkN2QyYzVmYXg1ZDRCIiwidXNlcl9pZCI6MjEzOTgzOTY4MywicmVmZXJlciI6bnVsbH0";
		oAuth2.parseSignedRequest(signedRequest, "9587fe43c57ca702be194e8e3008e29c");
	}

}
