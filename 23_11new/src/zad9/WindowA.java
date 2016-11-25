package zad9;

public class WindowA extends Window {
	
	public WindowA(){
		super();
		getPossibleDeps().add("A");
	}
	
	public String toString(){
		return "Okienko A";
	}

}
