package planer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HTTPConnector {
	private String url;
	private URL obj;
	private HttpURLConnection con;
	private String ua;
	
	
	public HTTPConnector(String url, URL obj, HttpURLConnection con, String ua) {
		this.url = url;
		this.obj = obj;
		this.con = con;
		this.ua = ua;
		con.setRequestProperty("User-Agent", ua);

	}

	public HTTPConnector(String url) throws IOException {
		this.url = url;
		URL ob = new URL(url);
		con = (HttpURLConnection) ob.openConnection();		
		String ua = "Miko³aj/1.1";
		con.setRequestProperty("User-Agent", ua);

	}

	public String getParams(HashMap<String,String> map){
		String result ="";
		Set<String> keys = map.keySet();
		for(String key:keys){
			result+=key+"="+map.get(key)+"&";
		}
		result=result.substring(0,result.length()-1);
		return result;
	}
	
	
	public String send(String type,HashMap<String, String> params) throws IOException{
		if(type.equals("POST")){
			return(sendPOST(params));
		}
		
		else if(type.equals("GET")) return sendGET(params);
		
		else return "Oops";
	}
	
	public String send(String type) throws IOException{
		if(type.equals("GET")) return sendGET();
		else return "oops";
	}

	public void setURL(String url) throws IOException{
		this.url = url;
		 this.obj = new URL(url);
		this.con = (HttpURLConnection) obj.openConnection();		
		this.ua = "Miko³aj/1.1";
		con.setRequestProperty("User-Agent", ua);
	}

	private String sendGET(HashMap<String, String> params) throws IOException {
		setURL(this.url+="?"+getParams(params));
		
		System.out.println(this.url);
		this.con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		String ret="", currentLine = "";
		if(responseCode==200){
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while((currentLine=br.readLine()) !=null){
				ret+=currentLine;
			}
			br.close();
		}
		
		else System.out.println("Code: "+responseCode);
		return ret;
		
	}
	private String sendGET() throws IOException {
		
		this.con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		String ret="", currentLine = "";
		if(responseCode==200){
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while((currentLine=br.readLine()) !=null){
				ret+=currentLine;
			}
			br.close();
		}
		
		else System.out.println("Code: "+responseCode);
		return ret;
		
	}

	private String sendPOST(HashMap<String, String> params) throws IOException {
		this.con.setRequestMethod("POST");
		con.setDoOutput(true);
		DataOutputStream dos = new DataOutputStream(con.getOutputStream());
		String myParams = getParams(params);
		dos.writeBytes(myParams);
		dos.flush();
		dos.close();
		
		int responseCode = con.getResponseCode();
		String ret = "";
		
		if(responseCode==200){
			Scanner sc = new Scanner(new InputStreamReader(con.getInputStream()));
			while(sc.hasNextLine()){
				ret+=sc.nextLine();
			}
			
			sc.close();
		}
		
		else System.out.println("Code: "+responseCode);
		return ret;
	}

}
