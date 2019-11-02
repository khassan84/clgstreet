package com.bookstoredb.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.hibernate.Session;
//import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;

import com.bookstoredb.bean.ResponseCode;
import com.bookstoredb.bean.UserPasswordDO;
import com.bookstoredb.bean.UsersDO;
import com.bookstoredb.bean.to.LoginRequestTO;
import com.bookstoredb.bean.to.LoginResponseTO;
import com.bookstoredb.dao.impl.UsersDaoImpl;
import com.common.util.authentication.EncryptionUtils;
import com.commondboperation.exception.RollbackException;
import com.commondboperation.transaction.Transactional;

public class UserServiceImpl { // implements UserService{
	
	
/*	@Autowired
	private DataUtils dbUtils;*/
	
	@Autowired
	private UsersDaoImpl userDao;
	
	@Autowired
	UserServiceImpl usesrvice;
	

	//@Override
	@Transactional(rollbackOn={RuntimeException.class, RollbackException.class})
	public UsersDO createUser(Session session, UsersDO user, String password) {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl.createUser");
		
		try {
			userDao.createUser(session,user, password);
			//createUserPassword(user, password);
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return user;
	}


	//@Override
	public UserPasswordDO createUserPassword(UsersDO user, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Transactional(rollbackOn={RuntimeException.class, RollbackException.class})
	public String testOuterTransaction(Session session, UsersDO user){
		
		System.out.println("testOuterTransaction");
		System.out.println("user service hashcode "+ this.hashCode());
		System.out.println("injected user service hashcode "+ usesrvice.hashCode());
		usesrvice.testInerTransaction(null,null);
		if(true){
			throw new com.commondboperation.exception.RollbackException("");
		}
		
		return "xxxxx";
	}
	
	@Transactional(rollbackOn={RuntimeException.class})
	public String testInerTransaction(Session session, UsersDO user){
		System.out.println("testInerTransaction");
		if(true){
			throw new com.commondboperation.exception.RollbackException("test....");
		}
		return "";
	}
	
	
	public LoginResponseTO login(LoginRequestTO loginRequest){
		LoginResponseTO loginResponseTO = new LoginResponseTO();
		loginResponseTO.setUserName(loginRequest.getUserName());
		UsersDO usersDO = userDao.getUserByUserName(loginRequest.getUserName());
		UserPasswordDO userPassword = null;
		
		boolean validPassword = false;
		
		if(usersDO != null){
			userPassword= userDao.getUserPasswordByIdUser(usersDO.getId());
		}else{
			loginResponseTO.setResponseCode(ResponseCode.INVALIDUSERNAME.getCode());
			loginResponseTO.setResponseDesc(ResponseCode.INVALIDUSERNAME.getDesc());
			return loginResponseTO;
		}
		
		validPassword = EncryptionUtils.validatePassword(userPassword.getPassword(), loginRequest.getPassword(), userPassword.getKey());
		if(validPassword){
			loginResponseTO.setResponseCode(ResponseCode.LOGINSUCCESS.getCode());
			loginResponseTO.setResponseDesc(ResponseCode.LOGINSUCCESS.getDesc());
		}else{
			loginResponseTO.setResponseCode(ResponseCode.INCORRECTPASSWORD.getCode());
			loginResponseTO.setResponseDesc(ResponseCode.INCORRECTPASSWORD.getDesc());
			System.out.println("Password correct");
		}
		return loginResponseTO;
		
	}
	
}
