package fhooeinsuranceplus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerInfo extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		out.println(" <link rel=\"stylesheet\" href=\"css/style.css\"></link>");

		out.println("<div class=\"main-card\">");
		HttpSession session = request.getSession(false);
		if (session != null) {

			// check if id is in GET-parameter
			if (request.getParameter("id") == null) {
				out.print("No ID specified (1)");
				out.close();
				return;
			}
			
			
			int id = -1;
			try {
			id = Integer.parseInt(request.getParameter("id"));
			
			
			} catch ( NumberFormatException e) {
				out.print("No ID specified (2)");
				out.close();
				System.out.println(e.getMessage());
				return;
			}

			
			CustomerDatabase d = new CustomerDatabase();
			Customer c = d.getCustomerById(id);
			
			if (c == null){
				out.print("Customer with selected ID not found");
				out.close();
				return;
			}
			
			
			String name = (String) session.getAttribute("user");

			out.print("Hello, " + name);
			

			String insinfo = "<p>Firstname: " + c.getFirstName() + "</p>";
			insinfo += "<p>Surname: " + c.getSurname() + "</p>";
			insinfo += "<p>Insurance Sum: " + c.getInsuranceSum() + "</p>";
			insinfo += "<p>ID: " + c.getCustromerId() + "</p>";
 

			out.print(insinfo);

			out.print("<a href =\"Download?id=" + c.getCustromerId() + "\"> Download Customer Information"
					+ "</a>");

		} else {
			out.print("<b>Please login first!!</b>");
			request.getRequestDispatcher("index.html").include(request,
					response);
		}
		out.println("</div>");
		out.close();
	}
}
