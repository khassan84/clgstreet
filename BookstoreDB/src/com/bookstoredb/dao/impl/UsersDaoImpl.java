package com.bookstoredb.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
//import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookstoredb.bean.UserPasswordDO;
import com.bookstoredb.bean.UsersDO;
import com.bookstoredb.dao.UsersDao;
import com.bookstoredb.exception.MissingMandatoryDataException;
import com.common.util.Utility;
import com.common.util.authentication.EncryptionUtils;
import com.commondboperation.util.DataUtils;

public class UsersDaoImpl implements UsersDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private DataUtils dbUtils;
	
	/*public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

	//@Override
	public UsersDO createUser(Session session, UsersDO user, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, RuntimeException{
		System.out.println("UsersDaoImpl.createUser");
		System.out.println(" hash code of session :" + session.hashCode());
		Long id = (Long) session.save(user);
		user.setId(id);
		UserPasswordDO passwordDO = generateUserPasswordDO(password);
		passwordDO.setIdUser(id);
		session.save(passwordDO);
		return user;
	}
	
	
	//@Override
	//@Transactional
	public UsersDO createUser2(Session session, UsersDO user, String password) throws  NoSuchAlgorithmException{
		System.out.println("UsersDaoImpl.createUser");
		//Long id = dbUtils.saveDataToDB(user);
		//Session session = sessionFactory.openSession();
		System.out.println(" hash code of session :" + session.hashCode());
		Transaction tx = session.beginTransaction();
		
		
		//Long id = dbUtils.saveDataToDBNoCommit(user);
		Long id = (Long) session.save(user);
		user.setId(id);
		UserPasswordDO passwordDO = null;
		try {
			passwordDO = generateUserPasswordDO(password);
			passwordDO.setIdUser(id);
			dbUtils.getException(null);
			dbUtils.saveDataToDBNoCommit(passwordDO);
			tx.commit();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.flush();
			session.close();

		}
		return user;
	}

	//@Override
	public UserPasswordDO createUserPassword(Session session, UsersDO user, String encriptedPassword, String flavour) {
		Boolean created = false;
		UserPasswordDO passwordDO = new UserPasswordDO();
		if(Utility.isEmpty(flavour, encriptedPassword)){
			String message = null;
			if(Utility.isEmpty(encriptedPassword)){
				message = " Password missing";
			}
			throw new MissingMandatoryDataException("Password creation Exception : "+message);
		}
		passwordDO.setKey(flavour);
		passwordDO.setPassword(encriptedPassword);
		passwordDO.setCreateDate(new Date());
		Long id = (Long) session.save(passwordDO);
		passwordDO.setId(id);
		if(id!= null && id != 0){
			created = true;
		}
		return Utility.isEmpty(id) ? null : passwordDO;
	}
	
	
	private UserPasswordDO generateUserPasswordDO(String plainPassword) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		
		UserPasswordDO passwordDO = new UserPasswordDO();
		String flavour = EncryptionUtils.generateSalt();
		passwordDO.setKey(flavour);
		String encriptedPassword = EncryptionUtils.generateSHA1Password(plainPassword, flavour);
		passwordDO.setPassword(encriptedPassword);
		passwordDO.setCreateDate(new Date());
		
		return passwordDO;
	}


	@Override
	public UsersDO getUserByUserName(String UserName) {
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("get_user_by_user_name");
		query.setString("userName", UserName);
		
		UsersDO usersDO = (UsersDO) query.uniqueResult();
		session.disconnect();
		System.out.println("usersDO :" + usersDO);
		return usersDO;
	}


	@Override
	public UserPasswordDO getUserPasswordByIdUser(Long idUser) {
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("get_password_by_id");
		query.setLong("idUser", idUser.longValue());
		UserPasswordDO passwordDOs = (UserPasswordDO) query.uniqueResult();
		session.disconnect();
		System.out.println("passwordDOs :" + passwordDOs);
		return passwordDOs;
	}
	


}
