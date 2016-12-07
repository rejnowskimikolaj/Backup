package Travel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelerService {
	
	private ArrayList<Offer> offers;
	
	public TravelerService(){
		offers=new ArrayList<>();
	}
	
	public void addOffer(Offer offer) {
		offers.add(offer);
	}
	
	public ArrayList<Offer> getRequest(TravelRequest request){
		ArrayList<Offer> offerList = new ArrayList<>();
		offers.stream().filter(x->x.getCountry().equals(request.getTravelPreferences().getCountry()))
						.filter(x-> (x.getCost()>=request.getTravelPreferences().getMinPrice()
									&&x.getCost()<=request.getTravelPreferences().getMaxPrice()))
						.filter(x-> (x.getTemp()>=request.getTravelPreferences().getMinTemp()
									&&x.getTemp()<=request.getTravelPreferences().getMaxTemp()))
						.filter(x-> (x.getEvents()>=request.getTravelPreferences().getMinEvents()
									&&x.getTemp()<=request.getTravelPreferences().getMaxEvents()))
						.forEach(x->offerList.add(x));
		
		System.out.println(offerList);
		System.out.println("Ilosc rekordow:" +offerList.size());
		printRequestResponse(offerList);
		return offerList;
		
		
	}
	
	private void printRequestResponse(ArrayList<Offer> offerList ){
	
		Scanner sc = new Scanner(System.in);
		System.out.println("podaj zakres");
		int recordsOnPage = sc.nextInt();
		int page = 0;
		while(page!=-1){
			System.out.println("podaj strone");
			page=sc.nextInt();
			if((page+1)*recordsOnPage>offerList.size()){
				System.out.println("wyszedles poza zakres. ostatnie "+recordsOnPage+ ":");
				System.out.println(offerList.subList( offerList.size()-recordsOnPage, offerList.size()));
				continue;}
			System.out.println(offerList.subList(recordsOnPage*(page), recordsOnPage*(page+1)));
			
		}
		
		
	}

}
