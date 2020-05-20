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

@WebServlet("/Profile")

public class Profile extends HttpServlet {
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetTitle getTitle = new GetTitle ();
		ArrayList<Title> titles = getTitle.getTitles();
		request.setAttribute("Titles", titles);
		getServletContext().getRequestDispatcher("/Profile.jsp").forward(request, response);
	}
}