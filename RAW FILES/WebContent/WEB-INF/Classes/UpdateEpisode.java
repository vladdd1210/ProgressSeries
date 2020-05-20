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

@WebServlet("/changeEpisode")
public class  UpdateEpisode extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GetUser getUser = new GetUser ();
		UpdateNowWatching updateNowWatching = new UpdateNowWatching();
		String sessionLogin = (String) session.getAttribute("sessionLogin");
		ArrayList  <User> user = getUser.getUserByLogin(sessionLogin);
		int iDUser = user.get(0).getiDUser();
		int iDTitle = Integer.parseInt(request.getParameter("iDTitle"));
		int iDEpisode = Integer.parseInt(request.getParameter("watching"));
		updateNowWatching.update(iDEpisode, iDUser, iDTitle);
		response.sendRedirect("/show?IDTitle=" + iDTitle);
	}
}