package ClassCompareUtil;

import java.util.ArrayList;
import java.util.Random;

public class App {

	public static void main(String[] args) {
		HighSchoolClass hs = new HighSchoolClass("przyra;matma;ang");
		ElementarySchoolClass es = new ElementarySchoolClass("przyra;matma;ang");
		ArrayList<Double> marks1 = new ArrayList<>();
		ArrayList<Double> marks2 = new ArrayList<>();
		Random rd= new Random();
		for(int i=0;i<10;i++){
			marks1.add((double)rd.nextInt(6)+1);
			marks2.add((double)rd.nextInt(6)+1);
		}
		hs.setMarks(marks1);
		es.setMarks(marks2);
		ClassCompareUtility<HighSchoolClass> ccu1 = new ClassCompareUtility<>(hs);
		ClassCompareUtility<ElementarySchoolClass> ccu2 = new ClassCompareUtility(es);
		
		//System.out.println(ccu1.compareLectures(ccu2)); nie zadzia³a, bo ccu2 <elementary>
		System.out.println(marks1);
		System.out.println(ccu1.getSchoolClass().getAverage());
		System.out.println(marks2);
		System.out.println(ccu2.getSchoolClass().getAverage());
		System.out.println(ccu1.compareAverage(ccu2));

	}
	

}
