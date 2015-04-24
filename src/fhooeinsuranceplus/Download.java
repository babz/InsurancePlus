package fhooeinsuranceplus;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Nachfolgend ist der File-Download ersichtlich.
 * Dieser Code lässt nur Downloads von .txt Files vom Verzeichnis
 * webapps/2_compliant zu. Der Filename darf nur aus Buchstaben, Zahlen und
 * Underscore bestehen.
 * @author christina
 */
public class Download extends HttpServlet{

	
	static Logger log = Logger.getLogger(Download.class.getName());

	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {

		// filename definiert das Dokument welches später ausgelesen werden soll.
		String filename = "";
		if (request.getParameter("file") != null) {
			filename = request.getParameter("file");
		}

		response.setContentType("text/plain");
		response.setHeader("Content-Disposition",
		    "attachment;filename=insurance_informationt.txt");

		String prefix = "webapps/2_compliant/";
		String postfix = ".txt";

		ServletOutputStream out = response.getOutputStream();
		String regularExpression = "^[a-zA-Z0-9_]+";

	/*
	 * Überprüft ob der Filename nur die erlaubten Zeichen enthält, fügt prefix und postfix zu filenamen
	 */
		if (Pattern.matches(regularExpression, filename)) {
			File file = new File(prefix + filename + postfix);

			if (file.exists()) {
				FileInputStream in = new FileInputStream(file);
				int content;
				while ((content = in.read()) != -1) {
					out.write((char) content);
				}
				in.close();
				// out.println(file.getAbsolutePath());
			} else {
				out.println("Error - No information available. Please contact administration!!");
			}
		} else {
			out.println("!!Error - No information available. Maybe your are not allowed to see. Please contact administration!!");
		}
		out.close();
	}
}


