package Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class MeanScanner {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text;
		text = sc.nextLine();
		String[] numbers=text.split(",");
		ArrayList<Double> doubleList = new ArrayList<>();
		for(String x:numbers){
			double number = Double.parseDouble(x);
			doubleList.add(number);
		}
		double sum=0;
		for(Double x:doubleList){
			sum+=x;
		}
		
		double mean=sum/doubleList.size();
		System.out.println(mean);
	}

}
