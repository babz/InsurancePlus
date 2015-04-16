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
		PrintWriter out = response.getWriter();

		out.println("hallo");

		out.println("<p>Welcome visitor!</p>");
		out.println("<p>Please enter your name & password below:</p>");
		out.println("<p><form action=\"login\" method=\"post\">");
		out.println("<p> Name: <input type=\"text\" name=\"user\"><br>");
		out.println("<p>Password: <input type=\"password\" name=\"password\"><br>");
		out.println("<p><input type=\"submit\" value=\"login\">");
		out.println("<p></form> ");
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {

		PrintWriter out = response.getWriter();

		String user = request.getParameter("user");
		String password = request.getParameter("pass");


		Database d = new Database();
		out.println("Hallo " + user +"!");

		out.println("Autenticated:  " + d.authenticateUser(user, password) +"!");
		


	}

	
	public void destroy()
	{
		// do nothing.
	}

}


