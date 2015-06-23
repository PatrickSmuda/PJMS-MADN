package gui;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import backEnd.DatenzugriffCSV;
import backEnd.DatenzugriffSerialisiert;
import backEnd.SpielBean;
import backEnd.iDatenzugriff;

/**
 * Servlet implementation class speichern
 */
@WebServlet("/speichern")
public class speichern extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public speichern() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String typ = request.getParameter("typ");
		SpielBean speichereMich = null;
		iDatenzugriff datenzugriff = null;

		if (typ.equals("ser")) {
		//Hier SpielBean laden - name hängt vom ServerKontext ab
			datenzugriff = new DatenzugriffSerialisiert();
			try {
				speichereMich = new SpielBean();
				datenzugriff.speichern(speichereMich, new File(request.getParameter("pfad")));
			} catch (Exception e) {
				System.err.println("Fehler beim Speichern!");
				e.printStackTrace();
			}
		}
		else if(typ.equals("csv")){
			datenzugriff = new DatenzugriffCSV();
			try {
				datenzugriff.speichern(speichereMich, new File(request.getParameter("pfad")));
			} catch (Exception e) {
				System.err.println("Fehler beim Speichern!");
				e.printStackTrace();
			}
		}
//		else if(typ.equals("xml")){
//			datenzugriff = new DatenzugriffXML();
//			try {
//				datenzugriff.speichern(speichereMich, new File(request.getParameter("pfad")));
//			} catch (Exception e) {
//				System.err.println("Fehler beim Speichern!");
//				e.printStackTrace();
//			}
//		}
		
//		else if(typ.equals("pdf")){
//		datenzugriff = new DatenzugriffPDF();
//		try {
//			datenzugriff.speichern(speichereMich, new File(request.getParameter("pfad")));
//		} catch (Exception e) {
//			System.err.println("Fehler beim Speichern!");
//			e.printStackTrace();
//		}
//	}
	}

}
