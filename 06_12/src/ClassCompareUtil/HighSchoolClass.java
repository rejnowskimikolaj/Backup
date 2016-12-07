package ClassCompareUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class HighSchoolClass extends SchoolClass{

	public HighSchoolClass(String lectures){
		super();
		String[]arr = lectures.split(";");
		for(String x:arr){
			super.getLectures().add(x);
		}
				
	}

}
