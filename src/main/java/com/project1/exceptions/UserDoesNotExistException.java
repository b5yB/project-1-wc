package com.project1.exceptions;

public class UserDoesNotExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UserDoesNotExistException() {
		super("User tried logging in with credentials that don't exist");
	}
	
}
