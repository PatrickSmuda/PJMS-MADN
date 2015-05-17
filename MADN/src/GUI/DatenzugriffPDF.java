package GUI;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import classes.iDatenzugriff;

public class DatenzugriffPDF implements iDatenzugriff {

	private static Aufgabe_b gui;
	
	public DatenzugriffPDF(){
		
	}
	
	@Override
	public void speichern(Object spiel, File filefileAddressSave) {

		if(spiel instanceof BufferedImage){
			
			BufferedImage image=(BufferedImage)spiel;
			try{
				Document d=new Document();
				PdfWriter.getInstance(d, new FileOutputStream(filefileAddressSave));
				ByteArrayOutputStream baos = null;
				byte[] imageInByte = null;
				d.open();
				try{
					baos = new ByteArrayOutputStream();
					ImageIO.write( image, "png", baos );
					baos.flush();
					imageInByte = baos.toByteArray();
					baos.close();
				 
					}catch(IOException e){
						System.out.println(e.getMessage());
					}		 
				d.add(new Paragraph("Mensch �rgere dich nicht!"));
				d.add(Image.getInstance(imageInByte));
				d.close();
				
			}catch(DocumentException | FileNotFoundException e){
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else System.out.println("bla");
		
		
	}
	
	
	
	@Override
	public Object laden(int zaehler) {
		return null;
	}

	


}
