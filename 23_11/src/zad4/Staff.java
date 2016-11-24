package zad4;

public class Staff extends Person {
	
	private String school;
	private double pay; 

	public Staff(String name, String adress,String school, double pay) {
		super(name, adress);
		
		this.school=school;
		this.pay=pay;
	}

}
