package gui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.txw2.Document;

import backEnd.SpielBean;
import backEnd.iBedienerBean;

/**
 * Servlet implementation class htmlServlet
 */
@WebServlet("/htmlServlet")
public class htmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private iBedienerBean ib = new SpielBean();;
	
	
    /**
     * Default constructor. 
     */
    public htmlServlet() {
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
		out.println("<html><head>");
		
		out.println("</head><body>");
		HttpSession ses = request.getSession(true);
		
		if (request.getParameter("type").equals("wurfeln")) {
			ib.wuerfeln();
			ib.getBewegungsWert();
			int t = ib.getBewegungsWert();
			out.println("<p> " + t + " </p>");
			request.setAttribute("logg", "test");
		}
		
		if (request.getParameter("type").equals("bewegen")) {
			
		}
		
		out.println("</body></html>");
		
		String nextJSP = "/htmlTable.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
		out.close();
	}

	
	
}
