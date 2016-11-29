package zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sentence {
	
	public String readSentence(String fileName) {
		File f = new File(fileName);
		String result="";
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()){
				
				result+=sc.nextLine()+" ";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String firstLetter = result.substring(0, 1).toUpperCase();
		
		return firstLetter+result.substring(1,result.length()-1)+".";
		
	}

}
