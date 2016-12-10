package games;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Configurator {

	private String fileName;
	private HashMap<String,String> configLines;
	private ArrayList<HashMap<String,String>> sections;
	
	public Configurator(String fileName){
		this.fileName=fileName;
		this.configLines=new HashMap<>();
		readFile();
	}
	
	public void readFile(){
		File f = new File(fileName);
		Scanner sc;
		try {
			sc = new Scanner(f);
			while(sc.hasNextLine()){
				String line = sc.nextLine();
				if(line.charAt(0)=='['){
					sections.add(configLines);
				}
				String[]arrLine = line.split("=");
				this.configLines.put(arrLine[0],arrLine[1]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveFile(HashMap<String,String> config){
		File f2 = new File(fileName);
		FileOutputStream fos;
	    Iterator it = config.entrySet().iterator();

		try {
			fos = new FileOutputStream(f2);
			PrintWriter pw = new PrintWriter(fos);
			 while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        pw.println(pair.getKey()+"="+pair.getValue());
			        it.remove(); // avoids a ConcurrentModificationException
			    }
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void saveFile(){
		File f2 = new File(fileName);
		FileOutputStream fos;
	    Iterator it = configLines.entrySet().iterator();

		try {
			fos = new FileOutputStream(f2);
			PrintWriter pw = new PrintWriter(fos);
			 while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        pw.println(pair.getKey()+"="+pair.getValue());
			    }
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public HashMap<String,String> getConfig(){
		return this.configLines;
	}
	
	public  void configMenu(ProperPrinter pp){
		System.out.println("sizee: " + this.configLines.size());
		printConfig(pp);
		System.out.println("size3e: " + this.configLines.size());

		//configurator.readFile();
		pp.delim();
		pp.print("1. Options");
		pp.print("0. Return");
		Scanner sc = new Scanner(System.in);
		String answer = "";
		while(!answer.equals("0")){
			answer=sc.nextLine();
		if(answer.equals("1")){
			pp.print("Podaj klucz: ");
			//configurator.readFile();
			String key = sc.nextLine();
			System.out.println("sizee: " + configLines.size());
			if(!configLines.containsKey(key)){
				pp.print("Nie ma takiego klucza");
				return;
			}
			pp.print("Podaj wartoœæ");
			answer = sc.nextLine();
			configLines.put(key, answer);
			printConfig(pp);
			saveFile();
			
			}
		}
		
	}	
	
	public void printConfig(ProperPrinter pp){
		Iterator it = configLines.entrySet().iterator();
		int i=1;
		 while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        pp.delim();
		        pp.print(i+". "+pair.getKey()+" = " + pair.getValue());
		        i++;
		        pp.delim();
		    }
		
	}
}
