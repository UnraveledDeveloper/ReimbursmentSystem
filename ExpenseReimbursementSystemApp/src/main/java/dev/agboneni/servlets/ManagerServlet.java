package dev.agboneni.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.agboneni.DAOs.ManagerDAO;
import dev.agboneni.DAOs.ManagerDAOmariadb;
import dev.agboneni.entities.Employee;
import dev.agboneni.entities.Manager;


public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ManagerServlet() {
        super();
        
    }

	ManagerDAO mdao = new ManagerDAOmariadb();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int managerId = (int) request.getSession().getAttribute("managerId");
		Manager logged = mdao.getManagerById(managerId);
		response.getWriter().append("Welcome " + logged.getName());
		System.out.println(logged);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
