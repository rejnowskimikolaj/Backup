package ClassCompareUtil;

import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class SchoolClass {

	private ArrayList<Double> marks;
	private ArrayList<String> lectures;
	
	public SchoolClass(){
		lectures=new ArrayList<String>();
		marks = new ArrayList<Double>();
	}
	
	public double getAverage(){
		return (marks.stream().reduce(0.0,(x,y)->x+y))/marks.size();
	}
	
	public  ArrayList<String> getLectures(){
		return this.lectures;
	}

	public ArrayList<Double> getMarks() {
		return marks;
	}

	public void setMarks(ArrayList<Double> marks) {
		this.marks = marks;
	}

	public void setLectures(ArrayList<String> lectures) {
		this.lectures = lectures;
	}
	
	
}
