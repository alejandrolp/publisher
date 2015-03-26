package com.app.mercadolibre

import grails.converters.JSON

import com.mercadolibre.sdk.Meli
import com.ning.http.client.Response
import com.ning.http.client.FluentStringsMap

import org.codehaus.groovy.grails.web.json.JSONArray;
import org.codehaus.groovy.grails.web.json.JSONObject

class JavaSDK extends Meli {
	
	private static final Long appId = 1243385409625122L // 69645727579726L
	private static final String secretKey = "XLumm0lMHocpsoStU60kd9y4v3xOrExM" //"OEa7zav2hKf6nsAwoEh3kK0MdhlgkFHP"
	private final String backurl = "http://localhost:8080/publisher/items/authorize"
	
	
	private static final JavaSDK javaSDK = new JavaSDK()
	
	private JavaSDK() {	
		super(appId, secretKey)
	}
	
	public static synchronized JavaSDK getInstance() {
		return javaSDK 
	}
	
	public String getAuthUrl() {
		return getAuthUrl(backurl)
	}
	
	public void authorize(String code) {
		authorize(code, backurl)
	}

	public Object get(String url, Boolean addToken) {
		Response r
		if (addToken) {
			FluentStringsMap fsm = new FluentStringsMap()
			fsm.add("access_token", JavaSDK.getInstance().getAccessToken())
			r = JavaSDK.getInstance().get(url, fsm)
		}
		else {
			r = JavaSDK.getInstance().get(url)
		}
		String data = r.getResponseBody()
		
		Object obj = JSON.parse(data)
		return obj
//		try {
//			JSONObject jsonObject = JSON.parse(data)
//		}
//		catch (org.codehaus.groovy.runtime.typehandling.GroovyCastException e) {
//			JSONArray jsonArray = JSON.parse(data)
//			println "stop"
//		}			
//		return jsonObject
	}
	
	public JSONObject post(String url, String json, Boolean addToken) {
		Response r
		if (addToken) {
			FluentStringsMap fsm = new FluentStringsMap()
			fsm.add("access_token", JavaSDK.getInstance().getAccessToken())
			r = JavaSDK.getInstance().post(url, fsm, json)
		}
		else {
			r = JavaSDK.getInstance().post(url, json)
		}
		String data = r.getResponseBody()
		JSONObject jsonObject = JSON.parse(data)
		return jsonObject
	}
	
	def xxx(JSONObject j) {
		return JSON.parse(data)
	}
	
	def xxx(JSONArray j) {
		
	}
	
	

}
