
public class Square {

	public static double square(double a){
		if(a==0) throw new IllegalArgumentException("Podales liczbe 0");
		return Math.sqrt(a);
	}
}
