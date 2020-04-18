package dev.agboneni.services;

import dev.agboneni.entities.Reimbursment;

//employee can view all requests that they have made 
public interface EmployeeService {

	public Reimbursment getAllRequests();
}
