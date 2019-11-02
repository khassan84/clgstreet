package com.bookstoredb.bean.to;
public class LoginResponseTO {
	
	private String userName;
	private String responseCode;
	private String responseDesc;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseDesc() {
		return responseDesc;
	}
	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}
	
	

}