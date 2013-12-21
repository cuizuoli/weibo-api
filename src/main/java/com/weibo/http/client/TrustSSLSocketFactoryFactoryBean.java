/*
 * @(#)TrustSSLSocketFactoryFactoryBean.java $version 2013年12月21日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.http.client;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.beans.factory.FactoryBean;

/**
 * DaLian Software weibo-api
 * com.weibo.http.client.TrustSSLSocketFactoryFactoryBean.java
 * @author cuizuoli
 * @date 2013年12月21日
 */
public class TrustSSLSocketFactoryFactoryBean implements FactoryBean<SSLSocketFactory> {

	@Override
	public SSLSocketFactory getObject() throws Exception {
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new SecureRandom());
			return sc.getSocketFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		return SSLSocketFactory.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	/**
	 * TrustAnyTrustManager
	 * DaLian Software weibo-api
	 * com.weibo.http.client.TrustSSLSocketFactoryFactoryBean.java
	 * @author cuizuoli
	 * @date 2013年12月21日
	 */
	private class TrustAnyTrustManager implements X509TrustManager {
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[]{};
		}
	}

}
