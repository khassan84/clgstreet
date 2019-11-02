package com.bookstoredb.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EventADO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3409183778992636335L;
	
	
	private Long id;
	private String name;
	private String idRack;
	private String idFiles;
	private String content;
	private Boolean processRequire;
	private Date processDate;
	//private Long idEventI;
	//private Set<EventIDO> eventI = new HashSet<EventIDO>();
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
	public String getIdRack() {
		return idRack;
	}
	public void setIdRack(String idRack) {
		this.idRack = idRack;
	}
	public String getIdFiles() {
		return idFiles;
	}
	public void setIdFiles(String idFiles) {
		this.idFiles = idFiles;
	}
	/*public Long getIdEventI() {
		return idEventI;
	}
	public void setIdEventI(Long idEventI) {
		this.idEventI = idEventI;
	}*/
	public Boolean getProcessRequire() {
		return processRequire;
	}
	public void setProcessRequire(Boolean processRequire) {
		this.processRequire = processRequire;
	}
	public Date getProcessDate() {
		return processDate;
	}
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
	
}
