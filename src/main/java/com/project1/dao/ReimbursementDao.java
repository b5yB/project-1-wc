package com.project1.dao;

import java.sql.SQLException;
import java.util.List;

import com.project1.models.Reimbursement;

public interface ReimbursementDao {

	void createReimbursement(Reimbursement r);
	
	void updateReimbursement(Reimbursement r);
	
	void deleteReimbursement(int reimb_id);

	Reimbursement getReimbursementByStatus(int reimb_status);
	
	Reimbursement getReimbursementByAuthor(int reimb_author);
	
	Reimbursement getReimbursementById(int reimb_id);
	
	List<Reimbursement> getAllReimbursements();	

	
}
