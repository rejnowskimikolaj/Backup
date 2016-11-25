package zad9;

import java.util.ArrayList;

public class Window {
	
	private boolean available;
	
	private ArrayList<String> possibleDeps;
	
	public Window(){
		possibleDeps=new ArrayList<>();
		available=true;
	}
	
	public void eatTicket(Ticket ticket,TicketMachine ticketMachine){
		boolean can=false;
		if (available==false) {System.out.println("Nie widzisz, ze jestem zajeta?");return;};
		for(String x:getPossibleDeps()){
			if(ticket.getDep().equals(x)) can=true;
			}
		if (can==false) System.out.println("Zle okienko, zlotko");
		else {
			ticketMachine.deleteTicket(ticket);
			System.out.println("Grazyna: Masz szczescie, zaraz ide na przerwe");
			this.setAvailable(false);
		}
	}

	public ArrayList<String> getPossibleDeps() {
		return possibleDeps;
	}

	public void addPossibleDeps(String dep) {
		possibleDeps.add(dep);
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
		
	public String getStatus(){
		if (available==true) return "wolne";
		else return "zajete";
	}
	

}
