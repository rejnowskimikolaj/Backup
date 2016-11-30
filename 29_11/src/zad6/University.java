package zad6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class University {
	
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
	
	private void writeFile(String[] fileContent){
		
		File f2 = new File("src\\zad6\\students.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f2,true);
			PrintWriter pw = new PrintWriter(fos);
			String result="";
			for(String x:fileContent){
				result+=x+"\t";
				
			}
			pw.println(result);
			pw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	private void editText(){
//		
//		
//		File f = new File("src\\main\\test.txt");
//		Scanner sc;
//		try {
//			sc = new Scanner(f);
//		
//			while(sc.hasNextLine()){
//				myString.split("\\s+");
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	private String getIndex(String text){
//		text.split("\t");
//		
//	}

	private boolean isStudentExists(int index){
		String stringIndex = Integer.toString(index);
		boolean result =false;
		
		String[] arr =readFile("src\\zad6\\students.txt");
		
		for(String x: arr){
			String[] lineArr = x.split("\t");
			if(lineArr[0].equals(stringIndex)) return true;
		}
		return false;
		
	}
	
	public Student getStudent(int index){
		String stringIndex = Integer.toString(index);
		
		String[] arr =readFile("src\\zad6\\students.txt");
		
		for(String x: arr){
			String[] lineArr = x.split("\t");
			double averageMark = Double.parseDouble(lineArr[4].replace(",", "."));
			if(lineArr[0].equals(stringIndex)) return new Student(index, lineArr[1], lineArr[2], lineArr[3], averageMark);
		}
		return new Student();
	}
	
	private void addStudent(Student student){
		String index = ""+student.getIndex();
		String averageMark=""+student.getAverageMark();
		//public Student(int index, String name, String secondName, String course, double averageMark) {
		String[]arr= {index,student.getName(),student.getSecondName(),student.getCourse(),averageMark};
		writeFile(arr);
	}
	
	public void putStudent(Student student){
		if (isStudentExists(student.getIndex())==false){
			addStudent(student);
		}
		
		else System.out.println("Student with this index already exists!");
	}
	
}
