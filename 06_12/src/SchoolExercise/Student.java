package SchoolExercise;

public class Student {

	private String name;
	private String lastName;
	private int year;
	private long pesel;
	public Student(String name, String lastName, int year, long pesel) {
		this.name = name;
		this.lastName = lastName;
		this.year = year;
		this.pesel = pesel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public long getPesel() {
		return pesel;
	}
	public void setPesel(long pesel) {
		this.pesel = pesel;
	}
	
	
}
