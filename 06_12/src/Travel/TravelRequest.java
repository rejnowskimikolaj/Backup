package Travel;

public class TravelRequest {

	private TravelPreferences travelPreferences;
	private int recordsOnPage;
	private int pageNumber;
	//recordsOnPage i pageNumber i tak nie zostana uzyte, zmienne te sa uwzgledniane w metodzie print w travelService
	public TravelRequest(TravelPreferences travelPreferences, int recordsOnPage, int pageNumber) {
		this.travelPreferences = travelPreferences;
		this.recordsOnPage = recordsOnPage;
		this.pageNumber = pageNumber;
	}
	public TravelPreferences getTravelPreferences() {
		return travelPreferences;
	}
	public void setTravelPreferences(TravelPreferences travelPreferences) {
		this.travelPreferences = travelPreferences;
	}
	public int getRecordsOnPage() {
		return recordsOnPage;
	}
	public void setRecordsOnPage(int recordsOnPage) {
		this.recordsOnPage = recordsOnPage;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	
}
