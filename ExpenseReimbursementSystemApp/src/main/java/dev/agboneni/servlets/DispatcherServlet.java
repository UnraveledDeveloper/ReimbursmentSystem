package dev.agboneni.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.agboneni.controllers.ReimbursementController;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public DispatcherServlet() {
       
    }
    
    ReimbursementController rcontroller = new ReimbursementController();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		switch(uri) {
		case "/ExpenseReimbursementSystemApp/reburs/submit":
			rcontroller.sumbitRequest(request, response);
			break;
		case "/ExpenseReimbursementSystemApp/reburs/approve":
			rcontroller.approveRequest(request, response);
			break;
		case "/ExpenseReimbursementSystemApp/reburs/deny":
			rcontroller.denyRequest(request, response);
			break;
		case "/ExpenseReimbursementSystemApp/reburs/view":
			
			break;
		case "":
			
			break;
		case "/ExpenseReimbursementSystemApp/reburs/m":
			
			break;
		default: 
			response.getWriter().append("Your request uri did not match anything");
			break;
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
