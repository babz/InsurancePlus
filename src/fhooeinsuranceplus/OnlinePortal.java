package fhooeinsuranceplus;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class OnlinePortal extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private CustomerDatabase d = new CustomerDatabase();

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out
		    .println("#################################################################################################");
		UserDatabase.init();
		CustomerDatabase.init();
		System.out
		    .println("#################################################################################################");

		// Do required initialization
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
		// a GET Request is not allowed in this place...
		response.sendRedirect("index.html");

	}

	/*
	 * - Bgcolor setzen - checks inputfields - Create Session! - List customers
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);

		// set page color
		out.println(" <link rel=\"stylesheet\" href=\"css/style.css\">");

		String user = request.getParameter("user");
		String password = request.getParameter("password");
		char[] passw = request.getParameter("password").toCharArray();

		if (user == null || user.equals("")) {
			System.out.println("Username field is empty");
			response.sendRedirect("loginFailed.html");
			return;
		}
		if (password == null || password.equals("")) {
			System.out.println("Password field is empty");
			response.sendRedirect("loginFailed.html");
			return;
		}
		
		
		boolean rememberMe = false;
		if (request.getParameter("rememberme") != null );{
			rememberMe = true;
			System.out.println("Remember function is active");
		}

		// User Management System
		UserDatabase d = new UserDatabase();

		// authenticating
		Staff staffmember = d.authenticateUser(user, password.toCharArray());

		// creating session
		String username = staffmember.getUsername();
		HttpSession session = request.getSession();
		session.setAttribute("user", username);
		session.setAttribute("role", staffmember);
		session.setMaxInactiveInterval(60 * 15);
		String newRandom="";
		
		//Set cookie when rememberme checked
		if (rememberMe == true) {
			PasswordUtil hash = new PasswordUtil();
		
			try {
				newRandom = hash.savePassword(passw);
		
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cookie loginCookie = new Cookie("rememberme", username + ":" + newRandom);
			response.addCookie(loginCookie);
			session.setAttribute("user", username);
		}

		
		
		// printing costumers
		if (staffmember != null) {
			response.sendRedirect("ShowCustomer");
		} else {
			response.sendRedirect("loginFailed.html");
		}
		return;

	}

	public void destroy() {
		// do nothing.
	}

}
