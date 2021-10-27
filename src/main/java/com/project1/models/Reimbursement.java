package com.project1.models;

import java.sql.Blob;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Reimbursement {
	
	/* reimb_id int primary key generated always as identity,
	reimb_amount int not null unique,
	reimb_submitted timestamp with time zone not null, 
	reimb_resolved timestamp with time zone,
	reimb_description varchar (250),
	reimb_receipt bytea,
	reimb_author int references ers_users(ers_users_id) not null,
	reimb_resolver int references ers_users(ers_users_id),
	reimb_status_id int  references ers_reimbursement_status(reimb_status_id) not null,
	reimb_type_id int references ers_reimbursement_type(reimb_type_id) not null */
	
	private int reimb_id;
	private Double reimb_amount;
	private Timestamp reimb_submitted;
	private Timestamp reimb_resolved;
	private String reimb_description;
	//private Blob reimb_receipt;
	private int reimb_author;
	private int reimb_resolver;
	private int reimb_status_id;
	private int reimb_type_id;
	
	public Reimbursement() {
		
	}
	
	//to db
	public Reimbursement(Double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved, String reimb_description,
			int reimb_author, int reimb_status_id, int reimb_type_id) {
		//super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		//this.reimb_receipt = reimb_receipt;
		this.reimb_author = reimb_author;
		//this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}
	
	//from db
	public Reimbursement(int reimb_id, Double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, int reimb_author, int reimb_resolver, int reimb_status_id,
			int reimb_type_id) {
		//super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		//this.reimb_receipt = reimb_receipt;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}
	
	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}
	
	public Double getReimb_amount() {
		return reimb_amount;
	}
	
	public void setReimb_amount(Double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}
	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}
	public Timestamp getReimb_resolved() {
		return reimb_resolved;
	}
	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}
	public String getReimb_description() {
		return reimb_description;
	}
	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}
	//public Blob getReimb_receipt() {
	//	return reimb_receipt;
	//}
	//public void setReimb_receipt(Blob reimb_receipt) {
	//	this.reimb_receipt = reimb_receipt;
	//}
	public int getReimb_author() {
		return reimb_author;
	}
	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}
	public int getReimb_resolver() {
		return reimb_resolver;
	}
	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}
	public int getReimb_status_id() {
		return reimb_status_id;
	}
	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}
	public int getReimb_type_id() {
		return reimb_type_id;
	}
	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_author=" + reimb_author + ", reimb_resolver="
				+ reimb_resolver + ", reimb_status_id=" + reimb_status_id + ", reimb_type_id=" + reimb_type_id + "]";
	}
	
}
