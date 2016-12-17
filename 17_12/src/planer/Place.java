package planer;

import org.json.simple.JSONObject;

public class Place {

	private String subName;
	private String name;
	private long id;
	
	public Place(JSONObject jo){
		this.subName=(String) jo.get("subname");
		this.name=(String) jo.get("name");
		this.id= (long) jo.get("id");
	}

	
	
	public Place(String subName, String name, int id) {
		super();
		this.subName = subName;
		this.name = name;
		this.id = id;
	}



	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String toString(){
		return name;
	}
	
}
