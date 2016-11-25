package zad9;

import java.util.ArrayList;

public class Office {

	private TicketMachine ticketMachine;
	
	private ArrayList<Window> windowList;
	
	public Office(){
		windowList=new ArrayList<Window>();
		ticketMachine=new TicketMachine();
		windowList.add(new WindowA());
		windowList.add(new WindowB());
		windowList.add(new WindowAB());
		windowList.add(new WindowABC());
		windowList.add(new WindowBC());
		
	}
	
	public void resetWindows(){
		for(Window x:windowList){
			x.setAvailable(true);
		}
		
		System.out.println("Grazyny pospieszyly sie. Do wyboru do koloru:");
		int nr = 1;
		for(Window x: windowList){
			System.out.println(nr+"# "+x.toString()+":"+x.getStatus());
			nr++;
		}
	}
	
	public void giveTicket(String dep){
		ticketMachine.makeTicket(dep);
		System.out.println("Wydano ticket "+ticketMachine.getTicketList().get(ticketMachine.getTicketList().size()-1));
	}
	
	public void showAvailable(){
		System.out.println(ticketMachine.getTicketList());
		int nr = 1;
		for(Window x: windowList){
			System.out.println(nr+"# "+x.toString()+":"+x.getStatus());
			nr++;
		}
		
	}
	
	public void goToWindow(int tick, int okno){
		System.out.println(ticketMachine.getTicketList().get(tick-1)+" idzie do " + windowList.get(okno-1));
		windowList.get(okno-1).eatTicket(ticketMachine.getTicketList().get(tick-1), ticketMachine);
	}
	
	public TicketMachine getTicketMachine() {
		return ticketMachine;
	}

	public ArrayList<Window> getWindowList() {
		return windowList;
	}
	
	
	
	
}
