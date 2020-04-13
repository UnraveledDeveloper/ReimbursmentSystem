package dev.agboneni.DAOs;

import java.util.List;

import dev.agboneni.entities.Reimbursment;

public interface ReimbursmentDAO {
	
	Reimbursment createReimbursment(Reimbursment reburs);
	
	//should reimbursment class get own id?

	List<Reimbursment> getReimbursmentByEmpId(int id);
	List<Reimbursment> getAllReimbursments();

	List<Reimbursment> getReimbursmentByStatus(String status);
	
	Reimbursment updaReimbursment(Reimbursment reburs);
	
	boolean deleteReimbursment(Reimbursment reburs);

}
