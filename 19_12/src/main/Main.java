package main;

public class Main {

	public static void main(String[] args) {

		int[] arr ={1,5,2,6,7,3};
//		SortingApp.przezWyborSort(arr);
//		for(int x:arr){
//			System.out.println(x);
//		}
//		
		SortingApp sa = new SortingApp();
		int[]result1 = sa.giveHalf(arr, 1);
		int[]result2=sa.giveHalf(arr, 2);
		for(int x:result1){
			System.out.print(x+",");
		}
		System.out.println();
		for(int x:result2){
			System.out.print(x+",");
		}
	}

}
