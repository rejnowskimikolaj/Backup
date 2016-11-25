package zad9;

public class Ticket {
	
	private String dep;
	private int number;

	public Ticket(String dep, int number){
		this.dep=dep;
		this.number=number;
	}

	public String getDep() {
		return dep;
	}

	public int getNumber() {
		return number;
	}
	
	public String toString(){
		return dep+""+number;
	}
}
