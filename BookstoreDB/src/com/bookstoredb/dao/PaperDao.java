package com.bookstoredb.dao;

import org.hibernate.Session;

import com.bookstoredb.bean.QuestionPaperDO;
import com.bookstoredb.bean.to.CustomQuestionPaperTO;
import com.bookstoredb.bean.to.ResponseTO;

public interface PaperDao {
	public QuestionPaperDO savePaper(Session session, QuestionPaperDO paperDO) ;
	public CustomQuestionPaperTO getPaperById(Session session,Long id);

}
