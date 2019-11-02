package com.bookstoredb.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.hibernate.Session;

import com.bookstoredb.bean.UserPasswordDO;
import com.bookstoredb.bean.UsersDO;

public interface UsersDao {
	public UsersDO createUser(Session session, UsersDO user, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException;
	public UserPasswordDO createUserPassword(Session session,UsersDO user, String encriptedPassword, String flavour);
	public UsersDO getUserByUserName(String UserName);
	public UserPasswordDO getUserPasswordByIdUser(Long idUser);
	
}
