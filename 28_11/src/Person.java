
public class Person {

	private String name;
	private String secondName;
	private int age;
	private String hair;
	private String eyes;
	private double shoe;
	
	
	public Person(String name, String secondName, int age, String hair, String eyes, double shoe) throws WrongAgeException {
		super();
		this.name = name;
		this.secondName = secondName;
		if (age<0||age>130) throw new WrongAgeException();
		this.age = age;
		this.hair = hair;
		this.eyes = eyes;
		this.shoe = shoe;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHair() {
		return hair;
	}
	public void setHair(String hair) {
		this.hair = hair;
	}
	public String getEyes() {
		return eyes;
	}
	public void setEyes(String eyes) {
		this.eyes = eyes;
	}
	public double getShoe() {
		return shoe;
	}
	public void setShoe(double shoe) {
		this.shoe = shoe;
	}
	
	
}
