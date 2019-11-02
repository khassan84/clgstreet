package com.bookstoredb.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.common.util.QueryHelper;
import com.commondboperation.exception.RollbackException;
import com.commondboperation.transaction.Transactional;

public class SearchServiceImpl {
	
	
	@Transactional(rollbackOn={RuntimeException.class, RollbackException.class})
	public String getSearchResult(Session session, String searchText){
		StringBuilder hql = new StringBuilder();
		StringBuilder likeClause = new StringBuilder();
		likeClause.append(QueryHelper.getWhereClauseToMatchAllCaseInsensitiveWord("name", searchText));
		hql.append("select content from EventADO where "+ likeClause.toString());
		Query query = session.createQuery(hql.toString());
		List<String> result = query.list();
		String content = result.get(0);
		return content;
	}
	
	@Transactional(rollbackOn={RuntimeException.class, RollbackException.class})
	public String getQuestionPaperContentById(Long  id){
		return null;
	}

}
