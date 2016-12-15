package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) {
	
		Main m = new Main();
		
		try {
			JSONParser parser = new JSONParser();

			Object o = parser.parse(m.sendGET());
			JSONObject jo = (JSONObject) o;
			System.out.println(jo.get("status"));
			
			System.out.println(m.sendPOST());
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String sendPOST() throws IOException{
		String url = "http://palo.ferajna.org/sda/wojciu/json.php";
		URL ob = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) ob.openConnection();
		String ua = "Pawel/1.1";
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", ua);
		
		//tylko dla post, przesylanie danych w sposob niejawny
		String myParams="login=test&haslo=qwerty";
		con.setDoOutput(true);
		DataOutputStream dos = new DataOutputStream(con.getOutputStream());
		dos.writeBytes(myParams);
		dos.flush();
		dos.close();
		int responseCode = con.getResponseCode();
		String ret = "";
		
		if(responseCode==200){
			Scanner sc = new Scanner(new InputStreamReader(con.getInputStream()));
			while(sc.hasNextLine()){
				ret+=sc.nextLine();
			}
			
			sc.close();
		}
		
		else System.out.println("Code: "+responseCode);
		return ret;
		
		
	}
	public String sendGET() throws IOException{
		//definiujemy adres polaczenia (hosta)
		String url = "http://palo.ferajna.org/sda/wojciu/json.php?login=pablo";
		
		//tworzymy user agenta (definiujemy przegladarke)
		String ua = "Pawel/1.0";
		URL obj = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		//opcjonalnie 
		con.setRequestMethod("GET");
		
		//definiujemy nag³ówek, dodajemy user-agenta
		con.setRequestProperty("User-Agent", ua);
		
		int responseCode = con.getResponseCode();
		String ret="", currentLine = "";
		if(responseCode==200){
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while((currentLine=br.readLine()) !=null){
				ret+=currentLine;
			}
			br.close();
		}
		
		else System.out.println("Code: "+responseCode);
		return ret;
	}
}
