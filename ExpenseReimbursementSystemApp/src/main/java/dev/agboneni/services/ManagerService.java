package dev.agboneni.services;

import java.util.List;

import dev.agboneni.entities.Reimbursment;

//manager can view and process all reimbursement requests
//search for reimbursements base on criteria: name or id
public interface ManagerService {
	
	public List<Reimbursment> getAllRequests();
	
	public List<Reimbursment> getAllRequestsByEmpId(int id);
	
	public List<Reimbursment> getAllRequestsByEmpName(String name);

}
