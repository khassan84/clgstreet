package com.bookstoredb.exception;

public class MissingMandatoryDataException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 667761068659506590L;
	
	
	private String message;
	
	public MissingMandatoryDataException(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
