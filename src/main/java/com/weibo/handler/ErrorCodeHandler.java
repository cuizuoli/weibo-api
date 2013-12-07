/*
 * @(#)ErrorCodeHandler.java $version 2013年12月4日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.handler;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;

import com.weibo.model.ErrorCode;

import lombok.extern.slf4j.Slf4j;

/**
 * DaLian Software weibo-api
 * com.weibo.handler.ErrorCodeHandler.java
 * @author st13902
 * @date 2013年12月4日
 */
@Slf4j
@Component
public class ErrorCodeHandler {

	public ErrorCode handle(HttpStatusCodeException error) {
		ObjectMapper objectMapper = new ObjectMapper();
		ErrorCode errorCode = new ErrorCode();
		errorCode.setRequest(StringUtils.EMPTY);
		errorCode.setErrorCode(error.getStatusCode().toString());
		errorCode.setError(error.getStatusText());
		try {
			errorCode = objectMapper.readValue(error.getResponseBodyAsByteArray(), ErrorCode.class);
		} catch (JsonParseException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (JsonMappingException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		}
		return errorCode;
	}

}
