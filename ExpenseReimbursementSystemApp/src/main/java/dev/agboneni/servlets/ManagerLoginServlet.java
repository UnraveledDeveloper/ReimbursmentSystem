package dev.agboneni.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.agboneni.DAOs.ManagerDAO;
import dev.agboneni.DAOs.ManagerDAOmariadb;
import dev.agboneni.entities.Manager;

/**
 * Servlet implementation class ManagerLoginServlet
 */
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManagerLoginServlet() {
		super();

	}
	private ManagerDAO mdao = new ManagerDAOmariadb();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		HttpSession sess = request.getSession();
		Manager m = mdao.validateLogin(user, pass);
		try {
			if (m != null) {
				int managerId = m.getManagerId();
				sess.setAttribute("managerId", managerId);
				sess.setAttribute("username", user);
				// check value to see if it got the manager
				System.out.println(m);
				response.sendRedirect("http://localhost:8080/ExpenseReimbursementSystemApp/managerpage.html");
				return;
			}
			else {
				response.getWriter().append("Incorrect Username or password");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
