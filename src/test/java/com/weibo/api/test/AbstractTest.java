/*
 * @(#)AbstractTest.java $version 2013年11月23日
 *
 * Copyright 2013 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.api.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * weibo-api
 * com.weibo.api.test.AbstractTest.java
 * @author cuizuoli
 * @date 2013年11月23日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context-weibo.xml", "classpath:context-data.xml"})
public abstract class AbstractTest {
}
