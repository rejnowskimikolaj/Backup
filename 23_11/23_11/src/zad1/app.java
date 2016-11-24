package zad1;


public class app {

	public static void main(String[] args) {

		MyTime myTime=new MyTime(22,10,0);
		System.out.println(myTime.toString());
		System.out.println(myTime.prevHour().toString());
		System.out.println();
	}

}
