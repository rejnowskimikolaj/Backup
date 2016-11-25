package zad9;

public class WindowB extends Window{

	public WindowB(){
		super();
		getPossibleDeps().add("B");
	}

	public String toString(){
		return "Okienko B";
	}
}
