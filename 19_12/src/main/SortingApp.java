package main;

public class SortingApp {

	
	
	public static void bubbleSort(int[]arr){
		
		boolean switched =true;
		while(switched==true){
		 switched = false;
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]>arr[i+1]){
				int temp = arr[i+1];
				arr[i+1]=arr[i];
				arr[i]=temp;
				switched = true;
				}
			}
		}
		
	}
	
	public static void insertSort(int []arr){
		
		int j=arr.length-2;
		
		while(j>=1){
			int x=arr[j];
			int i = j+1;
			
			if(i<=arr.length&&x>arr[i]){
				int temp = arr[i-1];
				arr[i-1]=arr[i];
				arr[i]=temp;
				i++;
			}
			else{
				arr[i-1]=x;
				j--;
			}
		}
	}
	
	public static void przezWyborSort(int[]arr){
		
		int j=0;
		
		while(j<arr.length){
			int min = j;
			int i = j+1;
			
			while(i<arr.length){
				if (arr[i]<arr[min]){
					min=i;
				}
				i++;
			}
			int temp = arr[min];
			arr[min]=arr[j];
			arr[j]=temp;
			j++;
		}
	}
	
	public int[] giveHalf(int[]arr,int half){
		int[]arrHalf = new int[arr.length/2];
		if(half==1){
			for(int i=0;i<arrHalf.length;i++){
				arrHalf[i]=arr[i];
			}
		}
		
		else{
			if(arr.length%2!=0) arrHalf=new int[(arr.length/2)+1];
			for(int i=0;i<arrHalf.length;i++){
				arrHalf[i]=arr[i+arr.length/2];
			}
		}
		
		return arrHalf;
	}
	
	
	
	public  int[] mergeSorting(int[]arr){
		int[]temp = copyArr(arr);
		int[]half1=giveHalf(arr,1);
		int[]half2=giveHalf(arr,2);
		
	}
	
	public int[] copyArr(int[]arr){
		int[]result = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			result[i]=arr[i];
		}
		
		return result;
	}
}
