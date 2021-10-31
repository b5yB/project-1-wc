package com.project1.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.dao.ReimbursementDao;
import com.project1.dao.ReimbursementDaoDB;
import com.project1.dao.UserDao;
import com.project1.dao.UserDaoDB;
import com.project1.models.Reimbursement;
import com.project1.services.ReimbursementService;
import com.project1.services.UserService;

public class PendingReimbursementsController {
	
	private static UserDao uDao = new UserDaoDB();
	private static UserService uServ = new UserService(uDao);
	private static ReimbursementDao rDao = new ReimbursementDaoDB();
	private static ReimbursementService rServ = new ReimbursementService(rDao);

	public static void pendingReimbursements(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		StringBuilder buffer = new StringBuilder();
		
		BufferedReader reader = req.getReader();
		
		String line;
		while ((line = reader.readLine()) != null) {
			
			buffer.append(line);
			buffer.append(System.lineSeparator());
				
		}
		
		String data = buffer.toString();
		System.out.println(data);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode parsedObj = mapper.readTree(data);
		
		List<Reimbursement> reimbursements = rServ.retrievePendingReimbursements();
		
		res.getWriter().write(new ObjectMapper().writeValueAsString(reimbursements));
		
		int reimb_status_id = parsedObj.get("reimb_status_id").asInt();

		
		if (reimb_status_id == 2) {
			int ers_users_id = parsedObj.get("ers_users_id").asInt();
			int reimb_id = parsedObj.get("reimb_id").asInt();
			
			rServ.approveReimbursement(ers_users_id, reimb_id);
		}
		else if (reimb_status_id == 3) {
			int ers_users_id = parsedObj.get("ers_users_id").asInt();
			int reimb_id = parsedObj.get("reimb_id").asInt();
			
			rServ.denyReimbursement(ers_users_id, reimb_id);
		}
		/*
		Double reimb_amount = parsedObj.get("reimb_amount").asDouble();
		String reimb_description = parsedObj.get("reimb_description").asText();
		int reimb_author = parsedObj.get("reimb_author").asInt();
		int reimb_type_id = parsedObj.get("reimb_type_id").asInt();
		Reimbursement r = new Reimbursement(reimb_amount, reimb_description, reimb_author, 1, reimb_type_id);
		
		try {
			System.out.println("Creating reimbursement");
			rServ.submitReimbursement(reimb_amount, reimb_description, reimb_author, 1, reimb_type_id);
			res.setStatus(200);
			res.getWriter().write(new ObjectMapper().writeValueAsString(r));
			System.out.println("Reimbursement created");
		} 
		catch(Exception e) {
			res.setStatus(418);
			res.getWriter().println("Reimbursement not submitted");
		}
		*/
	}

}
