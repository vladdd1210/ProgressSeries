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

@WebServlet("/addEpisode")
public class AddEpisode extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		String description = request.getParameter("Description");
		double length = Double.parseDouble(request.getParameter("Length").toString());
		int iDTitle = Integer.parseInt(request.getParameter("IDTitle").toString());
		CreateEpisode createEpisode = new CreateEpisode();
		createEpisode.create(name, description, length, iDTitle);
		response.sendRedirect("/add");
	}
}

