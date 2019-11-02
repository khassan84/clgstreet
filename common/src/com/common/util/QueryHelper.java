package com.common.util;

import java.util.List;

import com.common.constant.SqlKeyWord;

public class QueryHelper {
	
	public static String getWhereClauseToMatchAllWord(String colName,String line){
		List<String> words = StringUtil.getWords(line.toLowerCase());
		String likeClause = SQLUtil.createLikeClause(colName, words, SqlKeyWord.AND);
		System.out.println(likeClause);
		return likeClause;
	}
	
	public static String getWhereClauseToMatchAllCaseInsensitiveWord(String colName,String line){
		List<String> words = StringUtil.getWords(line.toLowerCase());
		String likeClause = SQLUtil.createCaseInsensitiveLikeClause(colName, words, SqlKeyWord.AND);
		System.out.println(likeClause);
		return likeClause;
	}
	

}
