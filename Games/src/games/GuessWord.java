package games;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class GuessWord implements Playable {

	private List<String>words;
	private String wordToGuess;
	private int lives;
	private int livesLeft;
	private String fileName;
	private ProperPrinter pp;
	
	public GuessWord(String fileName,ProperPrinter pp){
		File f = new File(fileName);
		this.words=new ArrayList<String>();
		this.pp=pp;
		Scanner sc;
		try {
			sc = new Scanner(f);
			while(sc.hasNextLine()){
				words.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void run() {
		game();
	}
	
	private boolean guess(ArrayList<String>underscored, ArrayList<String>wordToGuess) throws NoLivesException{
		if(livesLeft==0) throw new NoLivesException("Wykorzystano wszystkie proby");
		boolean guessed=false;
		pp.print("Ilosc prób: "+livesLeft+"|"+lives);
		pp.spacer();
		pp.print(underscored.toString());
		pp.print("Podaj litere:");
		Scanner sc = new Scanner(System.in);
		String litera =sc.nextLine();
		int i=-1;
		for(String x: wordToGuess){
			i++;
			if (x.equals(litera)) {guessed =true;
			underscored.set(i, litera);
			}
		}
		if(guessed==false) {
			pp.print("Ooops");
			livesLeft--;
		}
		else	pp.print("Dobra robota!");
		pp.print(underscored.toString());
		pp.spacer();
		if(isWon(underscored)==true)return true;
		else return false;
		
	}
	
private boolean isWon(ArrayList<String> underscored){
		
		for(String x:underscored){
			if(x.equals("_")) return false;
		}
		pp.delim();
		pp.print("WYGRA£EŒ!!!");
		pp.delim();
		return true;
	}

	@Override
	public void game() {
		this.wordToGuess=getRandomWord();
		this.lives=this.wordToGuess.length();
		this.livesLeft=this.wordToGuess.length();
		ArrayList<String> wordToGuessList =  new ArrayList<String>(Arrays.asList(wordToGuess.split("")));
		ArrayList<String> underScored = underscore(wordToGuessList);
		try {
			while(guess(underScored,wordToGuessList )==false);
		} catch (NoLivesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
	}

	private String getRandomWord(){
		Random rd = new Random();
		return words.get(rd.nextInt(words.size()));
	
		
	}
	
	private ArrayList<String> underscore(ArrayList<String> list){
		
		ArrayList<String> result = new ArrayList<String>();
		for(String x:list){
			result.add("_");
		}
		return result;
	}
	
	
	class NoLivesException extends Exception{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public NoLivesException(String message){
			super(message);
		}
		
		public NoLivesException(){
			super("You lost");
		}
	}
	
	public String toString(){
		return "GuessWord";
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	public String getWordToGuess() {
		return wordToGuess;
	}

	public void setWordToGuess(String wordToGuess) {
		this.wordToGuess = wordToGuess;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getLivesLeft() {
		return livesLeft;
	}

	public void setLivesLeft(int livesLeft) {
		this.livesLeft = livesLeft;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ProperPrinter getPp() {
		return pp;
	}

	public void setPp(ProperPrinter pp) {
		this.pp = pp;
	}
	
	
}
