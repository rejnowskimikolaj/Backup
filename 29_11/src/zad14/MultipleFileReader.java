package zad14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import zad11.FileIO;

public class MultipleFileReader {
	
	private int starting;
	private int ending;
	private FileIO fio;
	private String[] arr;
	
	public double[] splitStringIntoDoubles(String text){
		String[] arr =text.split("\\s");
		double []doubleArr=new double [arr.length];
		int i=0;
		 for(String x : arr){
			doubleArr[i]= Double.parseDouble(x);
			i++;
		 }
		return doubleArr;
	}
	public double getFilesAverage(){
		double sum=sumFiles();
		return sum/arr.length;
	}
	public double sumFiles(){
		double sum=0;
		for(String x:this.arr){
			double[] doubleArr=splitStringIntoDoubles(x);
			for(double y: doubleArr){
				sum+=y;
			}
			
		}
		
		return sum;
	}
	
	public MultipleFileReader(int starting, int ending){
		this.starting=starting;
		this.arr=new String[ending-starting+1];
		this.ending=ending;
		int j=0;

		for(int i=starting;i<=ending;i++){
			File f = new File("src\\zad14\\input_"+i+".txt");
			System.out.println(i);
			System.out.println(f.getAbsolutePath());
			String text="";

			Scanner sc;
			try {
				sc = new Scanner(f);
				
				while(sc.hasNextLine()){
					text+=sc.nextLine()+" ";
				}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			arr[j]=text;
			j++;
			
		}
	}

	public int getStarting() {
		return starting;
	}

	public void setStarting(int starting) {
		this.starting = starting;
	}

	public int getEnding() {
		return ending;
	}

	public void setEnding(int ending) {
		this.ending = ending;
	}

	public FileIO getFio() {
		return fio;
	}

	public void setFio(FileIO fio) {
		this.fio = fio;
	}

	public String[] getArr() {
		return arr;
	}

	public void setArr(String[] arr) {
		this.arr = arr;
	}

	
}
