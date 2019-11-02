package com.bookstoredb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookstoredb.bean.QuestionPaperDO;
import com.bookstoredb.bean.ResponseCode;
import com.bookstoredb.bean.to.CustomQuestionPaperTO;
import com.bookstoredb.bean.to.ResponseTO;
import com.bookstoredb.dao.PaperDao;
import com.bookstoredb.service.impl.EventServiceImpl;

public class PaperDaoImpl implements PaperDao{
	
	@Autowired
	EventServiceImpl eventServiceImpl ;
	
	@Autowired
	EventDaoImpl eventDaoImpl;

	@Override
	public QuestionPaperDO savePaper(Session session, QuestionPaperDO paperDO) {
		System.out.println("===============");
		session.save(paperDO);
		ResponseTO responseTO = new ResponseTO();
		responseTO.setResponseCode(ResponseCode.PAPERCREATED.getCode());
		responseTO.setResponseMessage(ResponseCode.PAPERCREATED.getDesc());
		
		return paperDO;
	}

	@Override
	public CustomQuestionPaperTO getPaperById(Session session,Long id) {
		// TODO Auto-generated method stub
		Query query = session.getNamedQuery("find_paper_by_id");
		query.setLong("id", id);
		CustomQuestionPaperTO customQuestionPaperTO = null;
		List<CustomQuestionPaperTO> customQuestionPaperTOs =  query.list();
		if(customQuestionPaperTOs != null && !customQuestionPaperTOs.isEmpty()){
			customQuestionPaperTO = customQuestionPaperTOs.get(0);
		}
		return customQuestionPaperTO;
	}

}
