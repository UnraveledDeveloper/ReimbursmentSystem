package dev.agboneni.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.agboneni.services.ManagerService;
import dev.agboneni.services.ManagerServiceImpl;

public class ManagerController {
	ManagerService mserv = new ManagerServiceImpl();
	public void viewRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(mserv.getAllRequests());
		response.getWriter().append(json);
		
	}
	public void viewRequestsByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		Gson gson = new Gson();
		String json = gson.toJson(mserv.getAllRequestsByEmpName(name));
		response.getWriter().append(json);
		
	}

}
