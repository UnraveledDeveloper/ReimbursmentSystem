package dev.agboneni.daotests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dev.agboneni.DAOs.EmployeeDAO;
import dev.agboneni.DAOs.EmployeeDAOmariadb;
import dev.agboneni.DAOs.ReimbursmentDAO;
import dev.agboneni.DAOs.ReimbursmentDAOmariadb;
import dev.agboneni.entities.Employee;
import dev.agboneni.entities.Reimbursment;

public class ReimbursmentDAOtests {

	@Before
	public void setUp() throws Exception {
	}

	ReimbursmentDAO rdao = new ReimbursmentDAOmariadb();
	EmployeeDAO edao = new EmployeeDAOmariadb(); 
	
	@Test
	public void createReimbursmenttest() {
		Employee e = edao.getEmployeeById(5);
		Reimbursment r = new Reimbursment();
		r.setEmpId(6);
		r.setAmount(500);
		r.setReason("For traveling");
		r.setStatus("pending");
		
		rdao.createReimbursment(r);
		System.out.println(r);
		
	}

}
