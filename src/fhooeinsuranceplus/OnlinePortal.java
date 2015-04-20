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

		boolean rememberMe = Boolean.valueOf(request.getParameter("rememberme"));

		// User Management System
		UserDatabase d = new UserDatabase();

		// authenticating
		Staff staffmember = d.authenticateUser(user, password.toCharArray());

		// creating session
		String username = staffmember.getUsername();
		HttpSession session = request.getSession();
		session.setAttribute("user", username);
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
			Cookie loginCookie = new Cookie("rememberme", username + ";" + newRandom);
			response.addCookie(loginCookie);
			session.setAttribute("user", username);
		}

		// printing costumers
		String html = "";
		if (staffmember != null) {

			response.setContentType("text/html");
			html = "<div class=\"main-card\">";
			// html = "<body>\n<title>Login as " + username
			// + "</title>\n";
			html += "<h1>Dear " + staffmember.getUsername() + "! </h1>\n";
			html += "<p>Welcome to your InsurancePlus Profile. Manage your Data! </p>";
			html += "Your costumers: </p>";
			html += "<table border= \"2\" cellspacing=\"10\" cellpadding=\"10\" >\n<tr><th>ID</th><th> Customer name </th> <th> More information </th> </tr>";

			CustomerDatabase dt = new CustomerDatabase();
			List<Customer> customerlist = dt.getListOfCustomers(staffmember);
			for (Customer c : customerlist) {

				html += "<tr><td>" + c.getCustromerId() + "</td><td>"
				    + c.getFirstName() + " " + c.getSurname()
				    + "</td> <td><a href =\"CustomerInfo?id=" + c.getCustromerId()
				    + "\"> More Information" + "</a></td></tr>";
			}
			html += "</table></div>";
			html += "</body></html>\n";
			out.println(html);

			/*
			 * out.println("Login successful."); out.println("Username: " +
			 * staffmember.getUsername()); out.println("Password Hash: " +
			 * staffmember.getPasswordHash()); out.println("ID: " +
			 * staffmember.getId()); out.println("Role: " + staffmember.getRole());
			 */

			out.close();
		} else {
			response.sendRedirect("loginFailed.html");
			return;

		}

	}

	public void destroy() {
		// do nothing.
	}

}
