package Exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;



public class Fibonacci {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String text="";
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(1);
		int index=2;
		while(text.equals("")){
			text=sc.nextLine();
			list.add(list.get(index-1)+list.get(index-2));
			index++;
		}
		
//		for(int x:list){
//			System.out.println(x);
//		}
//		 int i=0;
//		for(int x:list){
//			if ((x%2==0)||(x%3==0)) list.remove(i);
//			i++;
//		}
		
		for(int x:list){
			System.out.println(x);
		}
		
		ListIterator<Integer> listIterator = list.listIterator();
		int number;
		while (listIterator.hasNext()) {
			number=listIterator.next();
			if(number%2==0||number%3==0) listIterator.remove();
		}
		
		for(int x:list){
			System.out.println(x);
		}
		
		
		File f2 = new File("src\\Exercises\\fibonacci.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f2);
			PrintWriter pw = new PrintWriter(fos);
			list.forEach(s -> pw.println(s));
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
