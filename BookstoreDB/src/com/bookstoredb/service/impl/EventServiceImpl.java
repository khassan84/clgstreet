package com.bookstoredb.service.impl;

import org.hibernate.Session;

import com.bookstoredb.bean.EventIDO;
import com.commondboperation.exception.RollbackException;
import com.commondboperation.transaction.Transactional;

public class EventServiceImpl {
	
	@Transactional(rollbackOn={RuntimeException.class, RollbackException.class})
	public void createEventI(Session session, EventIDO eventIDO){
		
	}

}
