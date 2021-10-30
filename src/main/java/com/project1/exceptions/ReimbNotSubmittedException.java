package com.project1.exceptions;

public class ReimbNotSubmittedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ReimbNotSubmittedException() {
		super("Reimbursement not submitted");
	}

	
}
