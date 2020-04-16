package dev.agboneni.daotests;

import static org.junit.Assert.*;

import java.util.List;

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
		r.setEmpId(4);
		r.setAmount(1500);
		r.setReason("For traveling");
		r.setStatus("pending");
		
		rdao.createReimbursment(r);
		System.out.println(r);
		
	}
	
	@Test 
	public void getReimbursmenttests() {
		List<Reimbursment> r = rdao.getReimbursmentByEmpId(4);
		List<Reimbursment> rall = rdao.getAllReimbursments();
		List<Reimbursment> rstatus = rdao.getReimbursmentByStatus("pending");
		for(Reimbursment reburs : rall) {
			System.out.println(reburs);
		}
	}

}
