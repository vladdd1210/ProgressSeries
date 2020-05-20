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

@WebServlet("/addToList")
public class AddToList extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(); 
		String sessionLogin = (String) session.getAttribute("sessionLogin");
		if (sessionLogin != null) {
		GetUser getUser = new GetUser();
		ArrayList<User> user = getUser.getUserByLogin(sessionLogin);
		int iDUser = user.get(0).getiDUser();
		int iDTitle = Integer.parseInt(request.getParameter("IDTitle").toString());
		GetNow_Watching getNowWatching = new GetNow_Watching ();
		ArrayList<Now_Watching> nowWatching = getNowWatching.getNow_WachingByUserAndTitleID(iDUser, iDTitle);
		CreateNow_Watching createNow_Watching = new CreateNow_Watching();
		GetEpisode getEpisode = new GetEpisode();
		ArrayList<Episode> episodes = getEpisode.getEpisodesByTitleID(iDTitle);
		if(episodes.size() == 0) {
			response.sendRedirect("/noEpisodes");
		} else {
		int firstEpisodeID = episodes.get(0).getiDEpisode();
		if(nowWatching.size() == 0) {
			createNow_Watching.create(firstEpisodeID, iDUser, iDTitle);
			response.sendRedirect("/successfulyAdded");
		}
		else {
			response.sendRedirect("/alreadyHave");
			
		}
		}
		} else {
			response.sendRedirect("/login.jsp");
		}
	}
}

