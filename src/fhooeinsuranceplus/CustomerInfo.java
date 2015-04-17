package fhooeinsuranceplus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerInfo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
      throws ServletException, IOException {  
response.setContentType("text/html");  
PrintWriter out=response.getWriter();  
request.getRequestDispatcher("link.html").include(request, response);
out.println(" <link rel=\"stylesheet\" href=\"css/style.css\">");

HttpSession session=request.getSession(false);  
if(session!=null){  
String name=(String)session.getAttribute("user");  

out.print("Hello, "+name+" - Customer Information for ..!!"); 





}  
else{  
out.print("<b>Please login first!!</b>");  
request.getRequestDispatcher("index.html").include(request, response);  
}  
out.close();  
}  
	
	
}
