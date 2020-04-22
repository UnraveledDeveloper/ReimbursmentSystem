package dev.agboneni.services;

import java.util.List;

import dev.agboneni.entities.Reimbursment;

//employee can view all requests that they have made 
public interface EmployeeService {

	public List<Reimbursment> viewRequests(int id);
}
