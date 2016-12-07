package ClassCompareUtil;

public class ClassCompareUtility <T extends SchoolClass>{
	
	private SchoolClass schoolClass;
	
	
	public SchoolClass getSchoolClass(){
		return this.schoolClass;
	}

	
	public ClassCompareUtility(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

	public int compareAverage(ClassCompareUtility<?> second  ){
		if(schoolClass.getAverage()>second.getSchoolClass().getAverage()) return 1;
		else if (schoolClass.getAverage()<second.getSchoolClass().getAverage()) return -1;
		else return 0;
	}
	
	public boolean compareLectures(ClassCompareUtility<T> second ){
		return this.schoolClass.getLectures().equals(second.getSchoolClass().getLectures());
	}
}
