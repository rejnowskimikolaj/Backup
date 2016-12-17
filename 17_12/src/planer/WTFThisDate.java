package planer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WTFThisDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dateString = "2015­08­04T23:59:59+0200";
		String correctDate = "2015-08-04";
		Date endDate; 
		dateString = dateString.substring(0, 10);
		System.out.println(correctDate);
		System.out.println(dateString);

		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		try {
			endDate = df.parse(correctDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
