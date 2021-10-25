package com.project1.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException {
	
private static final long serialVersionUID = 1L;
	
	public UsernameAlreadyExistsException() {
		super("A username was created that already exists in the database");
	}

}
