package main;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) {
		JSONExercise e = new JSONExercise();
//		e.createJSONObject();
//		e.saveJSONArrayToFile(e.arrToJSON(e.randomizeArr()));
//		String[]arr =e.randomizeArr();
//		for(String x:arr){
//			System.out.println(x);
//		}
//		JSONObject jo = e.getJSONObjectFromWords();
//		e.saveJSON(e.getJSONObjectFromWords(), "words.json");
		
		
//		System.out.println(e.getJSONArrayFromCSV("students.csv"));
//		e.saveJSONArrayToFile(e.getJSONArrayFromCSV("students.csv"),"students.json");
		
		try {
			System.out.println(e.getJSONArrayFromFile("src\\resources\\file.json"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
