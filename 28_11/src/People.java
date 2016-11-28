import java.util.ArrayList;

public class People {
	
	private ArrayList<Person> pplList;
	private int size;
	
	public People(int size){
		pplList = new ArrayList<>();
		this.size=size;
	}
	
	private final String[] allowedEyes = { "green", "brown", "blue", "black" };
	private final String[] allowedHair = { "blond", "brown", "black", "red" };
	
	public void addPerson(Person person) throws FullListException{
		if(pplList.size()==size) throw new FullListException();
		
		pplList.add(person);
		
	}
	public void addPerson(String name, String secondName, int age, String hair, String eyes, double shoe) throws WrongAgeException, BadEyesException, BadHairException, BadShoeException, FullListException{
		if(pplList.size()==size) throw new FullListException();

		boolean correctHair=false;
		boolean correctEyes=false;
		
		for(String x:allowedEyes){
			if (x.equals(eyes)) correctEyes=true;
		}
		if (correctEyes==false) throw new BadEyesException();
		for(String x:allowedHair){
			if (x.equals(hair)) correctHair=true;
		}
		if (correctHair==false) throw new BadHairException();

		if(isSizeCorrect(shoe)==false) throw new BadShoeException();
		
		pplList.add(new Person(name, secondName, age, hair, eyes, shoe));
	}
	
	public boolean isSizeCorrect(double shoe){
		int shoeInt =(int) shoe;
		shoe=shoe-shoeInt;
		if(shoe!=0&&shoe!=0.50) return false;
		return true;
	}

}

class FullListException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FullListException(String message){
		super(message);
	}
	
	public FullListException(){
		super("Full List Exception");
	}
}

class BadHairException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadHairException(String message){
		super(message);
	}
	
	public BadHairException(){
		super("Bad Hair Exception");
	}
}
class BadEyesException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadEyesException(String message){
		super(message);
	}
	
	public BadEyesException(){
		super("Bad Eyes Exception");
	}
}

class BadShoeException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadShoeException(String message){
		super(message);
	}
	
	public BadShoeException(){
		super("Bad shoe exception");
	}
}
