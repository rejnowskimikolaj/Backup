import java.util.Scanner;

public class app {

	public static void main(String[] args) {

//		int [] arr = new int[10];
//		
//		Scanner sc = new Scanner(System.in);
//		
//		for(int i=0;i<arr.length;i++){
//			arr[i]=sc.nextInt();
//		}
//		
//		
//		try{
//			System.out.println(arr[10]);
//		}
//		catch(ArrayIndexOutOfBoundsException aioobe){
//				aioobe.printStackTrace();
//			}
		
		
		//Square.square(0);
		
//		ReadNumbers rn = new ReadNumbers();
//		System.out.println(rn.readDouble());
		
//		QuadraticEquation qe = new QuadraticEquation();
//		
//		double[] arr=new double[2];
//		try {
//			arr=qe.solve();
//		}
//		
//		catch(ArithmeticException ae){
//			System.out.println(ae.getMessage());
//			
//		}
//		
//		for(double x:arr){
//			System.out.println(x);
//		}
		
		
		People ppl = new People(1);
		try {
			ppl.addPerson("Jaca", "Jackowski", 10, "black", "blue", 10.50);
		} catch (WrongAgeException | BadEyesException | BadHairException | BadShoeException | FullListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}

}
