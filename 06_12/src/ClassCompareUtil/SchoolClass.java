package ClassCompareUtil;

import java.util.ArrayList;

public abstract class SchoolClass {

	private ArrayList<Double> marks;
	private ArrayList<String> lectures;
	
	public SchoolClass(){
		lectures=new ArrayList<String>();
		marks = new ArrayList<Double>();
	}
	
	public double getAverage(){
		return marks.stream().count()/marks.size();
	}
	
	public abstract ArrayList<String> getLectures();
	
	
}
