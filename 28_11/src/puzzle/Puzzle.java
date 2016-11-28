package puzzle;

import java.util.Scanner;

public class Puzzle {
	
	private String[] words = {"oksymoron", "jajecznica","developer","oko"};
	private String[] arr;
	private String[] underscoreArr;
	private String word;
	private int lives;
	private int livesLeft;

	
	public Puzzle(int i){
		word=words[i];
		lives= (int)Math.ceil(1.5*word.length());
		livesLeft=lives;
		arr=setArr(word);
		underscoreArr=underscore(arr);
		
		
	}

	
	private String[] underscore(String[] arr){
		String[] under=new String[arr.length]; 
		
		for(int i=0;i<arr.length;i++){
			under[i]="_";
		}
		return under;
	}
	
	
	public boolean guess() throws NoLivesException{
		if(livesLeft==0) throw new NoLivesException("Wykorzystano wszystkie proby");
		boolean guessed=false;
		System.out.println("Ilosc prób: "+livesLeft+"|"+lives);
		System.out.println();
		printUnder();
		System.out.println("Podaj litere:");
		Scanner sc = new Scanner(System.in);
		String litera =sc.nextLine();
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals(litera)){
				underscoreArr[i]=litera;
				guessed=true;
			}
		}
		if(guessed==false) {
			System.out.println("Oops");
			livesLeft--;
		}
		else	System.out.println("Dobra robota!");
		printUnder();
		System.out.println();
		if(isWon()==true)return true;
		else return false;
		
	}
	
	private boolean isWon(){
		
		for(String x:underscoreArr){
			if(x.equals("_")) return false;
		}
		System.out.println("################################################");
		System.out.println("Wygrales!!!!");
		System.out.println("################################################");

		return true;
	}
	private String[] setArr(String word){
		return word.split("");

	}


	public String[] getWords() {
		return words;
	}


	public String[] getArr() {
		return arr;
	}


	public String[] getUnderscoreArr() {
		return underscoreArr;
	}


	public String getWord() {
		return word;
	}


	public double getLives() {
		return lives;
	}
	
	public void printArr(){
		for(String x:arr){
			System.out.print(x+" ");
		}
	}
	
	public void printUnder(){
		for(String x:underscoreArr){
			System.out.print(x+" ");
		}
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

}
