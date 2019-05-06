package info.brunobatista;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.System.out;

@WebServlet("/ProcessContact")
public class ProcessContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ProcessContact() {
        super();
    
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = null;
		String status = null;
		if (request.getParameter("submit") != null) {
			JavaEmail javaEmail = new JavaEmail();
			javaEmail.setMailServerProperties();
			String emailSubject = "Contact Form using Java JSP GMail";
			String emailBody = "";
			if (request.getParameter("name") != null) {
				emailBody = "Sender Name: " + request.getParameter("name")
						+ "<br>";
			}
			if (request.getParameter("email") != null) {
				emailBody = emailBody + "Sender Email: "
						+ request.getParameter("email") + "<br>";
			}
			if (request.getParameter("phone") != null) {
				emailBody = emailBody + "Sender Phone: "
						+ request.getParameter("phone") + "<br>";
			}
			if (request.getParameter("message") != null) {
				emailBody = emailBody + "Message: " + request.getParameter("message")
						+ "<br>";
			}
			
			try {
				javaEmail.createEmailMessage(emailSubject, emailBody);
				javaEmail.sendEmail();
				status = "success";
				message = "Email sent Successfully!";
				if (null != message) {
					out.println("<div class='" + status + "'>"
							+ message + "</div>");
				}
			} catch (MessagingException me) {
				status = "error";
				message = "Error in Sending Email!";
			}
		}
		
	}

}
