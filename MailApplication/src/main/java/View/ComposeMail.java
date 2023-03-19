package View;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.LoadData;
import User.mails;


/**
 * Servlet implementation class ComposeMail
 */
@WebServlet("/app/ComposeMail")
public class ComposeMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 

		 String usersMail ="";
		Cookie[] cookies = req.getCookies(); 
		if (cookies != null) {
		    for (Cookie cookie : cookies) {
		        if (cookie.getName().equals("mailId")) {
		        	 usersMail = cookie.getValue();
		            
		        }
		    }
		}

		
			
			String subject = req.getParameter("subject");
			String message = req.getParameter("message");
			String reciever = req.getParameter("to");
			
			
			mails mail = new mails(usersMail, new Date(), message, reciever,"active", subject);

			
			
			new LoadData().StoreMail(mail);

		System.out.println(mail);

		
	}

}
