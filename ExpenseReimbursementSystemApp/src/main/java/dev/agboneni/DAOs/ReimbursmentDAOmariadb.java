package dev.agboneni.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.agboneni.entities.Reimbursment;
import dev.agboneni.utils.ConnectionUtil;

public class ReimbursmentDAOmariadb implements ReimbursmentDAO{

	@Override
	public Reimbursment createReimbursment(Reimbursment reburs) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "INSERT INTO Reimbursment VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(2,reburs.getEmpId());
			ps.setDouble(1, reburs.getAmount());
			ps.setString(3, reburs.getReason());
			ps.setString(4, reburs.getStatus());
			ps.execute();
			
			return reburs;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursment> getReimbursmentByEmpId(int id) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Reimbursment WHERE Employee_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			List<Reimbursment> reimbursements = new ArrayList<Reimbursment>();
			while(rs.next()) {
				Reimbursment r = new Reimbursment();
				r.setAmount(rs.getInt("Amount"));
				r.setEmpId(rs.getInt("Employee_Id"));
				r.setReason(rs.getString("Reason"));
				r.setStatus(rs.getString("Status"));
				reimbursements.add(r);
			}
			return reimbursements;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Reimbursment> getAllReimbursments() {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Reimbursment";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Reimbursment> reimbursements = new ArrayList<Reimbursment>();
			while(rs.next()) {
				Reimbursment r = new Reimbursment();
				r.setAmount(rs.getInt("Amount"));
				r.setEmpId(rs.getInt("Employee_Id"));
				r.setReason(rs.getString("Reason"));
				r.setStatus(rs.getString("Status"));
				reimbursements.add(r);
			}
			return reimbursements;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
		return null;
	}

	@Override
	public List<Reimbursment> getReimbursmentByStatus(String status) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Reimbursment WHERE Status = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();
			List<Reimbursment> reimbursements = new ArrayList<Reimbursment>();
			while(rs.next()) {
				Reimbursment r = new Reimbursment();
				r.setAmount(rs.getInt("Amount"));
				r.setEmpId(rs.getInt("Employee_Id"));
				r.setReason(rs.getString("Reason"));
				r.setStatus(rs.getString("Status"));
				reimbursements.add(r);
			}
			return reimbursements;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Reimbursment updaReimbursment(Reimbursment reburs) {
		
		return null;
	}

	@Override
	public boolean deleteReimbursment(Reimbursment reburs) {
		
		return false;
	}

}
