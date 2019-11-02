package com.commondboperation.exception;

public class RollbackException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String message = null;
	
	public RollbackException(String message){
		this.message = message;
	}
	
	
	public String getMessage() {
		return message;
	}

	
	
}
