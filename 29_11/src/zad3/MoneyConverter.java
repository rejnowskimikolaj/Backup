package zad3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MoneyConverter {
	
	public double readCourse(String currency){
		File f = new File("src\\zad3\\currency.txt");
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()){
				String text = sc.nextLine();
				 String[] arr= stringToArr(text);
//				 System.out.println(arr[0]);
//				 System.out.println(arr[1]);
//				 System.out.println(arr[2]);
				 if(arr[1].equals(currency)){
					 double result = Double.parseDouble(arr[2].replace(",", "."))/Double.parseDouble(arr[0]);
					 return result;
				 }
				
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public double convert(double money, String to){
		
		double course =readCourse(to);
		return money*course;

		
	}
	
	public double convert(double money, String to, String from){
		double toCurrency = readCourse(to);
		double fromCurrency=readCourse(from);
		return money*fromCurrency/toCurrency;
	}
	
	
	public String[] stringToArr(String text){
		
		String[] arr = text.split("\t");
		String firstPart = arr[0];
		String course = arr[1];
		String[] oneTwo = firstPart.split(" ");
		String one = oneTwo[0];
		String two = oneTwo[1];
		String[] result = {one, two, course};
		
		return result;
		
		
		
		
	}
}
