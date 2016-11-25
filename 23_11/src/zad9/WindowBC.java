package zad9;

public class WindowBC extends Window{
	
	public WindowBC(){
		super();
		getPossibleDeps().add("B");
		getPossibleDeps().add("C");

	}

	public String toString(){
		return "Okienko BC";
	}
}
