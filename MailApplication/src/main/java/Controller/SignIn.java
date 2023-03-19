package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.LoadData;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	      String mailId =  request.getParameter("mailId");
	      String password =  request.getParameter("password");
	      System.out.println(mailId);
	     
		  System.out.println(new LoadData().getPassword(mailId)+"aa");
		  if(password.equals(new LoadData().getPassword(mailId))){
			  
			  Cookie cookie = new Cookie("mailId", mailId);		  
			  response.addCookie(cookie);  
			  response.getWriter().append("success");
		  }
		
	}

}
