package com.project1.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


import com.project1.models.Reimbursement;
import com.project1.utils.ConnectionUtil;

public class ReimbursementDaoDB implements ReimbursementDao {
	
	/*
	int reimb_id;
	int reimb_amount;
	String reimb_submitted;
	String reimb_resolved;
	String reimb_description;
	Blob reimb_receipt;
	int reimb_author;
	int reimb_resolver;
	int reimb_status_id;
	int reimb_type_id;
	*/
	
	ConnectionUtil conUtil = ConnectionUtil.getConUtil();

	@Override
	public List<Reimbursement> getAllReimbursements() {
		
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		
		try {
	
			Connection con = conUtil.getCon();
			
			String sql = "SELECT * FROM ers_reimbursement";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				reimbList.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
			
			System.out.println(reimbList);
			
			return reimbList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	
	}

	@Override
	public Reimbursement getReimbursementByAuthor(int reimb_author) {
		
		Reimbursement r = new Reimbursement();
		
		try {
			Connection con = conUtil.getCon();
			
			String sql = "SELECT * FROM ers_reimbursement WHERE ers_reimbursement.reimb_author = '" + reimb_author + "'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				r.setReimb_id(rs.getInt(1));
				r.setReimb_amount(rs.getDouble(2));
				r.setReimb_submitted(rs.getTimestamp(3));
				r.setReimb_resolved(rs.getTimestamp(4));
				r.setReimb_description(rs.getString(5));
				//r.setReimb_receipt(rs.getBlob(6));
				r.setReimb_author(rs.getInt(6));
				r.setReimb_resolver(rs.getInt(7));
				r.setReimb_status_id(rs.getInt(8));
				r.setReimb_type_id(rs.getInt(9));

			}
			
			System.out.println(r);
			
			return r;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createReimbursement(Reimbursement r) throws SQLException {
		
		Connection con = conUtil.getCon();
		
		String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_status_id, reimb_type_id) values"
				+ "(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setDouble(1, r.getReimb_amount());
		ps.setTimestamp(2, r.getReimb_submitted());
		ps.setTimestamp(3, r.getReimb_resolved());
		ps.setString(4, r.getReimb_description());
		//ps.setBlob(5, r.getReimb_receipt());
		ps.setInt(5, r.getReimb_author());
		//ps.setInt(6, r.getReimb_resolver());
		ps.setInt(6, r.getReimb_status_id());
		ps.setInt(7, r.getReimb_type_id());

		ps.execute();
		
	}

	@Override
	public void updateReimbursement(Reimbursement r) {
		
		try {
			Connection con = conUtil.getCon();
			String sql = "UPDATE ers_reimbursement SET reimb_amount = ?, reimb_submitted = ?, reimb_resolved = ?, reimb_description = ?, reimb_author = ?, reimb_resolver = ?, reimb_status_id = ?, reimb_type_id = ?"
					+ "WHERE ers_reimbursement.reimb_id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, r.getReimb_amount());
			ps.setTimestamp(2, r.getReimb_submitted());
			ps.setTimestamp(3, r.getReimb_resolved());
			ps.setString(4, r.getReimb_description());
			//ps.setBlob(5, r.getReimb_receipt());
			ps.setInt(5, r.getReimb_author());
			ps.setInt(6, r.getReimb_resolver());
			ps.setInt(7, r.getReimb_status_id());
			ps.setInt(8, r.getReimb_type_id());
			ps.setInt(9, r.getReimb_id());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteReimbursement(Reimbursement r) {

		try {
			Connection con = conUtil.getCon();
			String sql = "DELETE FROM ers_reimbursement WHERE reimb_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, r.getReimb_id());
			ps.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
