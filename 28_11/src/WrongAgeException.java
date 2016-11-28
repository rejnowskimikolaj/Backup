
public class WrongAgeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongAgeException(String message){
		super(message);
	}
	
	public WrongAgeException(){
		super("Wrong age exception");
	}

}
