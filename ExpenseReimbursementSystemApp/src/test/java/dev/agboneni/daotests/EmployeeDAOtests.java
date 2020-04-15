package dev.agboneni.daotests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.agboneni.DAOs.*;
import dev.agboneni.entities.Employee;

public class EmployeeDAOtests {

	@Before
	public void setUp() throws Exception {
	}
	
	EmployeeDAO edao = new EmployeeDAOmariadb();
	@Test
	public void createEmployeetest() {
		Employee test = new Employee();
		test.setName("Max");
		test.setUsername("maxingtest");
		test.setPassword("maxtestpass1");
		test.setManagerId(1);
		edao.createEmployee(test);
		System.out.println(test);
	}
	
	@Test
	public void getEmployeetest() {
		List<Employee> employees = edao.getAllEmployees();
		Employee idFound = edao.getEmployeeById(3);
		Employee name = edao.getEmployeeByName("Manning");
		for(Employee e : employees) {
			System.out.println(e);
		}
		System.out.println(idFound);
		System.out.println(name);
	}

}
