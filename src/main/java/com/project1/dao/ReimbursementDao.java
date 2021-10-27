package com.project1.dao;

import java.sql.SQLException;
import java.util.List;

import com.project1.models.Reimbursement;

public interface ReimbursementDao {

	List<Reimbursement> getAllReimbursements();
	
	Reimbursement getReimbursementByAuthor(int reimb_author);
	
	void createReimbursement(Reimbursement r) throws SQLException;
	
	void updateReimbursement(Reimbursement r);
	
	void deleteReimbursement(Reimbursement r);
	
}
