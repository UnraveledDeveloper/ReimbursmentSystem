package dev.agboneni.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


		return null;
	}

	@Override
	public List<Reimbursment> getAllReimbursments() {
		
		return null;
	}

	@Override
	public List<Reimbursment> getReimbursmentByStatus(String status) {
		
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
