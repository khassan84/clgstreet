package com.common.constant;

public enum SqlKeyWord {
	AND ("and"),
	OR("or"),
	PERCENT("%"),
	LIKE("like"),
	ILIKE("ilike");
	
	private String keyword;
	
	SqlKeyWord(String keyword) {
		this.keyword = keyword;
	}
	
	public String getKeyWord(){
		return keyword;
	}
}
