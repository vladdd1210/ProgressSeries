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

@WebServlet("/showDescription")
public class  ShowDescription extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	int iDTitle = Integer.parseInt(request.getParameter("iDTitle"));
	int iDEpisode = Integer.parseInt(request.getParameter("iDEpisode"));
	GetTitle getTitle = new GetTitle();
	GetEpisode getEpisode = new GetEpisode();
	ArrayList <Title> title = getTitle.getTitleByID(iDTitle);
	ArrayList <Episode> episode = getEpisode.getEpisodesByEpisodeID(iDEpisode);
	String nameTitle = title.get(0).getName();
	String descTitle = title.get(0).getDescription();
	String nameEpisode = episode.get(0).getName();
	String descriptionEpisode = episode.get(0).getDescription();
	double lengthEpisode = episode.get(0).getLength();
	request.setAttribute("titleName", nameTitle);
	request.setAttribute("episodeName", nameEpisode);
	request.setAttribute("titleDescription", descTitle);
	request.setAttribute("episodeDescription", descriptionEpisode);
	request.setAttribute("Length", lengthEpisode);
	getServletContext().getRequestDispatcher("/description.jsp").forward(request, response);
	}}