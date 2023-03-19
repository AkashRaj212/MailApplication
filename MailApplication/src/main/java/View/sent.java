package View;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.LoadData;



/**
 * Servlet implementation class sent
 */
@WebServlet("/app/Sent")
public class sent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

		String mailId="";
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
					res.getWriter().print(""
							+ "  <h1>SENT</h1>\n" + "  <table>\n" + "    <tr>\n" + "      <th>To</th>\n"
							+ "      <th>subject</th>\n" + "      <th>Mail</th>\n" + "      <th>Date</th>\n" + "    </tr>\n");
					
					try {
						
						Cookie[] cookies = req.getCookies(); 
						if (cookies != null) {
						    for (Cookie cookie : cookies) {
						        if (cookie.getName().equals("mailId")) {
						           this.mailId = cookie.getValue();
						            
						        }
						    }
						}

						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	                   
						List<String[]> mailList = new LoadData().LoadMails().stream().filter(a -> a[0].equals(mailId))
								.collect(Collectors.toList());
						Collections.reverse(mailList);
						for (int i = 0; i < mailList.size(); i++) {

							res.getWriter().print(

									"    <tr>\n" + "      <td>" + mailList.get(i)[0] + "</td>\n" + "      <td>" + mailList.get(i)[3]
											+ "</td>\n" + "      <td>" + mailList.get(i)[2] + "</td>\n" + "      <td>"
											+ mailList.get(i)[1] + "</td>\n" + "    </tr>\n"

							);

						}

					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

			//System.out.println(inboxMails.size());

					res.getWriter().print(

							"  </table>\n" + "");

				
	}

}
