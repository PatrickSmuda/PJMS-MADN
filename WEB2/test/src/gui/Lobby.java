package gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backEnd.SpielBean;
import sun.font.CreatedFontTracker;

/**
 * Servlet implementation class Lobby
 */

@WebServlet("/Lobby")
public class Lobby extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lobby() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession(true);
		boolean addedNewClient = false;
		PrintWriter out = response.getWriter();
		
		if(request.getParameter("type").equals("host")){
			if(ses.getAttribute("gameLobby")==null){
				ses.setAttribute("gameLobby", new ArrayList<Object[]>());
				int v = Integer.parseInt(request.getParameter("param2"));
				ses.setAttribute("count", v);
				String host[] = new String[3];
				host[0] = request.getParameter("param1");
				host[1] = request.getParameter("color");
				host[2] = request.getParameter("ki");
				((ArrayList<Object[]>) ses.getAttribute("gameLobby")).add(host);
			}
			if(addedNewClient == true){
				addedNewClient = false;
			}
		}else if(request.getParameter("type").equals("client")){
			if(ses.getAttribute("gameLobby")==null){
				
			}else{
				boolean hit = false;
				String client[] = new String[3];
				client[0] = request.getParameter("param1");
				client[1] = request.getParameter("color");
				client[2] = request.getParameter("ki");
				for(int i = 0; i < ((ArrayList<Object[]>) ses.getAttribute("gameLobby")).size(); i++){
					for(int j = 0; j < 3; j++){
						if(client[1].equals((String) (((ArrayList<Object[]>) ses.getAttribute("gameLobby")).get(i))[j])){
							hit = true;
						}
					}
				}
				if(hit){
					out.println("Farbe bereits vorhanden<br><br>"
							+ "<form action='Client.jsp'><input type='submit' value='back'></form>");
				}else{
					addedNewClient = true;
					((ArrayList<Object>) ses.getAttribute("gameLobby")).add(client);
					addedNewClient = false;
				}
				
			}
		}
		
		
		performTask(request, response);
	}
	
	private void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			response.addHeader("Refresh", "5");
			PrintWriter out = response.getWriter();
			HttpSession ses = request.getSession();
			String s = "Spiel Lobby:\n";
			for(int i = 0; i < ((ArrayList<Object[]>) ses.getAttribute("gameLobby")).size(); i++){
				s+="Spieler "+(i+1)+"<input type='text' value='"+(String) (((ArrayList<Object[]>) ses.getAttribute("gameLobby")).get(i))[0]+"' disabled>";
				s+="<input type='text' value='"+(String) (((ArrayList<Object[]>) ses.getAttribute("gameLobby")).get(i))[1]+"' disabled>";
				s+="<input type='text' value='"+(String) (((ArrayList<Object[]>) ses.getAttribute("gameLobby")).get(i))[2]+"' disabled>";
				s+="<br><br>";
			}
			out.println(s);
			
			if(((ArrayList<Object[]>) ses.getAttribute("gameLobby")).size() == (int)ses.getAttribute("count")){
				out.println("Alle Spieler der Lobby beigetreten!");
				SpielBean spiel = new SpielBean();
				for(int i = 0; i < ((ArrayList<Object[]>) ses.getAttribute("gameLobby")).size(); i++){
					
					int f = 0;
					int ki = 0;
					switch((String) ((ArrayList<Object[]>) ses.getAttribute("gameLobby")).get(i)[1]){
					case "Rot": f = 0; break;
					case "Blau": f = 1; break;
					case "Gruen": f = 2; break;
					case "Gelb": f = 3; break;
					}
					
					switch((String) ((ArrayList<Object[]>) ses.getAttribute("gameLobby")).get(i)[2]){
					case "Mensch": ki = 0; break;
					case "Defensive KI": ki = 1; break;
					case "Offenssive KI": ki = 2; break;
					}
					
					spiel.spielerHinzufuegen((String) ((ArrayList<Object[]>) ses.getAttribute("gameLobby")).get(i)[0], 
							f, 
							ki);
				}
				//Weiterleitung an die GUI kommt noch
			}
	}
			
	

}
