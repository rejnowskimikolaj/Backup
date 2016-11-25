package zad6;

public class App {

	public static void main(String[] args) {

		MovablePoint movPoint = new MovablePoint(2,3);
		System.out.println(movPoint);
		
		System.out.println(movPoint.move(1, 2));
	}

}
