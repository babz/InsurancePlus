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
import org.apache.log4j.Logger;
import java.security.NoSuchAlgorithmException;

/**
 * In this class the following functionalitites get implemented: -- Login; --
 * Authentication; when login correct -> then redirect to ShowCustomer.java ->
 * all customers are listed; -- Logging
 */
public class OnlinePortal extends HttpServlet {

	// Logging
	static Logger log = Logger.getLogger(OnlinePortal.class.getName());
	private static final long serialVersionUID = 1L;

	/**
	 * Initialisation: User and customerdatabase
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out
		    .println("#################################################################################################");
		UserDatabase.init();
		CustomerDatabase.init();
		System.out
		    .println("#################################################################################################");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
		// a GET Request is not allowed in this place...
		response.sendRedirect("index.html");
	}

	/**
	 * In this method there is a check if the field for username or password are
	 * empty Is this the case then the user is encouraged to log in again
	 * Implementation of the Authentication process: Is the password incorrect - >
	 * then the user is also encouraged to log in again. Was the authentication
	 * process successful the variable staffmember isn't null and session is
	 * created -> implementation of session management The user is forwarded to a
	 * page with the list of customers
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);

		// set page color
		out.println(" <link rel=\"stylesheet\" href=\"css/style.css\">");

		// get user and password
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		char[] passw = request.getParameter("password").toCharArray();

		// check if fields are empty
		if (user == null || user.equals("")) {
			System.out.println("Username field is empty");
			response.sendRedirect("loginFailed.html");
			log.info("Login failed Username field is empty");
			return;
		}
		if (password == null || password.equals("")) {
			System.out.println("Password field is empty");
			response.sendRedirect("loginFailed.html");
			log.info("Login failed Password field is empty");
			return;
		}

		// set rememberMe
		boolean rememberMe = false;
		if (request.getParameter("rememberme") != null) {
			rememberMe = true;
			System.out.println("Remember function is active");
		}

		// User Management System
		UserDatabase d = new UserDatabase();

		// authenticating
		Staff staffmember = d.authenticateUser(user, password.toCharArray());

		// authenticate successful -> session creation; customer view
		if (staffmember != null) {
			// Session Management
			String username = staffmember.getUsername();
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			session.setAttribute("role", staffmember);
			// set session to expire in 30 mins
			session.setMaxInactiveInterval(30 * 60);
			String newRandom = "";

			// Set cookie when rememberme checked
			if (rememberMe == true) {
				PasswordUtil hash = new PasswordUtil();

				try {
					newRandom = hash.savePassword(passw);

				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.info("Exception - No such Algorithm ");
				}

				if (request.getCookies()[0] != null
				    && request.getCookies()[0].getValue() != null) {
					String[] value = request.getCookies()[0].getValue().split(";");

					// if (value.length != 2) {
					// Set error and return
					// }

					// if (!loginService.mappingExists(value[0],value[1])) {
					// (username, random) pair is checked // Set error and
					// }
					// } else { validated = loginService.isUserValid(username,
					// password); if (!validated) { // Set error and return } }

					// create cookie
					Cookie loginCookie = new Cookie("rememberme", username + ":"
					    + newRandom);
					// setting cookie to expiry in 30 mins
					loginCookie.setMaxAge(30 * 60);
					response.addCookie(loginCookie);
				}
				// list of customers
				response.sendRedirect("ShowCustomer");
			}
		} else {
			response.sendRedirect("loginFailed.html");
			log.info("Login Failed ");
		}
	}

	public void destroy() {
		super.destroy();
	}

}
