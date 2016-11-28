import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadNumbers {

	
	
	public double readDouble () {
		Scanner sc = new Scanner(System.in);
		double result;
		try{result = sc.nextDouble();}
		catch(InputMismatchException ime){
			result=0;
		}
	sc.close();
	return result;
	}
	
	public int readInt(){
		Scanner sc = new Scanner(System.in);
		int result;
		try{result = sc.nextInt();}
			catch(InputMismatchException ime){
				result=0;
			}
		sc.close();
		return result;
	}
	
	public String readString(){
		Scanner sc = new Scanner(System.in);
		String result;
		try{result = sc.nextLine();}
			catch(InputMismatchException ime){
				result="";
			}
		sc.close();
		return result;
	}
	
	
}
