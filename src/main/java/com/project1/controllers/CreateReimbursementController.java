package com.project1.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project1.dao.ReimbursementDao;
import com.project1.dao.ReimbursementDaoDB;
import com.project1.dao.UserDao;
import com.project1.dao.UserDaoDB;
import com.project1.models.Reimbursement;
import com.project1.models.User;
import com.project1.services.ReimbursementService;
import com.project1.services.UserService;

public class CreateReimbursementController {

	private static UserDao uDao = new UserDaoDB();
	private static UserService uServ = new UserService(uDao);
	private static ReimbursementDao rDao = new ReimbursementDaoDB();
	private static ReimbursementService rServ = new ReimbursementService(rDao);
	
	public static void createReimbursement(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		
		System.out.println("In create reimbursement controller");
		
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
		
		int reimb_amount = parsedObj.get("reimb_amount").asInt();
		String reimb_description = parsedObj.get("reimb_description").asText();
		int reimb_author = parsedObj.get("reimb_author").asInt();
		int reimb_type_id = parsedObj.get("reimb_type_id").asInt();
		
		
		try {
			System.out.println("Creating reimbursement");
			Reimbursement r = rServ.submitReimbursement(reimb_amount, reimb_description, reimb_author, reimb_type_id);
			res.setStatus(200);
			
			/*
			ObjectNode ret = mapper.createObjectNode();
			ret.put("message", "Reimbursement created");
			
			res.getWriter().write(new ObjectMapper().writeValueAsString(ret));
			*/
			
			res.getWriter().write(new ObjectMapper().writeValueAsString(r));
			System.out.println("Reimbursement created");
		} 
		catch(Exception e) {
			res.setStatus(418);
			res.getWriter().println("Reimbursement not submitted");
		}
		
	}

}
