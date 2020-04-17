package dev.agboneni.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.agboneni.entities.Manager;
import dev.agboneni.utils.ConnectionUtil;

public class ManagerDAOmariadb implements ManagerDAO{

	@Override
	public Manager createManager(Manager magr) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "INSERT INTO Manager VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setString(2, magr.getName());
			ps.setString(3, magr.getUsername());
			ps.setString(4, magr.getPassword());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			magr.setManagerId(rs.getInt("Manager_Id"));
			return magr;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Manager getManagerById(int id) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Manager WHERE Manager_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Manager m = new Manager();
			m.setManagerId(rs.getInt("Manager_Id"));
			m.setName(rs.getString("Name"));
			m.setUsername(rs.getString("Username"));
			m.setPassword(rs.getString("Password"));
			return m;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Manager getManagerByName(String name) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Manager WHERE Name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Manager m = new Manager();
			m.setManagerId(rs.getInt("Manager_Id"));
			m.setName(rs.getString("Name"));
			m.setUsername(rs.getString("Username"));
			m.setPassword(rs.getString("Password"));
			return m;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Manager> getAllManagers() {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Manager";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Manager> managers = new ArrayList<Manager>();
			while(rs.next()) {
				Manager m = new Manager();
				m.setManagerId(rs.getInt("Manager_Id"));
				m.setName(rs.getString("Name"));
				m.setUsername(rs.getString("Username"));
				m.setPassword(rs.getString("Password"));
				managers.add(m);
			}
			return managers;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Manager updateManager(Manager magr) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "UPDATE Manager SET Name = ?, Username = ?, Password = ? WHERE Manager_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, magr.getName());
			ps.setString(2, magr.getUsername());
			ps.setString(3, magr.getPassword());
			ps.setInt(4, magr.getManagerId());
			ps.execute();
			
			return magr;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean deleteManager(Manager magr) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "DELETE FROM Manager WHERE Manager_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, magr.getManagerId());
			boolean success = ps.execute();
			return success;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
