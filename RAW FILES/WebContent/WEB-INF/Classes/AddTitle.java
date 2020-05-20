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

@WebServlet("/addTitle")
public class AddTitle extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		String description = request.getParameter("Description");
		CreateTitle createTitle = new CreateTitle();
		createTitle.create(name, description);
		response.sendRedirect("/add");
	}
}

