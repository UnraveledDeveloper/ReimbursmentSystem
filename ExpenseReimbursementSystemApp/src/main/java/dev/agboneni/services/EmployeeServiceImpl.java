package dev.agboneni.services;

import java.util.List;

import dev.agboneni.DAOs.ReimbursmentDAO;
import dev.agboneni.DAOs.ReimbursmentDAOmariadb;
import dev.agboneni.entities.Reimbursment;

public class EmployeeServiceImpl implements EmployeeService{
	
	private ReimbursmentDAO rdao = new ReimbursmentDAOmariadb();
	
	@Override
	public List<Reimbursment> viewRequests(int id) {
		
		return rdao.getReimbursmentByEmpId(id);
	}

}
