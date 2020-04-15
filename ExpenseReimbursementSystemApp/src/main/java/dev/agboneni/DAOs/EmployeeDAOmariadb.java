package dev.agboneni.DAOs;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dev.agboneni.entities.Employee;
import dev.agboneni.utils.ConnectionUtil;

public class EmployeeDAOmariadb implements EmployeeDAO{

	public Employee createEmployee(Employee emp) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "INSERT INTO reimbersementdb.Employee (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getUsername());
			ps.setString(4, emp.getPassword());
			ps.setInt(5, emp.getManagerId());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
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
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	public Employee getEmployeeByName(String Name) {
		
		return null;
	}

	public List<Employee> getAllEmployees() {
		
		return null;
	}

	public List<Employee> getAllEmployeesByMgrId(int mgrId) {
		
		return null;
	}

	public Employee updateEmployee(Employee emp) {
		
		return null;
	}

	public boolean deleteEmployee(Employee emp) {
		
		return false;
	}

}
