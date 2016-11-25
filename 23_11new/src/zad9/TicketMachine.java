package zad9;

import java.util.ArrayList;

public class TicketMachine {

	private ArrayList<Ticket> ticketList;
	public TicketMachine(){
		 this.ticketList=new ArrayList<Ticket>();

	}
	
	public void makeTicket(String dep){
		int nextNumber=1;
		for(Ticket x:ticketList){
			if (x.getDep().equals(dep)&&x.getNumber()>=nextNumber) nextNumber=x.getNumber()+1;
		}
		ticketList.add(new Ticket(dep,nextNumber));
		}
	
	public void deleteTicket(Ticket ticket){
		for(Ticket x:ticketList){
			if (ticket.getDep().equals(x.getDep())&& ticket.getNumber()==x.getNumber()){
				ticketList.remove(x);
				break;
			}
		}
	}
	public ArrayList<Ticket> getTicketList(){
		return ticketList;
	}
}
