package com.project1.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.dao.UserDao;
import com.project1.dao.UserDaoDB;
import com.project1.models.User;
import com.project1.services.UserService;

public class LoginController {
	
	private static UserDao uDao = new UserDaoDB();
	private static UserService uServ = new UserService(uDao);
	
	public static void logIn(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		
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
		
		String ers_username = parsedObj.get("username").asText();
		String ers_password = parsedObj.get("password").asText();
		
		try {
			System.out.println("Login Controller");
			User u = uServ.logIn(ers_username, ers_password);
			System.out.println(u);
			req.getSession().setAttribute("id", u.getErs_users_id());
			res.setStatus(200);
			res.getWriter().write(new ObjectMapper().writeValueAsString(u));
			
		} catch(Exception e) {
			res.setStatus(403);
			res.getWriter().println("Username or password incorrect");
		}
		
	}
	
}
