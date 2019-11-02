package com.commondboperation.miscallenous;


/**
 * @author Kamal Hassan
 *
 */
public class QueryParam {
	
	
	private String paramName;
	private Object paramValue;
	private Object paramType;
	
	
	public QueryParam(String paramName, Object paramValue, Object paramType) {
		super();
		this.paramName = paramName;
		this.paramValue = paramValue;
		this.paramType = paramType;
	}
	
	
	public String getParamName() {
		return paramName;
	}
	public Object getParamValue() {
		return paramValue;
	}
	public Object getParamType() {
		return paramType;
	}

}
