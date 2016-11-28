
public class Division {

	public static double divide(int a, int b) throws IllegalArgumentException{
		if(a==0) throw new IllegalArgumentException("you must not divide by zero");
		return a/b;
	}
	
	public static double divide(double a, double b) throws IllegalArgumentException{
		if(a==0) throw new IllegalArgumentException("you must not divide by zero");
		return a/b;
	}
	
}
