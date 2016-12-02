package zad14;

public class app {

	public static void main(String[] args) {
		
		MultipleFileReader fr = new MultipleFileReader(1,4);
		String [] arr = fr.getArr();
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(fr.sumFiles());
		System.out.println(fr.getFilesAverage());
	}

}
