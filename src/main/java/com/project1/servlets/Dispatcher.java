package com.project1.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project1.controllers.PendingReimbursementsController;
import com.project1.controllers.CreateReimbursementController;
import com.project1.controllers.EmployeeReimbursementsController;
import com.project1.controllers.LoginController;
import com.project1.controllers.ViewEmployeesController;

public class Dispatcher {
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		
		System.out.println("In the servlet dispatcher with URI: " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
			case "/Project-1/api/login":
				LoginController.logIn(req, res);
				break;
				
			case "/Project-1/api/createReimbursement":
				CreateReimbursementController.createReimbursement(req, res);
				break;
			
			case "Project-1/api/employeeReimbursements":
				EmployeeReimbursementsController.employeeReimbursements(req, res);
				break;
				
			case "Project-1/api/pendingReimbursements":
				PendingReimbursementsController.pendingReimbursements(req, res);
				break;
				
			case "Project-1/api/viewEmployees":
				ViewEmployeesController.viewEmployees(req, res);
				break;
		}
	}

}
