import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import com.progresseries.db.*;
import com.progresseries.operationsdb.*;


@WebServlet("/reg")
public class Registration extends HttpServlet {
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("Login");
		String password = request.getParameter("Password");
		String repeatPassword = request.getParameter("Repeat_Password");
		
		CreateUser createUser = new CreateUser ();
		GetUser getUser = new GetUser ();
		ArrayList <User> arUser = getUser.getUserByLogin(login);
		
		
		if (login.length()>=6) {
			if (password.length()>=8) {
				if (password.equals(repeatPassword)) {
					if (arUser.size() == 0) {
						createUser.create(login, password);
						response.sendRedirect("/successfulRegistration");
					}
					else {
						response.sendRedirect("/userExist");
					}
				}
				else {
					response.sendRedirect("/passwordMismatch");
				}
			}
			else {
				response.sendRedirect("/passwordLength");
			}
		}
		
		else {
			response.sendRedirect("/loginLength");
		}
		
}
	
	
}
