package dev.agboneni.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.agboneni.DAOs.EmployeeDAO;
import dev.agboneni.DAOs.EmployeeDAOmariadb;
import dev.agboneni.entities.Employee;
import dev.agboneni.entities.Reimbursment;
import dev.agboneni.services.ReimbursmentService;
import dev.agboneni.services.ReimbursmentServiceImpl;


public class ReimbursementController {
	
	ReimbursmentService rserv = new ReimbursmentServiceImpl();
	EmployeeDAO edao = new EmployeeDAOmariadb();
	
	
	public void sumbitRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//get the body 
		Gson gson = new Gson();
		String body = request.getReader().lines().reduce("", (accumlator,actual) ->accumlator+actual);
		//turn body into an object
		Reimbursment r = gson.fromJson(body, Reimbursment.class);
		int eid = (int) request.getSession().getAttribute("employeeId");
		Employee emp = edao.getEmployeeById(eid);
		rserv.submitRequest(r, emp);
		response.getWriter().append("Request Submitted ");
		System.out.println(body);
		System.out.println(emp);
	}
	
	public void approveRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
				//get the body 
				Gson gson = new Gson();
				String body = request.getReader().lines().reduce("", (accumlator,actual) ->accumlator+actual);
				
				//turn body into an object
				Reimbursment r = gson.fromJson(body, Reimbursment.class);
				rserv.approveRequest(r);
				response.getWriter().append("Request Approved");
				System.out.println(r);
	}
	
	public void denyRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
				//get the body 
				Gson gson = new Gson();
				String body = request.getReader().lines().reduce("", (accumlator,actual) ->accumlator+actual);
				
				//turn body into an object
				Reimbursment r = gson.fromJson(body, Reimbursment.class);
				rserv.denyRequest(r);
				response.getWriter().append("Request Denied");
	}

}
