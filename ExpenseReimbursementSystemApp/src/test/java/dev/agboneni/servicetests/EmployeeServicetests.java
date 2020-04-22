package dev.agboneni.servicetests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.agboneni.DAOs.EmployeeDAO;
import dev.agboneni.DAOs.EmployeeDAOmariadb;
import dev.agboneni.entities.Reimbursment;
import dev.agboneni.services.EmployeeService;
import dev.agboneni.services.EmployeeServiceImpl;

public class EmployeeServicetests {

	@Before
	public void setUp() throws Exception {
	}
	
	EmployeeDAO edao = new EmployeeDAOmariadb();
	EmployeeService eserv = new EmployeeServiceImpl();
	@Test
	public void viewRequeststest() {
		List<Reimbursment> emp = eserv.viewRequests(2);
		System.out.println(emp);
	}

}
