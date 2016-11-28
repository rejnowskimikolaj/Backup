package puzzle;

import puzzle.Puzzle.NoLivesException;

public class app {

	public static void main(String[] args) {

		Puzzle puz = new Puzzle(2);
		
//		for(String x:arr){
//			System.out.print(x+" ");
//		}
//		System.out.println();
//		
//		for(String x:under){
//			System.out.print(x+" ");
//		}
		
		try {
			while(puz.guess()==false){
				
			}
		} catch (NoLivesException e) {
			// TODO Auto-generated catch block
			System.out.println("##################");
			System.out.println("Przegrales :(");
		}
		
	}

}
