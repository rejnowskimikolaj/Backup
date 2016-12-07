package Travel;

public class App {

	public static void main(String[] args) {
		TravelerService ts= new TravelerService();
		Offer o1 = new Offer("Polska;Warszawa;17;1700;20");
		Offer o2 = new Offer("Polska;Poznan;17;1200;10");
		Offer o3 = new Offer("Polska;Gdynia;16;1500;22");
		Offer o4 = new Offer("Francja;Paryz;12;2500;30");
		Offer o5 = new Offer("Francja;Santrope;20;3000;22");
		Offer o6 = new Offer("Niemcy;Berlin;17;2000;20");
		Offer o7 = new Offer("Polska;Wroclaw;17;1700;13");
		Offer o8 = new Offer("Polska;Warszawa;17;2500;130");
		Offer o9 = new Offer("Polska;Torun;16;1400;10");
		Offer o10 = new Offer("Polska;Wloclawek;16;1000;5");
		Offer o11 = new Offer("Polska;Ciechocinek;16;1450;15");

		Offer o12 = new Offer("Francja;Paryz;12;2500;30");
		Offer o13 = new Offer("Francja;Santrope;20;3000;22");
		Offer o14 = new Offer("Niemcy;Berlin;17;2000;20");
		ts.addOffer(o1);
		ts.addOffer(o2);
		ts.addOffer(o3);
		ts.addOffer(o4);
		ts.addOffer(o5);
		ts.addOffer(o6);
		ts.addOffer(o7);
		ts.addOffer(o8);
		ts.addOffer(o9);
		ts.addOffer(o10);
		ts.addOffer(o11);
		ts.addOffer(o12);
		ts.addOffer(o13);
		ts.addOffer(o14);

		
		TravelPreferences tp = new TravelPreferences("Polska",15, 18, 1000, 2000,5,30);
		TravelRequest tr = new TravelRequest(tp,12,12);
		
		System.out.println(ts.getRequest(tr).size());
		

		

	}

}
