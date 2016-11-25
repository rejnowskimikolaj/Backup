package zad8;

import java.util.Date;

public class App {

	public static void main(String[] args) {

		Customer custom1 = new Customer("Jacek", "gold");
		Customer custom2=new Customer("Olek","silver");
		Customer custom3 = new Customer("Franek");
		
		Visit visit1 = new Visit(custom1, new Date(), 100,200);
		System.out.println(visit1);

		visit1.setProductExpense();
		visit1.setProductExpense();

		visit1.setServiceExpense();
		System.out.println(visit1);
	}

}
