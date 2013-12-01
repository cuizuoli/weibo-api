/*
 * @(#)AbstractTest.java $version 2013年11月23日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * DaLian Software weibo-api
 * com.weibo.api.test.AbstractTest.java
 * @author cuizuoli
 * @date 2013年11月23日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context-service.xml"})
public abstract class AbstractTest {
}
