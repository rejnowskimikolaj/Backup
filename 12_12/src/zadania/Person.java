package zadania;

public class Person {

//	-name:String
//	-lastname:String
//	-company:String
//	-salary:double
//	-department:String
//	-yearOfBorn:int
	
	private String name;
	private String lastName;
	private String company;
	private double salary;
	private String department;
	private int yearOfBorn;
	public Person(String name, String lastName, String company, double salary, String department, int yearOfBorn) {
		this.name = name;
		this.lastName = lastName;
		this.company = company;
		this.salary = salary;
		this.department = department;
		this.yearOfBorn = yearOfBorn;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getYearOfBorn() {
		return yearOfBorn;
	}
	public void setYearOfBorn(int yearOfBorn) {
		this.yearOfBorn = yearOfBorn;
	}
	
	
}
