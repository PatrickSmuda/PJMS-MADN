package gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		response.setIntHeader("Refresh", 5);
		out.println("<html><head></head><body>");
		HttpSession ses = request.getSession(true);
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
			out.println("Spieler 1: <input type='text' value='"+request.getParameter("param1")+"' disabled>");
			out.println("<input type='text' value='"+request.getParameter("color")+"' disabled>");
			out.println("<input type='text' value='"+request.getParameter("ki")+"' disabled><br><br>");

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
				
					((ArrayList<Object>) ses.getAttribute("gameLobby")).add(client);
					for(int i = 0; i < ((ArrayList<Object[]>) ses.getAttribute("gameLobby")).size(); i++){
						out.println("Spieler "+(i+1)+"<input type='text' value='"+(String) (((ArrayList<Object[]>) ses.getAttribute("gameLobby")).get(i))[0]+"' disabled>");
						out.println("<input type='text' value='"+(String) (((ArrayList<Object[]>) ses.getAttribute("gameLobby")).get(i))[1]+"' disabled>");
						out.println("<input type='text' value='"+(String) (((ArrayList<Object[]>) ses.getAttribute("gameLobby")).get(i))[2]+"' disabled>");
						out.println("<br><br>");
					}
					if(((ArrayList<Object[]>) ses.getAttribute("gameLobby")).size() == (int)ses.getAttribute("count")){
						out.println("beginne Spiel..");
					}
				}
				
			}
		}
		out.println(getMenu(Integer.parseInt(request.getParameter("param2"))));
		
		String ausgabe = "";
		out.println(ausgabe);
		out.println("</body></html>");
		out.close();
	}
	
	public static String getMenu(int amountOfPlayers){
		String s = "";
		for(int i = 1; i < amountOfPlayers; i++){
			s+="Spieler "+(i+1)+": "+"<input type='text' name='player"+i+"' disabled>"
					+ "<input type='text' name='color"+i+"' disabled>"
					+ "<input type='text' name='ki"+i+"' disabled>"
					+ "<br><br>";
		}
		return s;
		
	}

}
