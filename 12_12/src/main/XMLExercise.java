package main;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLExercise {

	private final String path = "src\\resources\\";
	
	
	

	public void readXMLFile(String filename) throws ParserConfigurationException, SAXException, IOException {
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
		NodeList nList = doc.getElementsByTagName("staff");
		for (int i = 0; i < nList.getLength(); i++) {
			/* org.w3c.dom.Node */
			Node n = nList.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				/* org.w3c.dom.Element */
				Element elem = (Element) n;
				System.out.println("ID: " + elem.getAttribute("id"));
				System.out.println("FIRSTNAME: " + elem.getElementsByTagName("salary").item(0).getTextContent());
				System.out.println(" ==== ");

				// elem.hasChildNodes();
			}
		}

	}

	public void writeXMLFile(String filename) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		/* tworzymy glowny element */
		Element root = doc.createElement("korzen");
		
		/* tworzymy podelement 'czlowiek' */
		Element czlowiek = doc.createElement("czlowiek");
		/* i przypisujemy mu atrybut o kluczu 'id' i wartoœci '123' */
		czlowiek.setAttribute("id", "123");
		
		/* tworzymy kolejny element 'imie; */
		Element imie = doc.createElement("imie");
		/* dla elementu imie dolaczamy pole tekstowe */
		imie.appendChild(doc.createTextNode("Pawel"));
		
		Element nazwisko = doc.createElement("nazwisko");
		nazwisko.setAttribute("value", "Testowy");
		
		/* ukladamy elementy w hierarchii tj. dla elementow dolaczamy ich dzieci */
		czlowiek.appendChild(imie);
		czlowiek.appendChild(nazwisko);
		root.appendChild(czlowiek);
		doc.appendChild(root);
		
		/* deklarujemy instancje transformera, ktory zapisze i przekonwertuje nam obiekt DOM do pliku */
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		
		/* tworzymy obekt DOMSource, ktory reprezentuje drzewo DOM naszego dokumentu */
		DOMSource source = new DOMSource(doc);
		
		/* deklarujemy strumien pliku do ktorego bedziemy zpisywali dane */
		StreamResult sr = new StreamResult(new File(this.path + filename));
		/* zapisujemy plik */
		t.transform(source, sr);
	}
}
