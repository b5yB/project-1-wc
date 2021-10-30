package com.project1.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.dao.ReimbursementDao;
import com.project1.dao.ReimbursementDaoDB;
import com.project1.dao.UserDao;
import com.project1.dao.UserDaoDB;
import com.project1.models.Reimbursement;
import com.project1.services.ReimbursementService;
import com.project1.services.UserService;

public class EmployeeReimbursementsController {
	
	private static UserDao uDao = new UserDaoDB();
	private static UserService uServ = new UserService(uDao);
	private static ReimbursementDao rDao = new ReimbursementDaoDB();
	private static ReimbursementService rServ = new ReimbursementService(rDao);

	public static void employeeReimbursements(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {

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
		
		int author_id = parsedObj.get("author_id").asInt();
		
		List<Reimbursement> reimbursements = rServ.getEmployeeReimbursements(author_id);
		
		res.getWriter().write(new ObjectMapper().writeValueAsString(reimbursements));
		/*
		try {
			
		} 
		catch(Exception e) {
			res.setStatus(418);
			res.getWriter().println("No reimbursements for given employee");
		}
		*/
		
	}

}
