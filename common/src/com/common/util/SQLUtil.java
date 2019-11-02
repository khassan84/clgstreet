package com.common.util;

import java.util.List;

import com.common.constant.CommonConstants;
import com.common.constant.SqlKeyWord;

public class SQLUtil {
	
	private static String space = CommonConstants.SPACE ;
	private static String SINGEL_QUOTE = CommonConstants.SINGEL_QUOTE ;
	private static String percent =  SqlKeyWord.PERCENT.getKeyWord();

	
	public static String createCaseInsensitiveLikeClause(String colName, List<String> values, SqlKeyWord keyWord){
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		if(colName != null && !colName.isEmpty() && !values.isEmpty()){
			for(String value : values){
				if(flag){
					sb.append(space +keyWord +space);
				}
				flag = true;
				sb.append(space+"lower("+colName+ ")"+ space + SqlKeyWord.LIKE + space+SINGEL_QUOTE+percent + value + percent+SINGEL_QUOTE);
			}
		}
		return sb.toString();
	}
	public static String createLikeClause(String colName, List<String> values, SqlKeyWord keyWord){
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		if(colName != null && !colName.isEmpty() && !values.isEmpty()){
			for(String value : values){
				if(flag){
					sb.append(space +keyWord +space);
				}
				flag = true;
				sb.append(space+colName+  space + SqlKeyWord.LIKE + space+SINGEL_QUOTE+percent + value + percent+SINGEL_QUOTE);
			}
		}
		return sb.toString();
	}
	
	
	public static String createIlikeClause(String colName, List<String> values, SqlKeyWord keyWord){
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		if(colName != null && !colName.isEmpty() && !values.isEmpty()){
			for(String value : values){
				if(flag){
					sb.append(space +keyWord +space);
				}
				flag = true;
				sb.append(space+colName+ space + SqlKeyWord.ILIKE + space+SINGEL_QUOTE+percent + value + percent+SINGEL_QUOTE);
			}
		}
		return sb.toString();
	}
}
