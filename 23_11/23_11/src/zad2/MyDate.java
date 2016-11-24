package zad2;

public class MyDate {

	private int year;
	private int month;
	private int day;
	
	private static final String [] strMonths = {"Jan","Feb","Mar", "Apr", "May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	private static final String[] strDays = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
	private static final int[] daysInMonths={31,28,31,30,31,30,31,31,30,31,30,31};
	private static final int[] monthNumbers ={0,3,3,6,1,4,6,2,5,0,3,5};
	private static final int[] leapMonthNumbers ={6,2,3,6,1,4,6,2,5,0,3,5};
	
	public MyDate(int year, int month, int day){
		if(isValidDate(year,month,day)==false) throw new IllegalArgumentException("Invalid day. Get your shit together.");
		this.year=year;
		this.month=month;
		this.day=day;
		
	}
	
	public static int getDayOfWeek(int year,int month, int day){
		int result=year;
		result+=year/4;
		result-=year/100;
		result+=year/400;
		result+=day;
		if (isLeapYear(year)==true) result+=leapMonthNumbers[month-1];
		else  result+=monthNumbers[month-1];
		result--;
		return result%7;
		
	}
	
	public void setDate(int year, int month, int day){
		if(isValidDate(year,month,day)==false) throw new IllegalArgumentException("Invalid day. Get your shit together.");
		this.year=year;
		this.month=month;
		this.day=day;
		
	}
	
	
	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}


	public void setYear(int year) {
		if (isValidDate(year, this.month, this.day)==false) throw new IllegalArgumentException("Invalid year");
		this.year = year;
	}

	public void setMonth(int month) {
		if (isValidDate(this.year, month, this.day)==false) throw new IllegalArgumentException("Invalid month");
		this.month = month;
	}

	public void setDay(int day) {
		if (isValidDate(this.year, this.month, day)==false) throw new IllegalArgumentException("Invalid day");
		this.day = day;
	}

	public static boolean isLeapYear(int year){
		
		if(!(year%4==0)) return false;
		else if (!(year%100==0)) return true;
		else if (!(year%400==0)) return false;
		else return true;
	}
	
	public static boolean isValidDate(int year, int month, int day){
		if (month<1 || month >12) return false;
		if(isLeapYear(year)==true && month==2&&day<=29&&day>0) return true;
		if (day<1||day>daysInMonths[month-1]) return false;
		return true;
	}
	

	
	public MyDate nextDay(){
		if (this.day == daysInMonths[this.month-1]) {
			this.day = 1;
			if (this.month == 12) {
				this.month = 1;
				
				this.year++;
			} else
				this.month++;

		} else
			this.day++;
		return this;
	}
	
	public MyDate nextDay2(){
		int day=this.day;
		int month = this.month;
		int year=this.year;
		if(isLeapYear(year)==true&&this.day==28&&this.month==2) return new MyDate(year,month,29);
		else if(isLeapYear(year)==true&&this.day==29&&this.month==2) return new MyDate(year,month+1,1);
		day = day==daysInMonths[this.month-1] ? 1:++day;
		month = day==1 ? (month=month==12?1:month+1):this.month;
		year = month==1&&day==1 ? ++year : year;
		return new MyDate(year,month,day);
		
		
	}
	public MyDate nextMonth(){
		if (this.month == 12) {
			this.month = 1;
			
			this.year++;
		} else
			this.month++;
		return this;
	}
	
	public MyDate nextYear(){
		this.year++;
		return new MyDate(this.year, month, day);
	}
	
	public MyDate prevDay(){
		if (this.day == 1) {
			this.day = daysInMonths[this.month-1];
			if (this.month == 1) {
				this.month = 12;
				
				this.year--;
			} else
				this.month--;

		} else
			this.day--;
		return this;
	}
	
	
	public MyDate prevMonth(){
		if (this.month == 1) {
			this.month = 12;
			
			this.year--;
		} else
			this.month--;
		return this;
	}

	public MyDate prevYear(){
		
		this.year--;
		return new MyDate(this.year, month, day);
	}
	
	public String toString(){
		return strDays[getDayOfWeek(this.year,this.month,this.day)]+" "+this.day+" "+strMonths[this.month-1]+" "+this.year;
	}
	
	
}
