package zad8;

public class app {

	public static void main(String[] args) {
		Columner c = new Columner("src\\zad8\\data.txt");
//		double[] arr=c.columnToArr("src\\zad8\\data.txt", 1);
//		for(double x : arr){
//			System.out.println(x);
//		}
		
		c.readColumn(0);
		c.writeColumn("src\\zad8\\columnData.txt");
		

	}

}
