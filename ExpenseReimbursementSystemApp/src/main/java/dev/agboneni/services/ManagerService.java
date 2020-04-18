package dev.agboneni.services;

import dev.agboneni.entities.Reimbursment;

//manager can view and process all reimbursement requests
//search for reimbursements base on criteria: name or id
public interface ManagerService {
	
	public Reimbursment getAllRequests();
	
	public Reimbursment getAllRequestsByEmpId();
	
	public Reimbursment getAllRequestsByEmpName();

}
