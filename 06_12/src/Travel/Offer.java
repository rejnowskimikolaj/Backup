package Travel;

public class Offer {
	
	private String country;
	private int temp;
	private int cost;
	private int events;
	private String city;
	
	public Offer(String country,String city , int temp, int cost, int events) {
		this.country = country;
		this.temp = temp;
		this.cost = cost;
		this.events = events;
		this.setCity(city);
	}
	
	public Offer(String offer){
		String[] array=offer.split(";");
		this.country=array[0];
		this.city=array[1];
		this.temp=Integer.parseInt(array[2]);
		this.cost=Integer.parseInt(array[3]);
		this.events=Integer.parseInt(array[4]);
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getEvents() {
		return events;
	}
	public void setEvents(int events) {
		this.events = events;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString(){
		return country+" "+city+" "+temp+" "+cost+" "+events;
	}

}
