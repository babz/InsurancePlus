package fhooeinsuranceplus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class OnlinePortal extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException
	{
		Database.init();
		// Do required initialization
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// a GET Request is not allowed in this place...
		response.sendRedirect("index.html");

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {


		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		
		if (user==null || user.equals("")){
			System.out.println("Username field is empty");
			response.sendRedirect("loginFailed.html");
			return;
		}
		if (password == null || password.equals("")){
			System.out.println("Password field is empty");
			response.sendRedirect("loginFailed.html");
			return;
		}

		// User Management System
		Database d = new Database();

		// authenticating
		boolean auth = d.authenticateUser(user, password.toCharArray());
		
		if (auth) {
			PrintWriter out = response.getWriter();

			out.println("Login successful.");
			out.close();
		} else {
			response.sendRedirect("loginFailed.html");
			return;
			
		}
		

	}

	
	public void destroy()
	{
		// do nothing.
	}

}


