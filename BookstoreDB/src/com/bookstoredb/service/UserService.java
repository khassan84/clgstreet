package com.bookstoredb.service;
import com.bookstoredb.bean.UserPasswordDO;
import com.bookstoredb.bean.UsersDO;
import com.commondboperation.transaction.Transactional;


public interface UserService {
	
	@Transactional
	public UsersDO createUser(UsersDO user, String password);
	
	public UserPasswordDO createUserPassword(UsersDO user, String password);

}
