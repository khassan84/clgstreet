package com.bookstoredb.bean;

import java.io.Serializable;
import java.util.Date;

public class RackDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2139161220426843420L;

	
	private Long id;
	private String name;
	private String content;
	private Long idRack;
	private String idFiles;
	private String idPapers;
	private Date createDate;
	private Date updateDate;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getIdRack() {
		return idRack;
	}
	public void setIdRack(Long idRack) {
		this.idRack = idRack;
	}
	public String getIdFiles() {
		return idFiles;
	}
	public void setIdFiles(String idFiles) {
		this.idFiles = idFiles;
	}
	public String getIdPapers() {
		return idPapers;
	}
	public void setIdPapers(String idPapers) {
		this.idPapers = idPapers;
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
	
	
}
