package GUI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import classes.iDatenzugriff;

public class DatenzugriffPDF implements iDatenzugriff {

	private static Aufgabe_b gui;
	
	public DatenzugriffPDF(Aufgabe_b gui){
		this.gui=gui;
	}
	
	@Override
	public void speichern(Object spiel) {

		
		
	}
	
	public static void main(String [] args) throws FileNotFoundException, DocumentException {
		
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("Spiel.pdf"));
			document.open();
			document.add(new Paragraph("yo"));
//			document.add(new Image (gui.));
			document.close();
			
	}

	@Override
	public Object laden(int zaehler) {
		return null;
	}

}
