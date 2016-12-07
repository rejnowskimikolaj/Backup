package Travel;

public class TravelPreferences {

	private int minTemp;
	private int maxTemp;
	private int minPrice;
	private int maxPrice;
	private String country;
	private String city;
	private int minEvents;
	private int maxEvents;
	
	public TravelPreferences(String country,int minTemp, int maxTemp, int minPrice, int maxPrice, int minEvents,int maxEvents) {
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.country = country;
		this.minEvents=minEvents;
		this.maxEvents=maxEvents;
	}

	public int getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(int minTemp) {
		this.minTemp = minTemp;
	}

	public int getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(int maxTemp) {
		this.maxTemp = maxTemp;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getMinEvents() {
		return minEvents;
	}

	public void setMinEvents(int minEvents) {
		this.minEvents = minEvents;
	}

	public int getMaxEvents() {
		return maxEvents;
	}

	public void setMaxEvents(int maxEvents) {
		this.maxEvents = maxEvents;
	}


	
	
	
	
}
