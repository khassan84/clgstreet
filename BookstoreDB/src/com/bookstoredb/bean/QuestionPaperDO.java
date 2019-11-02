package com.bookstoredb.bean;

import java.io.Serializable;
import java.util.Date;

public class QuestionPaperDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4799191756089090955L;
	
	private Long id;
	private String userName;
	private Date createDate;
	private Date modifiedDate;
	private String targetEvent;
	private String paperName;
	private String data;
	private String description;
	private String info;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getTargetEvent() {
		return targetEvent;
	}
	public void setTargetEvent(String targetEvent) {
		this.targetEvent = targetEvent;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
}
