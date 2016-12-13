package zadania;

import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class personApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("Miki", "Testowy","Intel", 10000, "HR", 1993));
		list.add(new Person("Pawel", "Testowy","Microsoft", 50000, "BackEnd", 1990));
		list.add(new Person("Jola", "Testowa","SII", 9000, "FrontEnd", 2000));
		list.add(new Person("Andrzej", "Andrzejewski","Intel", 5000, "HR", 1992));
		list.add(new Person("Maciej", "Andrzejewski","Facebook", 10000, "Housekeeping", 1989));
		XMLUtil xml = new XMLUtil();
		try {
			xml.zad6SavePeople("persons.xml", list);
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
