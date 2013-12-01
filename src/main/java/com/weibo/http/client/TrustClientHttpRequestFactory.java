/*
 * @(#)TrustClientHttpRequestFactory.java $version 2013年11月23日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.weibo.http.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

/**
 * DaLian Software weibo-api
 * com.weibo.http.client.TrustClientHttpRequestFactory.java
 * @author cuizuoli
 * @date 2013年11月23日
 */
public class TrustClientHttpRequestFactory extends SimpleClientHttpRequestFactory {

	@Override
	protected HttpURLConnection openConnection(URL url, Proxy proxy) throws IOException {
		if (StringUtils.equals(url.getProtocol(), "https")) {
			trustAllHosts();
			HttpsURLConnection urlConnection = (HttpsURLConnection)(proxy != null ? url.openConnection(proxy)
				: url.openConnection());
			urlConnection.setHostnameVerifier(DO_NOT_VERIFY);
			return urlConnection;
		} else {
			HttpURLConnection urlConnection = (HttpURLConnection)(proxy != null ? url.openConnection(proxy)
				: url.openConnection());
			return urlConnection;
		}
		//URLConnection urlConnection = (proxy != null ? url.openConnection(proxy) : url.openConnection());
		//Assert.isInstanceOf(HttpURLConnection.class, urlConnection);
		//return (HttpURLConnection)urlConnection;
	}

	private HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
		@Override
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	};

	/**
	 * trustAllHosts
	 */
	private void trustAllHosts() {
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[]{
			new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return new java.security.cert.X509Certificate[]{};
				}

				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}
			}
		};
		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
