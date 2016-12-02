package zad11;

public class app2 {

	public static void main(String[] args) {

		FileIO io= new FileIO("src\\zad11\\test.txt");
		
		//System.out.println(io.readFileAsString());
//		String[]arr=io.readLines(2, 3);
//		for(String x:arr){
//			System.out.println(x);
//		}
		//String[]arr={"pierwsza nowa linia","druga nowa linia"};
		//io.writeLines(1,arr );
//		String[]arr={"nowa linia 3","nowa linia 4"};
//		io.updateLines(3, arr);
//		System.out.println(io.readFileAsString());
		//io.scrolling();
		
//		String[]arr=io.subArray(io.readFile(), 0, 3);
//		for(String x:arr){
//			System.out.println(x);
//		}

		io.textScrolling();
		
	}

}
