package zad7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class AvgChecker {
	
	private String fileName;
	
	public  AvgChecker(String fileName){
		this.fileName=fileName;
	}
	
	private double lineAverage(String line){
		String[]arr = line.split("\t");
		double amount=arr.length-1;
		double result=0;
		for(int i=1;i<arr.length;i++){
			result+=Double.parseDouble(arr[i].replace(",", "."));
		}
		
		return result/amount;
	}
	public void process(){
		String[]arr = readFile(fileName);
		double fileAverage = 0;
		double lineAmount=arr.length;
		
		for(String x: arr){
			fileAverage+=lineAverage(x);
		}
		
		fileAverage=fileAverage/lineAmount;
		
		String[] goodLinesArr= new String [countGoodLines(fileAverage, arr)];
		int counter = 0;
		for (String x: arr){
			if (isGoodLine(fileAverage,x)){
				goodLinesArr[counter] = x;
				counter++;
			}
		}
		
		File f2 = new File(fileName);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f2);
			PrintWriter pw = new PrintWriter(fos);
			for(String x:goodLinesArr){
				pw.println(x);
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	private boolean isGoodLine(double average, String line){
			return (lineAverage(line)>average);
		
	}
	private int countGoodLines(double average, String[]arr){
		int result=0;
		for(String x: arr){
			if (lineAverage(x)>average) {
				result++;
			}
		}
		
		return result;
		
	}
	private String[] readFile(String fileName){
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
			counter=0;
			
			Scanner sc2 = new Scanner(f);
			while(sc2.hasNextLine()){
				String[] strArr=sc2.nextLine().split("\\s+");
				String text="";
				for(String x: strArr){
					text+=x+"\t";
				}
				arr[counter]=text;
				counter++;
			}
			return arr;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
