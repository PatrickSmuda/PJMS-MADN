package gui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backEnd.iBedienerBean;

/**
 * Servlet implementation class MailServlet
 */
@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailServlet() {
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
		String address = request.getParameter("address");
		if(address.length() < 5){
			out.println("ung&uumlte Addresse");
		}else{
			try{
				String split[] = address.split("\\@");
				try{
					String split2[] = split[1].split("\\.");
					String betreff = request.getParameter("betreff");
					String text = request.getParameter("text");
					String anhang = request.getParameter("anhang");
					String split3[];
					if(anhang.length() < 4){
						anhang = null;
					}else{
						split3  = anhang.split("\\.");
					}
					//Mail Libs noch nicht eingebunden
					//new Mail(address, betreff,  text, anhang, "Spiel."+split3[1], null, null);
					out.println("Email wurde versendet..");
					out.println("<form action='Mail.jsp'><input type='submit' value='back'></form>");
				}catch(Exception e){
					out.println("ung&uumltigee Addresse Code 2");
					out.println("<form action='Mail.jsp'><input type='submit' value='back'></form>");
				}
				
			}catch(Exception e2){
				out.println("ung&uumltigee Addresse Code 1");
				out.println("<form action='Mail.jsp'><input type='submit' value='back'></form>");
			}
			
			
		}
		out.println("</body></html>");
		out.close();
		
	}

}
