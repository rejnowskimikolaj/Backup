package zad8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

//
//-filename:String
//-currentColumn:double[]
//+Columner
//+Columner(filename:String)
//+sumColumn(column:int):double
//+avgColumn(column:int):double
//+countColumn(column:int):int
//+maxColumn(column:int):double
//+minColumn(column:int):double
//-readFile():void
//+writeColumn(filename:String):void
//+readColumn(column:int)

public class Columner {
	
	
	private String fileName;
	private double[] currentColumn;
	
	public Columner(String fileName){
		this.fileName=fileName;
		currentColumn=new double[5];
	}
	
	
	public double[] columnToArr(String fileName, int column){
		File f = new File(fileName);
		File f2 = new File(fileName);

		double[]arr;
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
		arr = new double[counter];
		counter=0;
		try {
			Scanner sc2 = new Scanner(f);
			while(sc2.hasNextLine()){
				String[]splitArr=sc2.nextLine().split("\t");
				arr[counter]=Double.parseDouble(splitArr[column].replace(",", "."));
				counter++;
			}
		}
		 catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return arr;
	}	
		
	
	public double countColumn(int column){
	double[] arr = columnToArr(fileName,column);
	double result = 0;
	for(double x: arr){
		result++;
	}
	return result;
	
	}
	public double sumColumn(int column){
		double[] arr = columnToArr(fileName,column);
		double result = 0;
		for(double x: arr){
			result+=x;
		}
		return result;
		
	}
	
	public double averageColumn(int column){
		return sumColumn(column)/countColumn(column);
	}
	
	public double maxColumn(int column){
		double[]arr=columnToArr(fileName, column);
		double result = arr[0];
		for(double x: arr){
			if(x>result) result=x;
		}
		return result;
	}
	
	public double minColumn(int column){
		double[]arr=columnToArr(fileName, column);
		double result = arr[0];
		for(double x: arr){
			if(x<result) result=x;
		}
		return result;
	}
	
	public void readColumn(int column){
		//sumê, œredni¹ elementów oraz ich iloœæ, maksymalny i minimalny element.
		currentColumn[0]=sumColumn(column);
		currentColumn[1]=averageColumn(column);
		currentColumn[2]=countColumn(column);
		currentColumn[3]=maxColumn(column);		
		currentColumn[4]=minColumn(column);

	}
	
	public void writeColumn(String fileName){
		File f2 = new File(fileName);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f2);
			PrintWriter pw = new PrintWriter(fos);
			pw.println("suma: "+currentColumn[0]);
			pw.println("srednia: "+currentColumn[1]);
			pw.println("ilosc: "+currentColumn[2]);
			pw.println("max: "+currentColumn[3]);
			pw.println("min: "+currentColumn[4]);
			pw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
