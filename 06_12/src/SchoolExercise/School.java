package SchoolExercise;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School {

	private Map<Long, StudentData> peselParents;
	private List<Student> studentList;
	
	public School(){
		this.peselParents=new HashMap<>();
		this.studentList=new ArrayList<>();
	}
	
	public int getClass(int year){
		return  Calendar.getInstance().get(Calendar.YEAR)-year-7;
		
	}
	public void addStudent(Student student, StudentData studentData ){
		this.peselParents.put(student.getPesel(), studentData);
		this.studentList.add(student);
	}
	
	public ArrayList<Student> getYear(int year){
		ArrayList<Student> result = new ArrayList<>();
		for(Student x:studentList){
			if(x.getYear()==year) result.add(x);
		}
		
		return result;
	}
	
	
	
}
