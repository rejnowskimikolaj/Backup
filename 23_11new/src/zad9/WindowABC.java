package zad9;

public class WindowABC extends Window {

	public WindowABC(){
		super();
		getPossibleDeps().add("A");
		getPossibleDeps().add("B");
		getPossibleDeps().add("C");
	}
	
	public String toString(){
		return "Okienko ABC";
	}
}
