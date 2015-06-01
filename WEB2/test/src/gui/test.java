package gui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
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
		out.println("<html><head></head><body>");
		int playerCount = 0;
		String p1 = request.getParameter("param1");
		String ausgabe = "";
		String names = "";
		if((p1 == ausgabe) || p1.length() < 1){
			ausgabe = "<h2>Keine Eingabe!</h2>";
		}else{
			try{
				playerCount = Integer.parseInt(p1);
			}catch(NumberFormatException e){
				
			}
			for(int i = 0; i < playerCount; i++){
				names = names+"<h3>Name "+(i+1)+" </h3><input name='name"+i+"' type='text' size='20' min='1'></input>";
			}
			ausgabe = "<form action='test' method='post'>"
					+names
					+"<br><input id='senden' type='submit' value='senden'></input>"
					+ "</form>";
			out.println(ausgabe);
			out.println("</body></html>");
			out.close();
		}

	}

}
