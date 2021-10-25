package com.project1.models;

public class ReimbursementType {
	
	/* reimb_type_id int primary key generated always as identity not null,
	reimb_type varchar(10) not null */
	
	private int reimb_type_id;
	private String reimb_type;
	
	public ReimbursementType() {
		
	}

	//to db
	public ReimbursementType(String reimb_type) {
		//super();
		this.reimb_type = reimb_type;
	}

	//from db
	public ReimbursementType(int reimb_type_id, String reimb_type) {
		//super();
		this.reimb_type_id = reimb_type_id;
		this.reimb_type = reimb_type;
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}

	public String getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}

	@Override
	public String toString() {
		return "ReimbursementType [reimb_type_id=" + reimb_type_id + ", reimb_type=" + reimb_type + "]";
	}
	
}
