package zadania;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class zad8App {

	public static void main(String[] args) {
		XMLUtil ag = new XMLUtil();
		try {
			ag.saveCSVasXML("zad8.xml", ag.readFile("zad8.txt"));
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
