package com.bookstoredb.service.impl;

import java.util.Date;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookstoredb.bean.EventIDO;
import com.bookstoredb.bean.QuestionPaperDO;
import com.bookstoredb.bean.to.CustomQuestionPaperTO;
import com.bookstoredb.dao.impl.EventDaoImpl;
import com.bookstoredb.dao.impl.PaperDaoImpl;
import com.commondboperation.exception.RollbackException;
import com.commondboperation.transaction.Transactional;

public class PaperServiceImpl {
	
	@Autowired
	EventDaoImpl eventDaoImpl;
	
	@Autowired
	PaperDaoImpl paperDao;
	
	@Autowired
	PaperServiceImpl paperServiceImpl;
	
	@Transactional(rollbackOn={RuntimeException.class, RollbackException.class})
	public QuestionPaperDO savePaper(Session session, QuestionPaperDO paperDO){
		System.out.println("PaperServiceImpl  savePaper");
		paperDao.savePaper(session, paperDO);
		
		EventIDO eventIdo =  new EventIDO();
		eventIdo.setName(paperDO.getPaperName());
		eventIdo.setIdQuestionPaper(paperDO.getId());
		eventIdo.setCreateDate(new Date());
		eventIdo.setProcessRequire(Boolean.TRUE);
		
		eventDaoImpl.createEventI(session, eventIdo);
		
		return paperDO ;
	}
	
	@Transactional(rollbackOn={RuntimeException.class, RollbackException.class})
	public CustomQuestionPaperTO getPaperById(Session session,Long id){
		return paperDao.getPaperById(session, id);
	}

}
