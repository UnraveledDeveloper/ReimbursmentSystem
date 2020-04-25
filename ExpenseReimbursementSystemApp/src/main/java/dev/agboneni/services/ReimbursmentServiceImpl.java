package dev.agboneni.services;

import dev.agboneni.DAOs.*;
import dev.agboneni.entities.Employee;
import dev.agboneni.entities.Reimbursment;

public class ReimbursmentServiceImpl implements ReimbursmentService{
	
	private ReimbursmentDAO rdao = new ReimbursmentDAOmariadb(); 
	//private EmployeeDAO edao = new EmployeeDAOmariadb();
	@Override
	public Reimbursment submitRequest(Reimbursment request, Employee e) {
		request.setEmpId(e.getEmpId());
		request.setStatus("Submitted");
		rdao.createReimbursment(request);
		return request;
	}

	@Override
	public Reimbursment approveRequest(Reimbursment request) {
		request.setStatus("Approved");
		rdao.updaReimbursment(request);
		return request;
	}

	@Override
	public Reimbursment denyRequest(Reimbursment request) {
		request.setStatus("Denied");
		rdao.updaReimbursment(request);
		return request;
	}

	
}
