package com.book.client.bean;

import java.io.Serializable;

public class ResponseTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6467116225829969790L;
	
	private String responseCode;
	private String responseMessage;
	private String info;
	private String responseType;
	
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getResponseType() {
		return responseType;
	}
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	
	
	

}
