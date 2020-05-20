import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.progresseries.db.*;
import com.progresseries.operationsdb.*;

@WebServlet("/log")
public class OnLogin extends HttpServlet {
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		GetUser getuser = new GetUser();
		ArrayList<User> user = getuser.getUserByLogin(login);
		try {
			
			if (user.size() > 0) {
				if(user.get(0).getUserPassword().equals(password)) {
					session.setAttribute("sessionLogin", login);
					response.sendRedirect("/");
				}
				
				else {
					System.out.println("password");
					response.sendRedirect("/wrongLoginOrPassword");
				}
				
			}
			
			else {
				System.out.println("login");
				response.sendRedirect("/wrongLoginOrPassword");
			}
				
		}
		catch (Exception ex){
			System.out.println(ex);
		}
		finally {
			
		}
	}
}