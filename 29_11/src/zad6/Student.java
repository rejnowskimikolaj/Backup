package zad6;

public class Student {

	int index;
	String name;
	String secondName;
	String course;
	double averageMark;
	public Student(int index, String name, String secondName, String course, double averageMark) {
		this.index = index;
		this.name = name;
		this.secondName = secondName;
		this.course = course;
		this.averageMark = averageMark;
	}
	
	public Student(){
		this.index = 0;
		this.name = "Jan";
		this.secondName = "Kowalski";
		this.course = "Java programming";
		this.averageMark = 4.5;
	}
	
	
	
	
	
}
