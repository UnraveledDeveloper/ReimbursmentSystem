package dev.agboneni.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO edao = new EmployeeDAOmariadb();
	private ManagerDAO mdao = new ManagerDAOmariadb();

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("Password");
		
			try {
				Employee emp = edao.validateLogin(user, pass);
				if(emp != null) {
					HttpSession sess = request.getSession();
					sess.setAttribute("username", user);
					response.sendRedirect("http://localhost:8080/ExpenseReimbursementSystemApp/employeepage.html");
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
