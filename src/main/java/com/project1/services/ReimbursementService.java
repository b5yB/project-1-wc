package com.project1.services;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.project1.dao.ReimbursementDao;
import com.project1.dao.UserDao;
import com.project1.exceptions.InvalidCredentialsException;
import com.project1.exceptions.ReimbNotSubmittedException;
import com.project1.exceptions.UserDoesNotExistException;
import com.project1.logging.Logging;
import com.project1.models.Reimbursement;
import com.project1.models.User;

public class ReimbursementService {
	
	private ReimbursementDao rDao;
	
	public ReimbursementService(ReimbursementDao r) {
		this.rDao = r;
	}
	
	public Reimbursement retrieveUserReimbursements(User u) {
		return rDao.getReimbursementByAuthor(u.getErs_users_id());
	}
	
	public Reimbursement retrievePendingReimbursements() {
		int reimb_status = 1;
		return rDao.getReimbursementByStatus(reimb_status);
	}
	
	public void approveReimbursement(User u, int reimb_id) {
		Reimbursement r = rDao.getReimbursementById(reimb_id);
		
		r.setReimb_status_id(2);
		r.setReimb_resolver(u.getErs_users_id());
		
		rDao.updateReimbursement(r);
	}
	
	public void denyReimbursement(User u, int reimb_id) {
		Reimbursement r = rDao.getReimbursementById(reimb_id);
		
		r.setReimb_status_id(3);
		r.setReimb_resolver(u.getErs_users_id());
		
		rDao.updateReimbursement(r);
	}
	
	public Reimbursement submitReimbursement(int reimb_amount, String reimb_description,
			int reimb_author, int reimb_type_id) {
		
		Reimbursement r = new Reimbursement(reimb_amount, reimb_description, reimb_author, 1, reimb_type_id);
		
		rDao.createReimbursement(r);
		
		Logging.logger.info("Reimbursement submitted");
		return r;
		
	}
	
	public List<Reimbursement> retrievAllReimbursements(){
		return rDao.getAllReimbursements();
	}
	

}
