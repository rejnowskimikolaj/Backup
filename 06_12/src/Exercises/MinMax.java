package Exercises;

import java.util.ArrayList;
import java.util.Random;

public class MinMax {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> array = new ArrayList<>();
		int[]daneTestowe= new int[]{1,223,43,65,2,5,6,323,43,65,1,2,5,3,5432,3,1432};
		for(int i=0;i<daneTestowe.length;i++){
			array.add(daneTestowe[i]);
		}
		int max=array.get(0);
		int min=array.get(0);
		
		for(int x:array	){
			if (x>max) max=x;
			if (x<min) min=x;
		}
		
		System.out.println(max);
		System.out.println(min);
		
		
	}

}
