/*
 * @(#)ObjectMapperFactoryBean.java $version 2013年11月23日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.http.client;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.FactoryBean;

import com.weibo.http.client.handler.SimpleDeserializationProblemHandler;

/**
 * DaLian Software weibo-api
 * com.weibo.http.client.ObjectMapperFactoryBean.java
 * @author cuizuoli
 * @date 2013年11月23日
 */
public class ObjectMapperFactoryBean implements FactoryBean<ObjectMapper> {

	@Override
	public ObjectMapper getObject() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.getDeserializationConfig().addHandler(new SimpleDeserializationProblemHandler());
		return objectMapper;
	}

	@Override
	public Class<?> getObjectType() {
		return ObjectMapper.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
