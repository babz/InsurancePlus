import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OnlinePortal {


		
		public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException {
			PrintWriter out = response.getWriter();
			
			out.println("hallo");

			out.println("<p>Welcome visitor!</p>");
			out.println("<p>Please enter your name & password below:</p>");
			out.println("<p><form action=\"hello\" method=\"post\">");
			out.println("<p> Name: <input type=\"text\" name=\"name\"><br>");
			out.println("<p>Password: <input type=\"password\" name=\"password\"><br>");
			out.println("<p><input type=\"submit\" value=\"Submit\">");
			out.println("<p></form> ");
			out.close();
		}
		
		

	}


