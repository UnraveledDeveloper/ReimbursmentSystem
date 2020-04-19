package dev.agboneni.services;

import dev.agboneni.entities.Employee;
import dev.agboneni.entities.Reimbursment;

public interface ReimbursmentService {
	
	public Reimbursment submitRequest(Reimbursment request, Employee e);
	
	public Reimbursment approveRequest(Reimbursment request);
	
	public Reimbursment denyRequest(Reimbursment request);

}
