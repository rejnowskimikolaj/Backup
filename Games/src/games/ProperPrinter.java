package games;

public class ProperPrinter {

	
	private int number;
	
	public ProperPrinter(int number){
		this.number=number;
	}
	
	public void delim(){
		System.out.print("+");
		for(int i=0;i<number;i++){
			System.out.print("-");
		}
		System.out.print("+");
		System.out.println();

	}
	
	public void spacer(){
		System.out.print("|");
		for(int i=0;i<number;i++){
			System.out.print(" ");
		}
		System.out.print("|");
		System.out.println();

	}
	
	public void print(String text){
		int half1;
		int half2;
		if(text.length()>this.number-4){
				String subq2=text.substring(15);
				String subq1=text.substring(0,15);
				print(subq1);
				print(subq2);
				return;
			
		}
		if((this.number-text.length())%2==0){
		half1 = (this.number-text.length())/2;
		half2=half1;
		}
		else{
			half1=(this.number-text.length())/2;
			half2=half1+1;
		}
		System.out.print("|");
		for(int i=0;i<half1;i++){
			System.out.print(" ");
		}
		System.out.print(text);
		for(int i=0;i<half2;i++){
			System.out.print(" ");
		}
		
		System.out.print("|");
		System.out.println();


	}
	
	
}