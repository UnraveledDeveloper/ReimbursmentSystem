package dev.agboneni.servlets;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.agboneni.DAOs.EmployeeDAO;
import dev.agboneni.DAOs.EmployeeDAOmariadb;
import dev.agboneni.DAOs.ManagerDAO;
import dev.agboneni.DAOs.ManagerDAOmariadb;
import dev.agboneni.entities.Employee;
import dev.agboneni.entities.Manager;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO edao = new EmployeeDAOmariadb();
	

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println(user);
		System.out.println(pass);
		HttpSession sess = request.getSession();
			
				
					Employee emp = edao.validateLogin(user, pass);
					
					if(emp != null) {
						int empId = emp.getEmpId();
						sess.setAttribute("employeeId", empId);
						sess.setAttribute("username", user);
						//check value to see if it got the employee
						System.out.println(emp);
						response.sendRedirect("http://localhost:8080/ExpenseReimbursementSystemApp/employeepage.html");
						return;	
					}
					else {
						response.getWriter().append("Invalid Username and Password");
					}
			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
