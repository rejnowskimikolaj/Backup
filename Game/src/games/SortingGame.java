package games;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class SortingGame implements Playable {
	
	private String fileName;
	private ArrayList<String> words;
	private ArrayList<String> wordsToPlay=new ArrayList<String>();
	private ProperPrinter pp;
	private Level level;
	private long time;
	private boolean isWon=false;
	
	public SortingGame(ProperPrinter pp){
		this.fileName="src\\games\\words.txt";
		this.level=Level.MEDIUM;
		this.pp=pp;
		setUp();
		randomize(this.words,level);
	}

	@Override
	public void run() {
		game();
	}

	@Override
	public void game() {
		Scanner sc = new Scanner(System.in);
		pp.delim();
		pp.print("SORTING GAME");
		pp.delim();
		pp.spacer();
		pp.print("Wciúnij przycisk, by zaczπÊ grÍ");
		sc.nextLine();
		pp.delim();
		printWordsMessed(wordsToPlay);
		Long startTime =System.currentTimeMillis();
		pp.delim();
		pp.print("Podaj kolejnoúÊ,");
		pp.print("wpisujπc cyfry po kolei:" );
		pp.delim();
		String answer = sc.nextLine();
		pp.delim();
		Long endTime =System.currentTimeMillis();
		ArrayList<String> userSort = new ArrayList<String>();
		userSort(userSort,answer);
		pp.print("Twoja odpowiedü:");
		printWords(userSort);
		pp.delim();
		pp.print("Poprawna odpowiedü:");
	    StringLengthListSort ss = new StringLengthListSort();
	    Collections.sort(wordsToPlay, ss);
	    printWords(wordsToPlay);
	    if(isCorrect(userSort,wordsToPlay)) {
	    pp.delim();
	    pp.print("Poprawna odpowiedü!!");
	    pp.print("WYGRA£Eå!");
	    this.isWon=true;
	   
	    }
	    else{
	    	 pp.delim();
	 	    pp.print("Niepoprawna odpowiedü!!");
	 	    pp.delim();
	    }
	    
	    pp.print("TwÛj czas:");
	    this.time = endTime-startTime;
	    pp.print(""+time/1000+" sekund");
	    pp.delim();
	}

	private boolean isCorrect(ArrayList<String> userSort, ArrayList<String> correct){
		for(int i =0;i<correct.size();i++){
			if(userSort.get(i).length()!=correct.get(i).length()) return false;
		}
		return true;
	}
	private void userSort(ArrayList<String> userSort, String answer){
		String[]arrString = answer.split("");
		int[]arr = new int[arrString.length];
		for(int i =0; i<arr.length;i++){
			arr[i]=Integer.parseInt(arrString[i]);
		}
		for(int x:arr){
			userSort.add(wordsToPlay.get(x));
		}
	}
	private void printWords(ArrayList<String> list){
		for(int i=0;i<list.size();i++){
			pp.print(i+" "+list.get(i));
		}
	}
	
	private void printWordsMessed(ArrayList<String> list){
		for(int i=0;i<list.size();i++){
			Random rd = new Random();
			int spaceAmount = rd.nextInt(4);
			String spaces ="";
			for(int j=0;j<=spaceAmount;j++){
				spaces+=" ";
			}
			pp.print(i+" "+spaces+list.get(i));
		}
	}
	private void setUp(){
		File f = new File(fileName);
		this.words=new ArrayList<String>();
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
	private void randomize(ArrayList<String>source,Level level){
		int i = 4;
		Random rd = new Random();
		for(int j = 0;j<i;j++){
			int randomNumber = rd.nextInt(source.size());
			this.wordsToPlay.add(source.get(randomNumber));
			this.words.remove(randomNumber);
		}
	}
	
	public boolean isWon() {
		return isWon;
	}

	public void setWon(boolean isWon) {
		this.isWon = isWon;
	}

	class StringLengthListSort implements Comparator<String>{

	    @Override
	    public int compare(String s1, String s2) {
	    return s1.length() - s2.length();
	    }
	}
	
	public long getTime(){
		return this.time;
	}
}
