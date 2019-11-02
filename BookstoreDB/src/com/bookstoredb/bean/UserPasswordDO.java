package com.bookstoredb.bean;

import java.io.Serializable;
import java.util.Date;

public class UserPasswordDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9201158400800806488L;
	
	private Long id;
	private Date createDate;
	private Date modifiedDate;
	private String password;
	private String key;
	private Long idUser;
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

}
