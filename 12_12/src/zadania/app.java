package zadania;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XMLUtil ag = new XMLUtil();
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		Random rd = new Random();
		for(int i=0;i<10;i++){
			list1.add(rd.nextInt(50));
			list2.add(rd.nextInt(50));

		}
		
		try {
			ag.zad7saveValueFile("zad7_1.xml", list1);
			ag.zad7saveValueFile("zad7_2.xml", list2);
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(ag.getAverage("zad7_1.xml"));
			System.out.println(ag.getAverage("zad7_2.xml"));

			System.out.println(ag.countAverageFromFiles("zad7", 1, 2));
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
