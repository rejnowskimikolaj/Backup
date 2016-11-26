package zad4;

public class Staff extends Person {
	
	private String school;
	private double pay; 

	public Staff(String name, String adress,String school, double pay) {
		super(name, adress);
		
		this.school=school;
		this.pay=pay;
	}
	
	public String getSchool(){
		return school;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	public String toString(){
		return "Staff[name="+getName()+",adress="+getAdress()+"], school="+school+",pay="+pay+"]";

	}
	

}