package planer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		
		//String dateString ="2015­08­04T23:59:59+0200";
		
		//Date = new Date();
		
		try {
			EventGetter eg = new EventGetter();
			eg.downloadEvents("2015-07-01", "2015-07-15");
			ArrayList<Event> events =eg.getEvents();
			System.out.println(events);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
