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
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 System.out.println("aa");
		
      String name =  request.getParameter("name");
      String mailId =  request.getParameter("mailId");
      String password =  request.getParameter("password");
		
	  new LoadData().InsertUser(mailId, password, name);
	  
	  Cookie cookie = new Cookie("mailId", mailId);
	  
	  response.addCookie(cookie); 
		
		
		
	}

}
