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

@WebServlet("/successfulyAdded")
public class SuccessfulyAdded extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetTitle getTitle = new GetTitle ();
		ArrayList<Title> titles = getTitle.getTitles();
		request.setAttribute("Titles", titles);
		boolean successfulyAdded = true;
		request.setAttribute("successfulyAdded", successfulyAdded);
		getServletContext().getRequestDispatcher("/Profile.jsp").forward(request, response);
	}
		

}