package com.project1.dao;

import java.sql.SQLException;
import java.util.List;

import com.project1.models.User;

public interface UserDao {
	
	List<User> getAllUsers();
	
	User getUserByUsername(String ers_username);
	
	//void createApplication(Application a) throws SQLException;
	
	//void makeDeposit(double balance, int acctnum, double deposit) throws SQLException;
	
	//void makeWithdrawal(double balance, int acctnum, double withdrawal) throws SQLException;
	
	//void transfer(double balance, int acctnum, int recievingAcctnum, double transfer) throws SQLException;
	
	void createUser (User u) throws SQLException;
	
	void updateUser(User u);
	
	void deleteUser(User u);

}
