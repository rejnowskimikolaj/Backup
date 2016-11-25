package zad1;

public class MyTime {

	private int hour = 0;
	private int minute = 0;
	private int second = 0;

	public MyTime() {

	}

	public MyTime(int hour, int minute, int second) {
		if (hour < 0 || hour > 24)
			throw new IllegalArgumentException("Wrong hour, should be 0-24");
		if (minute < 0 || minute > 59)
			throw new IllegalArgumentException("Wrong minute, should be 0-59");
		if (second < 0 || second > 59)
			throw new IllegalArgumentException("Wrong second, should be 0-59");

		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public void setTime(int hour, int minute, int second) {
		if (hour < 0 || hour > 24)
			throw new IllegalArgumentException("Wrong hour, should be 0-24");
		if (minute < 0 || minute > 59)
			throw new IllegalArgumentException("Wrong minute, should be 0-59");
		if (second < 0 || second > 59)
			throw new IllegalArgumentException("Wrong second, should be 0-59");
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	@Override
	public String toString() {
		return intToString(hour) + ":" + intToString(minute) + ":" + intToString(second);

	}

	public String intToString(int number) {
		String result = Integer.toString(number);
		if (number < 10)
			result = "0" + result;
		return result;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour < 0 || hour > 24)
			throw new IllegalArgumentException("Wrong hour, should be 0-24");

		this.hour = hour;
	}

	public int getMinute() {

		return minute;
	}

	public void setMinute(int minute) {
		if (minute < 0 || minute > 59)
			throw new IllegalArgumentException("Wrong minute, should be 0-59");

		this.minute = minute;
	}

	public int getSecond() {
		if (second < 0 || second > 59)
			throw new IllegalArgumentException("Wrong second, should be 0-59");

		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public MyTime nextSecond() {
		if (this.second == 59) {
			this.second = 0;
			if (this.minute == 59) {
				this.minute = 0;
				if (this.hour == 23) {
					this.hour = 0;
					return this;
				}
				this.hour++;
			} else
				this.minute++;

		} else
			this.second++;
		return this;
	}

	public MyTime nextMinute() {
		if (this.minute == 59) {
			this.minute = 0;
			if (this.hour == 23) {
				this.hour = 0;
				return this;
			}
			this.hour++;
		} else
			this.minute++;
		return this;
	}

	public MyTime nextHour() {
		if (this.hour == 23) {
			this.hour = 0;
			return this;
		}
		this.hour++;

		return this;
	}
	
	public MyTime prevMinute(){
		if (this.minute == 0) {
			this.minute = 59;
			if (this.hour == 0) {
				this.hour = 23;
				return this;
			}
			this.hour--;
		} else
			this.minute--;
		return this;
		
	}
	
	public MyTime prevSecond() {
		if (this.second == 0) {
			this.second = 59;
			if (this.minute == 0) {
				this.minute = 59;
				if (this.hour == 0) {
					this.hour = 23;
					return this;
				}
				this.hour--;
			} else
				this.minute--;

		} else
			this.second--;
		return this;
	}
	
	public MyTime prevHour(){
		if (this.hour == 0) {
			this.hour = 23;
			return this;
		}
		this.hour--;
		return this;
	}

}
