package dev.agboneni.servicetests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dev.agboneni.DAOs.EmployeeDAO;
import dev.agboneni.DAOs.EmployeeDAOmariadb;
import dev.agboneni.DAOs.ReimbursmentDAO;
import dev.agboneni.DAOs.ReimbursmentDAOmariadb;
import dev.agboneni.entities.Reimbursment;
import dev.agboneni.services.ReimbursmentService;
import dev.agboneni.services.ReimbursmentServiceImpl;

public class ReimbursmentServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	ReimbursmentService rserv = new ReimbursmentServiceImpl(); 
	EmployeeDAO edao = new EmployeeDAOmariadb();
	ReimbursmentDAO rdao = new ReimbursmentDAOmariadb();
	@Test
	public void submitReimbursmenttest() {
		Reimbursment r = new Reimbursment();
		r.setAmount(500);
		r.setReason("For traveling");
		
		rserv.submitRequest(r,edao.getEmployeeById(5));
		System.out.println(r);
	}
	
	@Test
	public void approveReimbursmenttest() {
		
		rserv.approveRequest(rdao.getReimbursmentById(1));
		
	}
	
	@Test
	public void denyReimbursmenttest() {
		rserv.denyRequest(rdao.getReimbursmentById(5));
	}

}
