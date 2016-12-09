package games;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements Playable {
	
private ArrayList<String>games;
private ProperPrinter pp = new ProperPrinter(60);

	public Menu(){
		this.games = new ArrayList<String>();
		games.add("GuessWord");
		games.add("GuessNumber");
		games.add("Equation");
		games.add("SortingGame");
		games.add("Who Wants To Be A Millionaire?");
	}

	@Override
	public void run() {
		
	}

	@Override
	public void game() {
		pp.delim();
		pp.print("GAMES");
		pp.delim();

		for(int i=0;i<games.size();i++){
			pp.print((i+1+" | "+ games.get(i)));
		}
		pp.print("0 | Exit");
		pp.delim();
		chooseGame();
	}
	
	private void chooseGame(){
		Scanner sc = new Scanner(System.in);
		Playable game;
		int i = sc.nextInt();
		if(i==0) {
			pp.delim();
			pp.print("Do widzenia :)");
			pp.delim();
			return;
		}
		else if(i==1) game= new GuessWord("src\\games\\words.txt",this.pp);
		else if(i==2)game=new GuessNumber(this.pp);
		else if(i==3)game=new Equation(this.pp);
		else if(i==4) game = new SortingGame(this.pp);
		else game=new WhoWantsToBeMillionaire(this.pp);
		game.run();
		game();
	}
}