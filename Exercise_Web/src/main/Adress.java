package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class Adress {

	private String street;
	private String city;
	private String zipCode;
	private String houseNr;
	
	public Adress(){
		this.street=randomStreet();
		this.city=randomCity();
		this.zipCode=randomZipCode();
		this.houseNr=randomHouse();
	}
	
	private String randomStreet(){
		InputStream in = getClass().getResourceAsStream("WEB-INF/ulice.txt");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("main//ulice.txt").getFile());
		//File f = new File("src//resources//ulice.txt");
		ArrayList<String> list = new ArrayList<String>();
		Scanner sc;
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()){
				list.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random rd = new Random();
		
		return list.get(rd.nextInt(list.size()));
	}
	
	private String randomCity(){
		InputStream in = getClass().getResourceAsStream("WEB-INF/miasta.txt");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("main//miasta.txt").getFile());
		//File f = new File("src//resources//miasta.txt");
		ArrayList<String> list = new ArrayList<String>();
		Scanner sc;
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()){
				list.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random rd = new Random();
		
		return list.get(rd.nextInt(list.size()));
	}
	
	private String randomHouse(){
		Random rd = new Random();
		return rd.nextInt(9)+1+"/"+rd.nextInt(10)+1;
	}
	
	private String randomZipCode(){
		Random rd = new Random();
		
		return rd.nextInt(10)+""+rd.nextInt(10)+"-"+rd.nextInt(10)+""+rd.nextInt(10)+""+rd.nextInt(10);
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getHouseNr() {
		return houseNr;
	}

	public void setHouseNr(String houseNr) {
		this.houseNr = houseNr;
	}
	
	public String toString(){
		return street+" "+houseNr+", "+city+", "+zipCode;
	}
	
	public JSONObject getJSONObject(){
		
		JSONObject adress = new JSONObject();
		adress.put("street", street	);
		adress.put("houseNr", houseNr	);
		adress.put("city", city	);
		adress.put("zipCode", zipCode	);
		return adress;

	}
}
