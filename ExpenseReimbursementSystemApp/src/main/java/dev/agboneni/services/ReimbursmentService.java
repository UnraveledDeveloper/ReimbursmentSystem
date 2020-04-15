package dev.agboneni.services;

import dev.agboneni.entities.Reimbursment;

public interface ReimbursmentService {
	
	public Reimbursment submitRequest(Reimbursment request);
	
	public Reimbursment approveRequest(Reimbursment request);
	
	public Reimbursment denyRequest(Reimbursment request);

}
