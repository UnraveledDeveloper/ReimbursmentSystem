package dev.agboneni.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.agboneni.DAOs.ReimbursmentDAO;
import dev.agboneni.DAOs.ReimbursmentDAOmariadb;
import dev.agboneni.services.EmployeeService;
import dev.agboneni.services.EmployeeServiceImpl;

public class EmployeeController {
	
	ReimbursmentDAO rdao = new ReimbursmentDAOmariadb();
	EmployeeService eserv = new EmployeeServiceImpl();
	public void viewRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int eid = (int) request.getSession().getAttribute("empId");
		Gson gson = new Gson();
		String json = gson.toJson(eserv.viewRequests(eid));
		response.getWriter().append(json);
	}

}
