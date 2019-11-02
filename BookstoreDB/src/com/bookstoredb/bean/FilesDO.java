package com.bookstoredb.bean;

import java.io.Serializable;
import java.util.Date;

public class FilesDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1515118330957928770L;
	
	private Long id;
	private String name;
	private String aggregatedBy;
	private Date createDate;
	private Date updateDate;
	private String content;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAggregatedBy() {
		return aggregatedBy;
	}
	public void setAggregatedBy(String aggregatedBy) {
		this.aggregatedBy = aggregatedBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
