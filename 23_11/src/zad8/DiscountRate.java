package zad8;

public class DiscountRate {
	
	private static double serviceDiscountPremium=0.2;
	private static double serviceDiscountGold=0.15;
	private static double serviceDiscountSilver=0.1;
	private static double productDiscountPremium=0.1;
	private static double productDiscountGold=0.1;
	private static double productDiscountSilver= 0.1;
	
	
	public static double getServiceDiscountRate(String membership){
		switch(membership){
		case "premium": return serviceDiscountPremium;
		case "gold": return serviceDiscountGold;
		case "silver": return serviceDiscountSilver;
		default: return 0;
		 	
		}
		
	}
	
	public static double getProductDiscountRate(String membership){
		switch(membership){
		case "premium": return productDiscountPremium;
		case "gold": return productDiscountGold;
		case "silver": return productDiscountSilver;
		default: return 0;
		 	
		}
		
	}
	

}
