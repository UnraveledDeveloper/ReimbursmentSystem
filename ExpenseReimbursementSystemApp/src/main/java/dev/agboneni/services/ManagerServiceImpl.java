package dev.agboneni.services;

import java.util.List;

import dev.agboneni.DAOs.EmployeeDAO;
import dev.agboneni.DAOs.EmployeeDAOmariadb;
import dev.agboneni.DAOs.ReimbursmentDAO;
import dev.agboneni.DAOs.ReimbursmentDAOmariadb;
import dev.agboneni.entities.Employee;
import dev.agboneni.entities.Reimbursment;

public class ManagerServiceImpl implements ManagerService{

	private ReimbursmentDAO rdao = new ReimbursmentDAOmariadb();
	private EmployeeDAO edao = new EmployeeDAOmariadb();
	@Override
	public List<Reimbursment> getAllRequests() {
		
		return rdao.getAllReimbursments();
	}

	@Override
	public List<Reimbursment> getAllRequestsByEmpId(int id) {
		
		return rdao.getReimbursmentByEmpId(id);
	}

	@Override
	public List<Reimbursment> getAllRequestsByEmpName(String name) {
		Employee request = edao.getEmployeeByName(name);
		return rdao.getReimbursmentByEmpId(request.getEmpId());
	}


}
