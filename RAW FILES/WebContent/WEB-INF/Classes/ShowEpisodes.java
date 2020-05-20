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


@WebServlet("/show")
public class ShowEpisodes extends HttpServlet {
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		HttpSession session=request.getSession();
		GetUser getUser = new GetUser();
		GetTitle getTitle = new GetTitle();
		GetNow_Watching getNowWatching = new GetNow_Watching();
		GetEpisode getEpisode = new GetEpisode();
		if (session.getAttribute("sessionLogin")!=null) {
		ArrayList <User> sessionUser= getUser.getUserByLogin(session.getAttribute("sessionLogin").toString());
		ArrayList<Title> titles = new ArrayList<Title>();
		int iDTitle = Integer.parseInt(request.getParameter("IDTitle"));
		ArrayList<Episode> episodes = getEpisode.getEpisodesByTitleID(iDTitle);
		String login = sessionUser.get(0).getUserName();
		int iDUser = sessionUser.get(0).getiDUser();
		int permission = sessionUser.get(0).getPermission();
		ArrayList<Now_Watching> nowWatching = getNowWatching.getNow_WachingByUserID(iDUser);
		ArrayList<Now_Watching> nowWatchEpisode = getNowWatching.getNow_WachingByUserAndTitleID(iDUser, iDTitle);
		int iDEpisode = nowWatchEpisode.get(0).getiDEpisode();
		for(int i = 0; i < nowWatching.size(); i++) {
			titles.addAll(getTitle.getTitleByID(nowWatching.get(i).getiDTitle()));
		}
			request.setAttribute("IDTitle", iDTitle);
			request.setAttribute("IDEpisode", iDEpisode);
			request.setAttribute("Titles", titles);
			request.setAttribute("Permission", permission);
			request.setAttribute("Episodes", episodes);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("/login.jsp");
			}
	} 
	catch (Exception ex){
		System.out.println(ex);
	}
	finally {
		
	}

		}
}