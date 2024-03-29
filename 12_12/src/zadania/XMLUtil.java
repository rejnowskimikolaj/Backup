package zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUtil {

	private final String path = "src\\resources\\";
	
	public void makeCopy(String fileName) throws ParserConfigurationException, SAXException, IOException{
		File f = new File(this.path + fileName);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(f);
		ArrayList<String> idList;
		NodeList nList = doc.getElementsByTagName("staff");
		for (int i = 0; i < nList.getLength(); i++) {
			Node n = nList.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) n;
				String id =elem.getAttribute("id");
				if(idList.contains(id))  nList.removeChild(elem);
				
			}
		}
		
		
	}
	
	public void checkIfNotUnique(String fileName) throws ParserConfigurationException, SAXException, IOException {
		File f = new File(this.path + fileName);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(f);
		ArrayList<String> idList = new ArrayList<String>();
		HashSet<String> idSet = new HashSet<String>();

		/*
		 * Normalizacja dokumentu, tak aby nie powstaly problemy przy
		 * wyswietlaniu danych
		 */
		doc.getDocumentElement().normalize();

		// nList = doc.getElementsByTagName("root");

		NodeList nList = doc.getElementsByTagName("staff");
		for (int i = 0; i < nList.getLength(); i++) {
			Node n = nList.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) n;
				String id =elem.getAttribute("id");
				idList.add(id);
				idSet.add(id);
				
			}
		}
		
		System.out.println(idList.size());
		System.out.println(idSet.size());


	}
	
	public String[] readFile(String fileName) {
		File f = new File(path+fileName);
		String[] arr;
		int counter = 0;
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				sc.nextLine();
				counter++;
			}
			arr = new String[counter];
			counter = 0;

			Scanner sc2 = new Scanner(f);
			while (sc2.hasNextLine()) {
				arr[counter] = sc2.nextLine();
				counter++;
			}
			return arr;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void saveCSVasXML(String fileName,String[]arr) throws ParserConfigurationException, TransformerException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		String[] heading = arr[0].split(";");
		Element root = doc.createElement("root");
		
		
		for(int i =1;i<arr.length;i++){
			Element student = doc.createElement("Student");
			String[]line = arr[i].split(";");
			for(int j=0;j<line.length;j++){
				Element e = doc.createElement(heading[j]);
				e.appendChild(doc.createTextNode(line[j]));
				student.appendChild(e);
			}
			root.appendChild(student);
		}
		
		doc.appendChild(root);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();


		DOMSource source = new DOMSource(doc);

		StreamResult sr = new StreamResult(new File(this.path + fileName));
		t.transform(source, sr);
	}
		
	public double getAverage(String fileName) throws ParserConfigurationException, SAXException, IOException {
		File f = new File(this.path + fileName);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(f);

		/*
		 * Normalizacja dokumentu, tak aby nie powstaly problemy przy
		 * wyswietlaniu danych
		 */
		doc.getDocumentElement().normalize();

		// nList = doc.getElementsByTagName("root");
		double sum = 0;
		int size = 0;

		NodeList valueNodesList = doc.getElementsByTagName("val");
		for (int j = 0; j < valueNodesList.getLength(); j++) {
			String textValue = valueNodesList.item(j).getTextContent();
			sum += Double.parseDouble(textValue);

		}


		return sum / valueNodesList.getLength();
	}

	public double countAverageFromFiles(String fileName, int a, int b) throws ParserConfigurationException, SAXException, IOException {
		return (getAverage(fileName+"_"+a+".xml")+getAverage(fileName+"_"+b+".xml"))/2;
	}

	public void zad7saveValueFile(String fileName, ArrayList<Integer> list)
			throws ParserConfigurationException, TransformerException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		Element values = doc.createElement("values");
		Element root = doc.createElement("root");
		Element date = doc.createElement("date");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date dateVar = new Date();
		date.appendChild(doc.createTextNode(dateFormat.format(dateVar)));
		root.appendChild(date);
		for (Integer x : list) {
			Element value = doc.createElement("val");
			value.appendChild(doc.createTextNode(x + ""));
			values.appendChild(value);
		}

		root.appendChild(values);
		doc.appendChild(root);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();

		/*
		 * tworzymy obekt DOMSource, ktory reprezentuje drzewo DOM naszego
		 * dokumentu
		 */
		DOMSource source = new DOMSource(doc);

		/* deklarujemy strumien pliku do ktorego bedziemy zpisywali dane */
		StreamResult sr = new StreamResult(new File(this.path + fileName));
		/* zapisujemy plik */
		t.transform(source, sr);

	}

	public void zad6SavePeople(String filename, ArrayList<Person> pplList)
			throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		Element root = doc.createElement("ROOT");
		for (Person p : pplList) {
			Element person = doc.createElement("PERSON");
			Element firstName = doc.createElement("NAME");
			firstName.appendChild(doc.createTextNode(p.getName()));
			Element lastName = doc.createElement("LASTNAME");
			lastName.appendChild(doc.createTextNode(p.getLastName()));

			Element company = doc.createElement("COMPANY");
			company.appendChild(doc.createTextNode(p.getCompany()));

			Element salary = doc.createElement("SALARY");
			salary.appendChild(doc.createTextNode(p.getSalary() + ""));
			Element department = doc.createElement("DEPARTMENT");
			department.appendChild(doc.createTextNode(p.getDepartment()));
			Element year = doc.createElement("YEAR");
			year.appendChild(doc.createTextNode(p.getYearOfBorn() + ""));

			person.appendChild(firstName);
			person.appendChild(lastName);
			person.appendChild(company);
			person.appendChild(salary);
			person.appendChild(department);
			person.appendChild(year);
			root.appendChild(person);

		}
		/* tworzymy glowny element */

		/* tworzymy podelement 'czlowiek' */
		Element company1 = doc.createElement("COMPANY");
		Element company2 = doc.createElement("COMPANY");

		/* i przypisujemy mu atrybut o kluczu 'id' i warto�ci '123' */
		company1.setAttribute("name", "Testowa1");
		company2.setAttribute("name", "Testowa2");

		/* tworzymy kolejny element 'imie; */
		Element starts1 = doc.createElement("STARTS");
		Element starts2 = doc.createElement("STARTS");

		/* dla elementu imie dolaczamy pole tekstowe */
		starts1.appendChild(doc.createTextNode("2008"));
		starts2.appendChild(doc.createTextNode("1979"));

		Element vat1 = doc.createElement("VAT");
		Element vat2 = doc.createElement("VAT");

		vat1.appendChild(doc.createTextNode("23"));
		vat2.appendChild(doc.createTextNode("40"));

		Element employees1 = doc.createElement("EMPLOYEES");
		Element employees2 = doc.createElement("EMPLOYEES");

		employees1.appendChild(doc.createTextNode("345"));
		employees2.appendChild(doc.createTextNode("345345"));

		/*
		 * ukladamy elementy w hierarchii tj. dla elementow dolaczamy ich dzieci
		 */
		company1.appendChild(starts1);
		company1.appendChild(employees1);
		company1.appendChild(vat1);
		root.appendChild(company1);
		company2.appendChild(starts2);
		company2.appendChild(employees2);
		company2.appendChild(vat2);
		root.appendChild(company2);
		doc.appendChild(root);

		/*
		 * deklarujemy instancje transformera, ktory zapisze i przekonwertuje
		 * nam obiekt DOM do pliku
		 */
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();

		/*
		 * tworzymy obekt DOMSource, ktory reprezentuje drzewo DOM naszego
		 * dokumentu
		 */
		DOMSource source = new DOMSource(doc);

		/* deklarujemy strumien pliku do ktorego bedziemy zpisywali dane */
		StreamResult sr = new StreamResult(new File(this.path + filename));
		/* zapisujemy plik */
		t.transform(source, sr);
	}

	// Napisz metod�, kt�ra pozwoli na zapisanie pliku XML wed�ug nast�puj�cej
	// struktury:
	public void zad5SaveFile(String filename) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		/* tworzymy glowny element */
		Element root = doc.createElement("ROOT");

		/* tworzymy podelement 'czlowiek' */
		Element company1 = doc.createElement("COMPANY");
		Element company2 = doc.createElement("COMPANY");

		/* i przypisujemy mu atrybut o kluczu 'id' i warto�ci '123' */
		company1.setAttribute("name", "Testowa1");
		company2.setAttribute("name", "Testowa2");

		/* tworzymy kolejny element 'imie; */
		Element starts1 = doc.createElement("STARTS");
		Element starts2 = doc.createElement("STARTS");

		/* dla elementu imie dolaczamy pole tekstowe */
		starts1.appendChild(doc.createTextNode("2008"));
		starts2.appendChild(doc.createTextNode("1979"));

		Element vat1 = doc.createElement("VAT");
		Element vat2 = doc.createElement("VAT");

		vat1.appendChild(doc.createTextNode("23"));
		vat2.appendChild(doc.createTextNode("40"));

		Element employees1 = doc.createElement("EMPLOYEES");
		Element employees2 = doc.createElement("EMPLOYEES");

		employees1.appendChild(doc.createTextNode("345"));
		employees2.appendChild(doc.createTextNode("345345"));

		/*
		 * ukladamy elementy w hierarchii tj. dla elementow dolaczamy ich dzieci
		 */
		company1.appendChild(starts1);
		company1.appendChild(employees1);
		company1.appendChild(vat1);
		root.appendChild(company1);
		company2.appendChild(starts2);
		company2.appendChild(employees2);
		company2.appendChild(vat2);
		root.appendChild(company2);
		doc.appendChild(root);

		/*
		 * deklarujemy instancje transformera, ktory zapisze i przekonwertuje
		 * nam obiekt DOM do pliku
		 */
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();

		/*
		 * tworzymy obekt DOMSource, ktory reprezentuje drzewo DOM naszego
		 * dokumentu
		 */
		DOMSource source = new DOMSource(doc);

		/* deklarujemy strumien pliku do ktorego bedziemy zpisywali dane */
		StreamResult sr = new StreamResult(new File(this.path + filename));
		/* zapisujemy plik */
		t.transform(source, sr);
	}

	public void zad4SaveFile(String filename) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		/* tworzymy glowny element */
		Element root = doc.createElement("ROOT");

		/* tworzymy podelement 'czlowiek' */
		Element student1 = doc.createElement("STUDENT");
		Element student2 = doc.createElement("STUDENT");

		/* i przypisujemy mu atrybut o kluczu 'id' i warto�ci '123' */

		/* tworzymy kolejny element 'imie; */
		Element firstName1 = doc.createElement("NAME");
		Element firstName2 = doc.createElement("NAME");

		/* dla elementu imie dolaczamy pole tekstowe */
		firstName1.appendChild(doc.createTextNode("John"));
		firstName2.appendChild(doc.createTextNode("Jane"));

		Element lastName1 = doc.createElement("LASTNAME");
		Element lastName2 = doc.createElement("LASTNAME");

		lastName1.appendChild(doc.createTextNode("Simple"));
		lastName2.appendChild(doc.createTextNode("Doe"));

		Element year1 = doc.createElement("YEAR");
		Element year2 = doc.createElement("YEAR");

		year1.appendChild(doc.createTextNode("3"));
		year2.appendChild(doc.createTextNode("1"));

		/*
		 * ukladamy elementy w hierarchii tj. dla elementow dolaczamy ich dzieci
		 */
		student1.appendChild(firstName1);
		student1.appendChild(lastName1);
		student1.appendChild(year1);
		root.appendChild(student1);
		student2.appendChild(firstName2);
		student2.appendChild(lastName2);
		student2.appendChild(year2);
		root.appendChild(student2);
		doc.appendChild(root);

		/*
		 * deklarujemy instancje transformera, ktory zapisze i przekonwertuje
		 * nam obiekt DOM do pliku
		 */
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();

		/*
		 * tworzymy obekt DOMSource, ktory reprezentuje drzewo DOM naszego
		 * dokumentu
		 */
		DOMSource source = new DOMSource(doc);

		/* deklarujemy strumien pliku do ktorego bedziemy zpisywali dane */
		StreamResult sr = new StreamResult(new File(this.path + filename));
		/* zapisujemy plik */
		t.transform(source, sr);
	}

	public void printMaxMinID(String filename) throws ParserConfigurationException, SAXException, IOException {
		File f = new File(this.path + filename);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(f);

		TreeSet<Integer> idList = new TreeSet<>();
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("staff");
		for (int i = 0; i < nList.getLength(); i++) {
			Node n = nList.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) n;
				idList.add(Integer.parseInt(elem.getAttribute("id")));

			}
		}

		System.out.println(idList.first());
		System.out.println(idList.last());
	}

	public ArrayList<String> getNames(String filename) throws ParserConfigurationException, SAXException, IOException {
		File f = new File(this.path + filename);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(f);

		doc.getDocumentElement().normalize();

		ArrayList<String> namesList = new ArrayList<>();

		NodeList nList = doc.getElementsByTagName("staff");
		for (int i = 0; i < nList.getLength(); i++) {
			Node n = nList.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) n;
				namesList.add(elem.getElementsByTagName("firstname").item(0).getTextContent() + " "
						+ elem.getElementsByTagName("lastname").item(0).getTextContent());
			}
		}
		return namesList;
	}

	public double getAverageSalary(String filename) throws ParserConfigurationException, SAXException, IOException {
		File f = new File(this.path + filename);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(f);

		/*
		 * Normalizacja dokumentu, tak aby nie powstaly problemy przy
		 * wyswietlaniu danych
		 */
		doc.getDocumentElement().normalize();

		// nList = doc.getElementsByTagName("root");
		double sum = 0;
		NodeList nList = doc.getElementsByTagName("staff");
		for (int i = 0; i < nList.getLength(); i++) {
			/* org.w3c.dom.Node */
			Node n = nList.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				/* org.w3c.dom.Element */
				Element elem = (Element) n;
				String textSalary = elem.getElementsByTagName("salary").item(0).getTextContent();
				sum += Double.parseDouble(textSalary);

				// elem.hasChildNodes();
			}
		}

		return sum / nList.getLength();
	}

}
