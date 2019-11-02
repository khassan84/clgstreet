package com.bookstoredb.bean;

public enum ResponseCode {
	
	LOGINSUCCESS("L500", "Login OK"),
	INVALIDUSERNAME("A401","Not a valid user"),
	INCORRECTPASSWORD("A400","Invalid password"),
	PAPERCREATED("P500", "Paper created");
	
	ResponseCode(String code, String desc){
		this.code = code;
		this.desc = desc;
	}
	
    String code;
	String desc;
	
	public String  getCode(){
		return this.code;
	}
	
	public String getDesc(){
		return this.desc;
	}

}
