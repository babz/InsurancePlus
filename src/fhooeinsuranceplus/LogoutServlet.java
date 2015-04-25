package fhooeinsuranceplus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	/**
	 * This class serves as logout servlet. Print the message that the user is
	 * logged out successfully and invalidate the session.
	 * 
	 * @author christina
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The session will be invalidated and the successfully logged out message
	 * will be printed
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		out.println(" <link rel=\"stylesheet\" href=\"css/style.css\"></link>");
		out.println("<div class=\"main-card\">");

		HttpSession session = request.getSession();
		session.invalidate();

		out.print("<b>You are successfully logged out!</b>");

		out.close();
	}
}
