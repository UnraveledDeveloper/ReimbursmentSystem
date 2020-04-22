package dev.agboneni.servicetests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.agboneni.DAOs.EmployeeDAO;
import dev.agboneni.DAOs.EmployeeDAOmariadb;
import dev.agboneni.entities.Employee;
import dev.agboneni.entities.Reimbursment;
import dev.agboneni.services.ManagerService;
import dev.agboneni.services.ManagerServiceImpl;

public class ManagerServicetests {

	@Before
	public void setUp() throws Exception {
	}

	ManagerService mserv = new ManagerServiceImpl();
	EmployeeDAO edao = new EmployeeDAOmariadb();
	@Test
	public void getAllRequeststest() {

		for (Reimbursment r : mserv.getAllRequests()) {
			System.out.println(r);
		}
	}
	
	@Test
	public void getAllRequestsByEmpIdtest() {
		List<Reimbursment> emprequest = mserv.getAllRequestsByEmpId(2);
		System.out.println(emprequest);
	}
	
	@Test
	public void getAllRequestsByEmpName() {
		List<Reimbursment> emp = mserv.getAllRequestsByEmpName("Rex");
		System.out.println(emp);
	}

}
