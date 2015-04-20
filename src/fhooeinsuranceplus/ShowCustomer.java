package fhooeinsuranceplus;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowCustomer extends HttpServlet{

	/**
	 * Hier werden die verschiedenen Kunden aufgelistet. Es besteht die M�glichkeit sich f�r jeden Kunden mehr Informatinen anzeigen zu lassen. 
	 */
  private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		out.println(" <link rel=\"stylesheet\" href=\"css/style.css\"></link>");
		out.println("<div class=\"main-card\">");
	
		HttpSession session = request.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("user");
String html ="";
		
			// html += "<h1>Dear " + staffmember.getUsername() + "! </h1>\n";
			html += "<p>Welcome to your InsurancePlus Profile. Manage your Data! </p>";
			html += "Your costumers: </p>";
			html += "<table border= \"2\" cellspacing=\"10\" cellpadding=\"10\" >\n<tr><th>ID</th><th> Customer name </th> <th> More information </th> </tr>";
			
			CustomerDatabase dt = new CustomerDatabase();
			/*List<Customer> customerlist = dt.getListOfCustomers(staffmember);
			for (Customer c : customerlist) {

				html += "<tr><td>"+ c.getCustromerId() + "</td><td>" + c.getFirstName() + " " + c.getSurname()
				    + "</td> <td><a href =\"CustomerInfo?id=" + c.getCustromerId() + "\"> More Information" + "</a></td></tr>";
			}*/
			html += "</table></div>";
			html += "</body></html>\n";
			out.println(html);
			
			
			
			

		} else {
			out.print("<b>Please login first!!</b>");
			request.getRequestDispatcher("index.html").include(request,
					response);
		}
		out.println("</div>");
		out.close();
		
		
	}
	
	
	
	
}
