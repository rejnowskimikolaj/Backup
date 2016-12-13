package zadania;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class zad9App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMLUtil xm = new XMLUtil();
		try {
			xm.checkIfNotUnique("staff.xml");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
