package com.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project1.models.User;
import com.project1.utils.ConnectionUtil;

public class UserDaoDB implements UserDao {
	
ConnectionUtil conUtil = ConnectionUtil.getConUtil();
	
	@Override
	public List<User> getAllUsers() {
		
		List<User> userList = new ArrayList<User>();
		
		try {
	
			Connection con = conUtil.getCon();
			
			String sql = "SELECT * FROM ers_users";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
			
			return userList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public User getUserByUsername(String ers_username) {
		
		User user = new User();
		
		try {
			Connection con = conUtil.getCon();
			
			String sql = "SELECT * FROM ers_users WHERE ers_users.ers_username = '" + ers_username + "'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				user.setErs_users_id(rs.getInt(1));
				user.setErs_username(rs.getString(2));
				user.setErs_password(rs.getString(3));
				user.setUser_first_name(rs.getString(4));
				user.setUser_last_name(rs.getString(5));
				user.setUser_email(rs.getString(6));
				user.setUser_role_id(rs.getInt(7));
			}
			
			return user;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* @Override
	public void createApplication(Application a) throws SQLException {
		
		Connection con = conUtil.getCon();
		
		String sql = "INSERT INTO applications(username, password, firstN, lastN, ssn, email, openingBalance) values"
				+ "(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, a.getUsername());
		ps.setString(2, a.getPassword());
		ps.setString(3, a.getFirstN());
		ps.setString(4, a.getLastN());
		ps.setInt(5, a.getSsn());
		ps.setString(6, a.getEmail());
		ps.setDouble(7, a.getOpeningBalance());
		
		ps.execute();
		
	}
	
	@Override
	public void makeDeposit(double balance, int acctnum, double deposit) throws SQLException {
			
			Connection con = conUtil.getCon();
			
			String sql = "UPDATE users SET balance = balance + ?"  + "WHERE users.acctnum = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, deposit);
			ps.setInt(2, acctnum);
			
			ps.execute();
			
	}
	
	@Override
	public void makeWithdrawal(double balance, int acctnum, double withdrawal) throws SQLException {
		
		Connection con = conUtil.getCon();
		
		String sql = "UPDATE users SET balance = balance - ?"  + "WHERE users.acctnum = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setDouble(1, withdrawal);
		ps.setInt(2, acctnum);
		
		ps.execute();
		
	}

	@Override
	public void transfer(double balance, int acctnum, int recievingAcctnum, double transfer) throws SQLException {
		Connection con = conUtil.getCon();
		
		String sql = "UPDATE users SET balance = balance - ?"  + "WHERE users.acctnum = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setDouble(1, transfer);
		ps.setInt(2, acctnum);
		
		ps.execute();
	
		String sql2 = "UPDATE users SET balance = balance + ?"  + "WHERE users.acctnum = ?";
		
		PreparedStatement ps2 = con.prepareStatement(sql2);

		ps2.setDouble(1, transfer);
		ps2.setInt(2, recievingAcctnum);
		
		ps2.execute();
		
	} */


	@Override
	public void updateUser(User u) {
		
		try {
			Connection con = conUtil.getCon();
			String sql = "UPDATE users SET ers_username = ?, ers_password = ?, user_first_name = ?, user_last_name = ?, user_email = ?, user_role_id = ?"
					+ "WHERE ers_users.ers_users_id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, u.getErs_username());
			ps.setString(2, u.getErs_password());
			ps.setString(3, u.getUser_first_name());
			ps.setString(4, u.getUser_last_name());
			ps.setString(5, u.getUser_email());
			ps.setInt(6, u.getUser_role_id());
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteUser(User u) {

		try {
			Connection con = conUtil.getCon();
			String sql = "DELETE FROM ers_users WHERE ers_users_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u.getErs_users_id());
			ps.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
