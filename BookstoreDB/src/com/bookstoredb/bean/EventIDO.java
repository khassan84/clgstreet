package com.bookstoredb.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EventIDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1869381134935969378L;

	
	private Long id;
	private String name;
	private Long idEventA;
	private Boolean processRequire;
	private Date processDate;
	private Date createDate;
	private Long idQuestionPaper;
	private Set<EventADO> eventA = new HashSet<EventADO>();  
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getIdEventA() {
		return idEventA;
	}
	public void setIdEventA(Long idEventA) {
		this.idEventA = idEventA;
	}
	public Long getIdQuestionPaper() {
		return idQuestionPaper;
	}
	public void setIdQuestionPaper(Long idQuestionPaper) {
		this.idQuestionPaper = idQuestionPaper;
	}
	public Set<EventADO> getEventA() {
		return eventA;
	}
	public void setEventA(Set<EventADO> eventA) {
		this.eventA = eventA;
	}
	
	
	
}
