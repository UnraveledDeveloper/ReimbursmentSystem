package dev.agboneni.DAOs;

import java.util.List;

import dev.agboneni.entities.Employee;

public interface EmployeeDAO {

	Employee createEmployee(Employee emp);

	Employee getEmployeeById(int id);
	Employee getEmployeeByName(String name);
	List<Employee> getAllEmployees();
	List<Employee> getAllEmployeesByMgrId(int mgrId);

	Employee updateEmployee(Employee emp);

	boolean deleteEmployee(Employee emp);
	
	Employee validateLogin(String username, String password);
}
