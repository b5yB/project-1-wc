package com.project1.usertests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import com.project1.dao.UserDao;
import com.project1.exceptions.InvalidCredentialsException;
import com.project1.exceptions.UserDoesNotExistException;
import com.project1.models.User;
import com.project1.services.UserService;

public class VerifyUserCredentialsTest {
	
	@InjectMocks
	public UserService uServ;
	
	@Mock
	public UserDao uDao;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	/*
	int ers_users_id;
	String ers_username;
	String ers_password;
	String user_first_name;
	String user_last_name;
	String user_email;
	int user_role_id;
	*/
	
	@Test
	public void testValidLogin() {
		User u = new User(1, "test", "pass", "first", "last", "test@mail.com", 1);
		
		when(uDao.getUserByUsername(anyString())).thenReturn(u);
		
		User uVerified = uServ.verifyLoginCredentials("test", "pass");
		
		assertEquals(u.getErs_users_id(), uVerified.getErs_users_id());
	}
	
	@Test(expected = UserDoesNotExistException.class)
	public void testInvalidUsername() {
		User u = new User(0, "test", "pass", "first", "last", "test@mail.com", 1);
		
		when(uDao.getUserByUsername(anyString())).thenReturn(u);
		
		uServ.verifyLoginCredentials("nottest", "pass");
		
	}
	
	@Test(expected = InvalidCredentialsException.class)
	public void testInvalidPassword() {
		User u = new User(1, "test", "pass", "first", "last", "test@mail.com", 1);
		
		when(uDao.getUserByUsername(anyString())).thenReturn(u);
		
		uServ.verifyLoginCredentials("test", "notpass");
	}
	
}
