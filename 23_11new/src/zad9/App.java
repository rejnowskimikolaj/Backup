package zad9;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Office office = new Office();
		
		Scanner reader = new Scanner(System.in);  
		String main = "(1): wydaj bilet   ||| (2): idz do okienka ||| (3) pospiesz grazyny";
		String giveTicket = "(1): Departament A   ||| (2): Departament B ||| (3): Departament C";
		String ticket = "Ktory masz ticket?";
		String window = "Podaj nr okienka";
		
		while(true){
			
			System.out.println(main);
			int n = reader.nextInt();
			
			switch(n){
			case 1: System.out.println(giveTicket);
			 		n = reader.nextInt();
			 		switch(n){
			 		case 1: 
			 			office.giveTicket("A");
			 			break;
			 		case 2:
			 			office.giveTicket("B");
			 			break;
			 		case 3:
			 			office.giveTicket("C");
			 			break;

			 		}
			 break;
			case 2:	if(office.getTicketMachine().getTicketList().isEmpty()) {System.out.println("Najpierw wez bilet!");break;}
					System.out.println(ticket);
					System.out.println(office.getTicketMachine().getTicketList());
			 		n = reader.nextInt();
			 		System.out.println(window);
			 		office.showAvailable();
			 		int m = reader.nextInt();
					office.goToWindow(n, m);
			 break;
			
			case 3: office.resetWindows();
					
			 
			}
			
		}
		

		
	}

}
