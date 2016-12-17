package planer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EventGetter {
	
	private HTTPConnector connector;
	private ArrayList<Event> events;
	private String url;
	
	public EventGetter() throws IOException{
		this.url= "http://planer.info.pl/api/rest/events.json";
		this.connector=new HTTPConnector(url);
		this.events=new ArrayList<Event>();
	}
	
	public void downloadEvents(String startDate,String endDate) throws IOException{
		JSONParser parser = new JSONParser();
		JSONArray ja=new JSONArray();
		Object o;
		HashMap<String,String> dateParams = new HashMap();
		dateParams.put("start_date", startDate);
		dateParams.put("endDate", endDate);
		try {
			o = parser.parse(connector.send("GET",dateParams));
			 ja = (JSONArray) o;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Object ob:ja){
			events.add(new Event((JSONObject)ob));
		}
		
		
	}

	public HTTPConnector getConnector() {
		return connector;
	}

	public void setConnector(HTTPConnector connector) {
		this.connector = connector;
	}

	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
