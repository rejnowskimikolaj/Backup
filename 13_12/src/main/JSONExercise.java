package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONExercise {
	
//	Napisz metod�, kt�ra odczyta plik file.json, a nast�pnie wydrukuj z niego do konsoli 
//	poszczeg�lne warto�ci kluczy (lista, asd, qweqe). Nast�pnie dopisz do klasy metod�,
//	kt�ra pozwoli na zapisanie poszczeg�lnych warto�ci jako plik settings.ini 
//	zachowuj�c odpowiedni� struktur� pliku INI.
	
	
	public JSONObject getJSONObjectFromFile(String fileName) throws ParseException{
		JSONParser parser = new JSONParser();
		Object o =parser.parse(readFileAsString(fileName));
		return (JSONObject) o;
	}
	public boolean checkIfJSON(String text){
		
		JSONParser parser = new JSONParser();
		
		try {
			Object o = parser.parse(text);
			
			if(o instanceof JSONArray) {
				return true;
			} else {
				return true;
			}
			
		} catch(Exception e) {
			return false;
		}	
			}
	public String getIniLine(Object jo) throws ParseException{
		ArrayList<String> iniLines = new ArrayList<>();
		
		Set<String> keySet = jo.keySet();
		for(String key:keySet){
			String element = jo.get(key).toString();
			checkIfJSON(text)
		
	}
	public String readFileAsString(String fileName) {
		String result = "";
		String arr[] = readFile(fileName);
		for (String x : arr) {
			result += x + "\n";
		}

		return result;
	}
	
//	Napisz metod�, kt�ra odczyta plik CSV, a nast�pnie utworzy obiekt JSONObject, 
//	w kt�rym kluczami b�d� poszczeg�lne elementy nag��wka, a warto�ciami poszczeg�lne warto�ci. 
//	Zwr�� uwag�, �e w pliku CSV mo�e by� wi�cej rekord�w 
//	ni� 1, dlatego konieczne mo�e by� zwr�cenie tablicy obiekt�w (JSONArray).
	
	
	public JSONArray getJSONArrayFromCSV(String fileName){
		
		String[] arr= readFile("src\\resources\\"+fileName);
		JSONArray ja = new JSONArray();
		String[]heading = arr[0].split(";");
		for(int i =1; i<arr.length;i++){
			JSONObject jo = new JSONObject();
			String[]record = arr[i].split(";");
			for(int j=0;j<record.length;j++){
				jo.put(heading[j], record[j]);
			}
			ja.add(jo);
		}
		return ja;
	}
	//Korzystaj�c z pliku words.txt utw�rz JSONObject, kt�ry b�dzie zawiera� nieparzyste linie 
	//jako klucze, a parzyste jako warto�ci tych kluczy. Nast�pnie zapisz wynik w pliku words.json. 
	//Je�eli w pliku words.txt ilo�� linii jest nieparzysta, pomi� ostatni wyraz.
	public void saveJSON(Object o,String fileName){
		File f2 = new File("src\\resources\\"+fileName);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f2);
			PrintWriter pw = new PrintWriter(fos);
			pw.println(o);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public JSONObject getJSONObjectFromWords(){
		JSONObject jo = new JSONObject();
		String[]arr = readFile("src\\resources\\words.txt");
		for(int i = 0;i<arr.length-1;i+=2){
			jo.put(arr[i],arr[i+1]);
		}
		return jo;
	}
	public String[] readFile(String fileName) {
		File f = new File(fileName);
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
	
	public String[] randomizeArr(){
		Random rd = new Random();
		String[]arr = new String[rd.nextInt(101)];
		for(int i=0;i<arr.length;i++){
			arr[i]=rd.nextInt(101)+"";
		}
		
		return arr;
	}
	
	public JSONArray arrToJSON(String[]arr){
		JSONArray ja=new JSONArray();
		for(String x:arr){
			ja.add(x);
		}
		
		return ja;
	}
	
	public void saveJSONArrayToFile(JSONArray ja, String fileName){
		File f2 = new File("src\\resources\\"+fileName);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f2);
			PrintWriter pw = new PrintWriter(fos);
			pw.println(ja);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void createJSONObject(){
		JSONObject jo = new JSONObject();
		jo.put("pierwszy", "przyk�ad");
		jo.put("drugi", "inny przyk�ad");
		jo.put("liczba", 5);
		JSONObject jo2=new JSONObject();
		jo2.put("x", 5);
		jo2.put("y", 2);

		
		jo.put("obiekt", jo2);
		System.out.println(jo);

		
		
	}
	public Object createJSON(String text) {
		/*JSONObject jo = new JSONObject();
		
		jo.put("klucz", "wartosc");
		jo.put("inny klucz", 55);
				
		JSONArray ja = new JSONArray();
		ja.add(new Integer(7));
		ja.add("simpleString");
		
		jo.put("array", ja);
		
		//ja.get(0);
		
		System.out.println(jo);*/
		
		
		JSONParser parser = new JSONParser();
		
		try {
			Object o = parser.parse(text);
			
			if(o instanceof JSONArray) {
				return (JSONArray) o;
			} else {
				return  (JSONObject) o;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}