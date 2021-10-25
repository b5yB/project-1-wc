package com.project1.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project1.controllers.LoginController;

public class Dispatcher {
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		
		System.out.println("In the servlet dispatcher with URI: " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
			case "/Project-1/api/login":
				LoginController.logIn(req, res);
				break;
			
		}
	}

}
