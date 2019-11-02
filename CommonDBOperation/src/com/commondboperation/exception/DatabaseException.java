package com.commondboperation.exception;
public class DatabaseException extends Exception {
	private static final long serialVersionUID = 7938765461925036015L;

	
	public DatabaseException(String message) {
		super(message);
	}
	
	public DatabaseException(Exception e) {
		super(e);
	}
	
	public DatabaseException(Exception e, String message) {
		super(message, e);
	}
	
}