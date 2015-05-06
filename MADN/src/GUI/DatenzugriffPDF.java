package GUI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import classes.iDatenzugriff;

public class DatenzugriffPDF implements iDatenzugriff {

	@Override
	public void speichern(Object spiel) {

		try{
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("Spiel.pdf"));
		document.open();
		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(DocumentException d){
			d.printStackTrace();
		}
		
	}

	@Override
	public Object laden(int zaehler) {
		return null;
	}

}
