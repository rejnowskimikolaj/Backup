package zad9;

public class WindowAB extends Window{
	
	public WindowAB(){
		super();
		getPossibleDeps().add("A");
		getPossibleDeps().add("B");
		
	}

	public String toString(){
		return "Okienko AB";
	}

}
