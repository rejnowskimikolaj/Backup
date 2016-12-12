package main;


public class Main {
	public static void main(String[] args) {
		XMLExercise xml = new XMLExercise();
		try {
			xml.readXMLFile("staff.xml");
			xml.writeXMLFile("staff2.xml");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
