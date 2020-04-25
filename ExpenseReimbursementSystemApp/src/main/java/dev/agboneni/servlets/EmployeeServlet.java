package dev.agboneni.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.agboneni.DAOs.EmployeeDAO;
import dev.agboneni.DAOs.EmployeeDAOmariadb;
import dev.agboneni.entities.Employee;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmployeeServlet() {
        super();
      
    }

	EmployeeDAO edao = new EmployeeDAOmariadb();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int eid = (int) request.getSession().getAttribute("employeeId");
		Employee logged = edao.getEmployeeById(eid);
		response.getWriter().append("Welcome " + logged.getName());
		System.out.println(logged);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
