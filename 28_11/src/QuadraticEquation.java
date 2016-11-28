import java.util.InputMismatchException;
import java.util.Scanner;

public class QuadraticEquation {

	private int a;
	private int b;
	private int c;
	
	public QuadraticEquation(){
		
	}
	
	public QuadraticEquation(int a, int b, int c){
		 this.a=a;
		 this.b=b;
		 this.c=c;
	 }
	
	private int getNumber(){
		Scanner sc = new Scanner(System.in);
		int result;
		try{result = sc.nextInt();}
			catch(InputMismatchException ime){
				result=0;
			}
		//sc.close();
		return result;
	}
	
	public double[] solve(){
		
		if(a==0&&b==0&&c==0){
			this.a=getNumber();
			this.b=getNumber();
			this.c=getNumber();
		}
		
		double[] result=new double[2];
		int delta = b*b-4*a*c;
		if(delta<0) throw new ArithmeticException("delta ujemna");
		
		if(a==0&&b!=0&&c!=0){
			result[1]=-c/b;
			result[0]=result[1];
			return result;
		}
		
		result[0]=(-b-Math.sqrt(delta))/2*a;
		result[1]=(-b+Math.sqrt(delta))/2*a;
		return result;
		
	}
}
