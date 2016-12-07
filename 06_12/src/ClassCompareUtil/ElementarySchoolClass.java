package ClassCompareUtil;

public class ElementarySchoolClass extends SchoolClass {

	public ElementarySchoolClass(String lectures){
		super();
		String[]arr = lectures.split(";");
		for(String x:arr){
			super.getLectures().add(x);
		}
				
	}
}
