package zad10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Dict {

	private Word[] dict;
	private String dictName;
	
	public Dict(String dictName){
		readDict(dictName);
		this.dictName=dictName;
	}
	
	public Dict(){
		readDict("src\\zad10\\dict.txt");
		this.dictName="src\\zad10\\dict.txt";
	}
	private int countLines(String fileName){
		File f = new File(fileName);
		int counter=0;
		
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()){
				sc.nextLine();
				counter++;
			}
		}
		 catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return counter;
		
	}
	public void readDict(String fileName){
		
		int size= countLines(fileName);
		dict = new Word[size];
		File f = new File(fileName);
		int counter=0;
		
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()){
				
				String[] arr=sc.nextLine().split("\\s+");
				dict[counter]=new Word(arr[0],arr[1]);
				counter++;
			}
		}
		 catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public Word[] getDict(){
		return this.dict;
	}
	
	public boolean checkIfExists(String polishWord){
		File f = new File(dictName);
		Scanner sc;
		try {
			sc = new Scanner(f);
			while(sc.hasNextLine()){
				String[] line =sc.nextLine().split("\\s+");
				if(polishWord.equals(line[0])) return true;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public void addWord(String polishWord, String englishWord){
		if (checkIfExists(polishWord)==true) throw new IllegalArgumentException("slowo jest juz w slowniku");
		File f2 = new File(dictName);
		FileOutputStream fos;
		
		try {
			fos = new FileOutputStream(f2,true);
			PrintWriter pw = new PrintWriter(fos);
			pw.println(polishWord+" "+englishWord);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		readDict(dictName);
		
	}
	
	public String translateToEn(String polishWord){
		 
		
		for(int i=0;i<dict.length;i++){
			if (dict[i].getPolishWord().equals(polishWord)) return dict[i].getEnglishWord(); 
		}
		throw new IllegalArgumentException("nie ma takiego s³owa");
	}
	
	public String translateToPl(String englishWord){
		 
		
		for(int i=0;i<dict.length;i++){
			if (dict[i].getEnglishWord().equals(englishWord)) return dict[i].getPolishWord(); 
		}
		throw new IllegalArgumentException("nie ma takiego s³owa");
	}

	public int getLine(String word){
		
		File f = new File(dictName);
		int counter=-1;
		Scanner sc;
		try {
			sc = new Scanner(f);
			while(sc.hasNextLine()){
				String[] line =sc.nextLine().split("\\s+");
				counter++;
				if(word.equals(line[0])||word.equals(line[1])) return counter ;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return counter;
	}
	
	
	public Word[] getDictAfterDel(String word){
		int line= getLine(word);
		if (line==-1) throw new IllegalArgumentException("nie ma takiego s³owa");
		Word[] result =new Word[dict.length-1];
		int i=0;

		for(Word x: dict){
			if(i==line) break;
			result[i]=dict[i];
			i++;
		}
		
		for (int j=line;j<result.length;j++){
			result[j]=dict[j+1];
		}
		return result;
	}
	
	public void deleteWord(String word){
		File f2 = new File(dictName);
		FileOutputStream fos;
		FileOutputStream fos2;
		Word[]newDict=getDictAfterDel(word);
		try {
			
			fos = new FileOutputStream(f2);
			fos2 = new FileOutputStream(f2);

			PrintWriter pw = new PrintWriter(fos);
			
			pw.println();
			pw.close();
			PrintWriter pw2 = new PrintWriter(fos2,true);
			for(Word x: newDict){
				pw2.println(x.getPolishWord()+" "+x.getEnglishWord());
			}
			pw2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
