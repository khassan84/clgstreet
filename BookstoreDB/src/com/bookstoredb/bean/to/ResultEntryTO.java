package com.bookstoredb.bean.to;

import java.io.Serializable;

public class ResultEntryTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4310029488687140510L;
	
	
	private String name;
	private String preparedBy;
	//private String code;
	private Long code;
	private String info;
	private String age;
	
	
	public ResultEntryTO(String name, String preparedBy, Long code
			/*String info, String age*/) {
		super();
		this.name = name;
		this.preparedBy = preparedBy;
		this.code = code;
		//this.info = info;
		//this.age = age;
	}
	public ResultEntryTO(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPreparedBy() {
		return preparedBy;
	}
	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}
	
}
