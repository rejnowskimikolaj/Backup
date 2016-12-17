package planer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;

public class Event {

	private Date endDate;
	private Date startDate;
	private String descLong;
	private String name;
	private Place place;
	
	public Event(JSONObject jo){
		this.place= new Place((JSONObject) jo.get("place"));
		this.name=(String) jo.get("name");
		this.descLong=(String) jo.get("descLong");
//		String dateString = (String) jo.get("endDate");
//		
//		jo.get("endDate");
//		dateString = dateString.substring(0, 10);
//
//		DateFormat df = new SimpleDateFormat("yyyy-mm-dd ");
//		try {
//			this.endDate=df.parse(dateString);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getDescLong() {
		return descLong;
	}

	public void setDescLong(String descLong) {
		this.descLong = descLong;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	public String toString(){
		return "EVENT: "+ this.name +"\n" +"WHERE: "+ this.place ;
	}
	
	
}
