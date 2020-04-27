package dev.agboneni.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.agboneni.DAOs.EmployeeDAO;
import dev.agboneni.DAOs.EmployeeDAOmariadb;
import dev.agboneni.DAOs.ReimbursmentDAO;
import dev.agboneni.DAOs.ReimbursmentDAOmariadb;
import dev.agboneni.entities.Employee;
import dev.agboneni.services.EmployeeService;
import dev.agboneni.services.EmployeeServiceImpl;

public class EmployeeController {
	
	ReimbursmentDAO rdao = new ReimbursmentDAOmariadb();
	EmployeeDAO edao = new EmployeeDAOmariadb();
	EmployeeService eserv = new EmployeeServiceImpl();
	
	public void viewRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int eid = (int) request.getSession().getAttribute("employeeId");
		Employee e = edao.getEmployeeById(eid);
		Gson gson = new Gson();
		String json = gson.toJson(eserv.viewRequests(e.getEmpId()));
		System.out.println("Session request id: " + eid);
		System.out.println(e);
		response.getWriter().append(json);
		 
	}

}
