package com.book.client.bean;

public class DispatchBookTO {

	public String tittle;
	// url of the book , could be from local directory or S3
	public String source;
	// optional parameter could be used in future to get content whenn source is null
	public String code;
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	
}
