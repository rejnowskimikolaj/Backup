package Zad5;

public enum Status {

	PENDING (1,"Oczekujacy"),
	PROGRESS (2,"W trakcie"),
	DONE (3,"Wykonano");
	
	private final int id;
	private final String name;
	
	private Status(int id, String name){
		this.id=id;
		this.name=name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	


	
}
