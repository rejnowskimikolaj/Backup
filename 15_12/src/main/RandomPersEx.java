package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RandomPersEx {

	public static void main(String[] args) {

		try {
			HashMap <String, String > map = new HashMap<>();
			map.put("nat", "US");
			map.put("results", "10");
			HTTPConnector hc =new HTTPConnector("https://randomuser.me/api/");
			System.out.println(hc.getParams(map));

			JSONParser parser = new JSONParser();
			//System.out.println(hc.send("GET"));
			Object o = parser.parse(hc.send("GET",map));
			JSONObject jo = (JSONObject) o;
			System.out.println(jo);
			JSONArray ja = (JSONArray)jo.get("results");
			
			ArrayList<String> nameGenderMail = new ArrayList<>();
			for(Object obj: ja){
				JSONObject job = (JSONObject)obj;
				JSONObject name = (JSONObject)job.get("name");
				String stringName = name.get("first")+" "+name.get("last");
				nameGenderMail.add(stringName+" "+job.get("gender")+" "+job.get("email"));
			}
			
			System.out.println(nameGenderMail);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
