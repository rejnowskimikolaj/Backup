package games;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber implements Playable {

	
	private int number;
	private String name="GuessNumber";
	private ProperPrinter pp;
	
	
	public GuessNumber(ProperPrinter pp) {
		Random rd = new Random();
		this.pp=pp;
		this.number=rd.nextInt(11);
	}
	
	@Override
	public void run() {
		game();
	}
	@Override
	public void game() {
		boolean result = false;
		pp.delim();
		while(result==false){
			
			result=checkNumber(readNumber());
		}
		pp.delim();
		pp.print("WYGRA£EŒ!!!");
		pp.delim();
	}
	
	public int readNumber(){
		Scanner sc = new Scanner(System.in);
		pp.print("Podaj liczbê:");
		return sc.nextInt();
	}
	
	public boolean checkNumber(int number){
		return (number==this.number);
		
		
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return "GuessNumber";
	}
	
}
