package main;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class getLoc {

	public static void main(String[] args) {
		String url ="http://palo.ferajna.org/sda/host2ip.php?host=wp.pl";
		try {
			HTTPConnector hc = new HTTPConnector(url);
			//HTTPConnector hc2 = new HTTPConnector(url);
			//System.out.println(hc.send("GET"));

			JSONParser par = new JSONParser();
			JSONObject obj = (JSONObject)par.parse(hc.send("GET"));
			System.out.println(obj);
			
			String ip = obj.get("ip").toString();
			System.out.println(ip);
			
			hc.setURL("http://api.db-ip.com/v2/b620ee363136c97670e9054d4d2fa361c642c789/"+ip);
			
			System.out.println(hc.send("GET"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
