package com.project1.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.project1.dao.UserDao;
import com.project1.exceptions.InvalidCredentialsException;
import com.project1.exceptions.UsernameAlreadyExistsException;
import com.project1.logging.Logging;
import com.project1.models.User;

public class UserService {
	
	private UserDao uDao;
	
	public UserService(UserDao u) {
		this.uDao = u;
	}
	
	/* public Application apply(String username, String password, String firstN, String lastN, int ssn, String email, double openingBalance) throws UsernameAlreadyExistsException {
		
		Application a = new Application(username, password, firstN, lastN, ssn, email, openingBalance);
		
		try {
			uDao.createApplication(a);
			Logging.logger.info("New application was submitted");
		} catch (SQLException e) {
			e.printStackTrace();
			Logging.logger.warn("Username created that already exists in the database");
			throw new UsernameAlreadyExistsException();
		}
		
		return a;
	} */
	
	public User logIn(String ers_username, String ers_password) throws InvalidCredentialsException{
		
		User u = uDao.getUserByUsername(ers_username);
		
		if(!u.getErs_password().equals(ers_password)) {
			Logging.logger.warn("User tried to login with invalid credentials");
			throw new InvalidCredentialsException();
		}
		else {
			Logging.logger.info("User was logged in");
			return u;
		}
	}
	
	/* public void userDashboard(String username) {
		boolean done = false;
		User u = uDao.getUserByUsername(username);
		
		while (done != true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please press '1' to access account, '2' to update account information, or '3' to logout."); 
			int choice = Integer.parseInt(scan.nextLine());
			if (choice == 1) {
				
				System.out.println("Please press '1' to view balance, '2' for deposits/withdrawals, or '3' to transfer funds.");
				int choice2 = Integer.parseInt(scan.nextLine());
				if (choice2 == 1) {
					
					try {
						System.out.println("Your account balance is: " + u.getBalance());
						continue;
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
				else if(choice2 == 2) {
					System.out.println("Please press '1' to make a deposit or '2' to make a withdrawal");
					int choice3 = Integer.parseInt(scan.nextLine());
					if(choice3 == 1) {
						double balance = u.getBalance();
						System.out.println("Please enter your account number: ");
						int acctnum = Integer.parseInt(scan.nextLine());
						System.out.println("Please enter the amount of your deposit: ");
						double deposit = Double.parseDouble(scan.nextLine());
						try {
							uDao.makeDeposit(balance, acctnum, deposit);
							Logging.logger.info("Deposit succesful");
							continue;
						}
						catch(Exception e) {
							e.printStackTrace();
						}
					}
					else if (choice3 == 2) {
						
						double balance = u.getBalance();
						System.out.println("Please enter your account number: ");
						int acctnum = Integer.parseInt(scan.nextLine());
						System.out.println("Please enter the amount of your withdrawal: ");
						double withdrawal = Double.parseDouble(scan.nextLine());
						try {
							uDao.makeWithdrawal(balance, acctnum, withdrawal);
							Logging.logger.info("Withdrawal succesful");
							continue;
						}
						catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
				else if (choice2 == 3) {
					double balance = u.getBalance();
					System.out.println("Please enter your account number: ");
					int acctnum = Integer.parseInt(scan.nextLine());
					System.out.println("Please enter the recieving account number: ");
					int recievingAcctnum = Integer.parseInt(scan.nextLine());
					System.out.println("Please enter the amount of your transfer: ");
					double transfer = Double.parseDouble(scan.nextLine());
					try {
						uDao.transfer(balance, acctnum, recievingAcctnum, transfer);
						Logging.logger.info("Transfer succesful");
						continue;
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			else if (choice == 2) {
				
			}
			else {
				Logging.logger.info("User was logged out");
				System.out.println("Goodbye, " + username);
				done = true;
			}
		scan.close();
		}
	} */
	

}
