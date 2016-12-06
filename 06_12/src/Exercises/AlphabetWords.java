package Exercises;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AlphabetWords {

	public List<String> lista;
	
	public AlphabetWords(){
		this.lista=new LinkedList<>();
	}
	
//	public int compare(String word1,String word2) {
//	       
//
//	       if (word1.charAt(0) > word2.charAt(0)) {
//	           return 1;
//	       } else if (word1.charAt(0) < word2.charAt(0)){
//	           return -1;
//	       } else {
//	           return 0;
//	       }
//	    }
	public void addWord(String word){
		lista.add(word);
		//lista.stream().sorted(Collections.reverseOrder()).
	}
	
	
	

	public static void main(String[] args) throws FileNotFoundException {
		AlphabetWords al=new AlphabetWords();
		al.addWord("aa");
		al.addWord("kot");
		al.addWord("pies");
		al.addWord("baba");
		al.lista.stream().sorted().forEach(s->System.out.println(s));//.collect(Collectors.toList());
//		for(String x:al.lista){
//			System.out.println(x);
//		}
	}
}
