/*
 * @(#)SimpleDeserializationProblemHandler.java $version 2013年11月23日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.http.client.handler;

import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializationProblemHandler;
import org.codehaus.jackson.map.JsonDeserializer;

import lombok.extern.slf4j.Slf4j;

/**
 * DaLian Software weibo-api
 * com.weibo.http.client.handler.SimpleDeserializationProblemHandler.java
 * @author cuizuoli
 * @date 2013年11月23日
 */
@Slf4j
public class SimpleDeserializationProblemHandler extends DeserializationProblemHandler {

	@Override
	public boolean handleUnknownProperty(DeserializationContext ctxt, JsonDeserializer<?> deserializer,
			Object beanOrClass, String propertyName) throws IOException, JsonProcessingException {
		log.error("Can't deserialize " + beanOrClass.getClass().getPackage().getName() + "."
			+ beanOrClass.getClass().getSimpleName() + " [" + propertyName + "]");
		return true;
	}

}
