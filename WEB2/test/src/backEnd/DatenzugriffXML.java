package backEnd;

import java.io.File;
import java.io.FileReader;
import java.io.ObjectOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


	public class DatenzugriffXML implements iDatenzugriff {
		
		private ObjectOutputStream oos = null;
		private String dateiName = "Speicherstand_";

		public void speichern(Object spiel, File fileAddressSave) {
//			if ((!(saveme instanceof SpielXMLWrapper))
//			|| (!(stream instanceof FileWriter)))
//		throw new IllegalArgumentException(
//				"Strom oder Wrapperobjekt ungültig");
//
//	else
		try {

//			saveme = ((SpielXMLWrapper) saveme);
//			stream = ((FileWriter) stream);
//			
//		SpielXMLWrapper	spiel = (SpielXMLWrapper) saveme;
//		FileWriter schreiber = (FileWriter) stream;
			
			
			JAXBContext context = JAXBContext.newInstance((String) spiel);
			Marshaller marshall = context.createMarshaller();
			marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			marshall.marshal(saveme, schreiber);

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		}

		@Override
		public Object laden(File fileAddressLoad) {
			
			if(oos == null) throw new IllegalArgumentException("Strom null");
//			if(!( instanceof FileReader)) throw new IllegalArgumentException("FileReader vorrausgesetzt");
			
			FileReader fR = (FileReader) stream;
			File sXML = null;
			
			try {
				JAXBContext context = JAXBContext.newInstance(SpielXMLWrapper.class);
				Unmarshaller uM = context.createUnmarshaller();
				sXML =  (File) uM.unmarshal(fR);
				return sXML;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

	}
