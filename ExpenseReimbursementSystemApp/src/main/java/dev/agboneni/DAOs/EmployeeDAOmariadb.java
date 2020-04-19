package dev.agboneni.DAOs;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.agboneni.entities.Employee;
import dev.agboneni.utils.ConnectionUtil;

public class EmployeeDAOmariadb implements EmployeeDAO{

	public Employee createEmployee(Employee emp) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "INSERT INTO Employee values (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getUsername());
			ps.setString(4, emp.getPassword());
			ps.setInt(5, emp.getManagerId());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			emp.setEmpId(rs.getInt("Employee_Id"));
			return emp;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	public Employee getEmployeeById(int id) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Employee WHERE Employee_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Employee emp = new Employee();
			emp.setEmpId(rs.getInt("Employee_Id"));
			emp.setName(rs.getString("Name"));
			emp.setUsername(rs.getString("Username"));
			emp.setPassword(rs.getString("Password"));
			emp.setManagerId(rs.getInt("Manager_Id"));
			return emp;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	public Employee getEmployeeByName(String name) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Employee WHERE Name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			Employee emp = new Employee();
			emp.setEmpId(rs.getInt("Employee_Id"));
			emp.setName(rs.getString("Name"));
			emp.setUsername(rs.getString("Username"));
			emp.setPassword(rs.getString("Password"));
			emp.setManagerId(rs.getInt("Manager_Id"));
			return emp;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Employee> getAllEmployees() {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Employee";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Employee> employees = new ArrayList<Employee>();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("Employee_Id"));
				emp.setName(rs.getString("Name"));
				emp.setUsername(rs.getString("Username"));
				emp.setPassword(rs.getString("Password"));
				emp.setManagerId(rs.getInt("Manager_Id"));
				employees.add(emp);
			}
			return employees;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Employee> getAllEmployeesByMgrId(int mgrId) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Employee WHERE Manager_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mgrId);
			ResultSet rs = ps.executeQuery();
			List<Employee> employees = new ArrayList<Employee>();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("Employee_Id"));
				emp.setName(rs.getString("Name"));
				emp.setUsername(rs.getString("Username"));
				emp.setPassword(rs.getString("Password"));
				emp.setManagerId(rs.getInt("Manager_Id"));
				employees.add(emp);
			}
			return employees;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	public Employee updateEmployee(Employee emp) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "UPDATE Employee SET Name = ?, Username = ?, Password = ?, Manager_Id = ? WHERE Employee_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getUsername());
			ps.setString(3, emp.getPassword());
			ps.setInt(4, emp.getManagerId());
			ps.setInt(5, emp.getEmpId());
			ps.execute();
			
			return emp;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}

	public boolean deleteEmployee(Employee emp) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "DELETE FROM Employee WHERE Employee_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, emp.getEmpId());
			boolean success = ps.execute();
			return success;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee validateLogin(String username, String password) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Employee WHERE Username = ? AND Password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			Employee emp = new Employee();
			if(rs.next()) {
				
				emp.setEmpId(rs.getInt("Employee_Id"));
				emp.setName(rs.getString("Name"));
				emp.setUsername(rs.getString("Username"));
				emp.setPassword(rs.getString("Password"));
				emp.setManagerId(rs.getInt("Manager_Id"));
				
			}
			return emp;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
