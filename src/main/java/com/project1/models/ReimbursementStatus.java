package com.project1.models;

public class ReimbursementStatus {
	
	/* reimb_status_id int primary key generated always as identity not null,
	reimb_status varchar(10) not null */
	
	private int reimb_status_id;
	private String reimb_status;
	
	public ReimbursementStatus() {
		
	}

	//to db
	public ReimbursementStatus(String reimb_status) {
		//super();
		this.reimb_status = reimb_status;
	}

	//from db
	public ReimbursementStatus(int reimb_status_id, String reimb_status) {
		//super();
		this.reimb_status_id = reimb_status_id;
		this.reimb_status = reimb_status;
	}

	public int getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [reimb_status_id=" + reimb_status_id + ", reimb_status=" + reimb_status + "]";
	}

}
