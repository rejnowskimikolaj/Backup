package zad2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import zad1.Sentence;

public class Sentencer extends Sentence {
	
	public void writeSentencer(String fileName, String sentence){
		File f = new File(fileName);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
			PrintWriter pw = new PrintWriter(fos);
			pw.println(sentence);
			pw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
