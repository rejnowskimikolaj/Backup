package zad9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PresentChecker {

	private String fileName;
	
	public PresentChecker(){
		this.fileName="src\\zad9\\words.txt";
	}
	
	public PresentChecker(String fileName){
		this.fileName=fileName;
	}
	
	public boolean checkIfExists(String text){
		File f = new File(fileName);
		boolean result=false;
		Scanner sc;
		try {
			sc = new Scanner(f);
			while(sc.hasNextLine()){
				String line =sc.nextLine();
				if(text.equals(line)) return true;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public void readWords(){
		Scanner sc=new Scanner(System.in);
		
		while(true){
			
			System.out.println("podaj slowo");
			String word = sc.nextLine();
			if(checkIfExists(word)==true) System.out.println("tak");
			else System.out.println("nie");
		}
	}
}
