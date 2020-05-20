import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.progresseries.db.Title;
import com.progresseries.operationsdb.GetTitle;

@WebServlet("/alreadyHave")
public class AlreadyHave extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetTitle getTitle = new GetTitle ();
		ArrayList<Title> titles = getTitle.getTitles();
		request.setAttribute("Titles", titles);
		boolean alreadyHave = true;
		request.setAttribute("alreadyHave", alreadyHave);
		getServletContext().getRequestDispatcher("/Profile.jsp").forward(request, response);
	}
		

}