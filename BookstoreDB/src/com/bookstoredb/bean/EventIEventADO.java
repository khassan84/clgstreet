package com.bookstoredb.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class EventIEventADO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6091705647291281626L;
	
	private Long id;
	//private Set eventI;
	//private EventADO eventADO;
	private Long idEventI;
	private Long idEventA;
	private Date createDate;
	private Date modifiedDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getIdEventI() {
		return idEventI;
	}
	public void setIdEventI(Long idEventI) {
		this.idEventI = idEventI;
	}
	public Long getIdEventA() {
		return idEventA;
	}
	public void setIdEventA(Long idEventA) {
		this.idEventA = idEventA;
	}
	
	
}
