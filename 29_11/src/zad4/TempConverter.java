package zad4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TempConverter {
	
	
	public double toKelvin(double temp){
		return temp+273.15;
	}
	
	public double toFahrenheit(double temp){
		return temp*(9/5)+32;
	}

	public void toFahrenheitToFile(){
		
		File f = new File("src\\zad4\\tempC.txt");
		File f2 = new File("src\\zad4\\tempF.txt");
		
		
		
		Scanner sc;
		try {
			sc = new Scanner(f);
			FileOutputStream fos = new FileOutputStream(f2,true);
			PrintWriter pw = new PrintWriter(fos);
			while(sc.hasNextLine()){
				
				double temp =Double.parseDouble(sc.nextLine().replace(",", "."));
				temp = toFahrenheit(temp);
				
				pw.println(temp);
			}
			
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
	public void toKelvinToFile(){
		
		File f = new File("src\\zad4\\tempC.txt");
		File f2 = new File("src\\zad4\\tempK.txt");
		
		
		
		Scanner sc;
		try {
			sc = new Scanner(f);
			FileOutputStream fos = new FileOutputStream(f2,true);
			PrintWriter pw = new PrintWriter(fos);
			while(sc.hasNextLine()){
				
				double temp =Double.parseDouble(sc.nextLine().replace(",", "."));
				temp = toKelvin(temp);
				
				pw.println(temp);
			}
			
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
}
