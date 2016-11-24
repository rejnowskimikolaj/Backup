package zad4;

public class Person {
	
	private String name;
	private String adress;
	
	public Person(String name, String adress){
		this.adress=adress;
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String toString(){
		return "Person[name="+name+",adress="+adress+"]";
	}
	

}
