package zad10;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dict d = new Dict();
		Word[] dict = d.getDict();
		for(Word x: dict){
			System.out.println(x.getEnglishWord());
			System.out.println(x.getPolishWord());
		}
		
		d.addWord("kot", "cat");
		 dict = d.getDict();
		for(Word x: dict){
			System.out.println(x.getEnglishWord());
			System.out.println(x.getPolishWord());
		}
		System.out.println(d.checkIfExists("dupa"));
	}

}
