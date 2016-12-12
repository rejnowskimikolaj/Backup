package zadania;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XMLUtil ag = new XMLUtil();
		try {
			System.out.println(ag.getAverageSalary("staff.xml"));
			System.out.println(ag.getNames("staff.xml"));
			ag.printMaxMinID(("staff.xml"));
			try {
				ag.zad4SaveFile("students.xml");
				ag.zad5SaveFile("companies.xml");
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
