package zad5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class LengthChecker {

	private boolean isProperLength(String arg, int len){
		
		return arg.length()>len;
		
	}
	
	public String[] readFile(String fileName){
		File f = new File(fileName);
		String[]arr;
		int counter=0;
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()){
				sc.nextLine();
				counter++;
			}
			arr = new String[counter];
			System.out.println(counter);
			counter=0;
			
			Scanner sc2 = new Scanner(f);
			while(sc2.hasNextLine()){
				arr[counter]=sc2.nextLine();
				counter++;
			}
			return arr;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	private void writeFile(String[] fileContent, int len){
		
		File f2 = new File("src\\zad5\\words_+"+len+".txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f2,true);
			PrintWriter pw = new PrintWriter(fos);
			for(String x:fileContent){
				pw.println(x);
			}
			pw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void make(String fileInput, int len){
		File f = new File(fileInput);
//		try {
//			
//			Scanner sc = new Scanner(f);
//			while(sc.hasNextLine()){
//				String text = sc.nextLine();
//				if (isProperLength(text,len)) {
//					
//				}
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		String[] arr = readFile(fileInput);
		int counter=0;
		for(String x: arr ){
			if (isProperLength(x,len)) counter++;
		}
		
		String[] fileContent = new String[counter];
		counter=0;
		for(String x: arr ){
			
			if (isProperLength(x,len)) {
				fileContent[counter]=x;
				counter++;
			}
		}
		
		writeFile(fileContent, len);
		
		
	}
	
	
}
