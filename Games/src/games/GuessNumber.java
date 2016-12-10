package games;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber implements Playable {

	
	private int number;
	private String name="GuessNumber";
	private ProperPrinter pp;
	private Configurator configurator;
	boolean hints;
	
	
	public GuessNumber(ProperPrinter pp) {
		Random rd = new Random();
		this.pp=pp;
		
		this.configurator=new Configurator("src\\games\\"+name+".ini");
		setConfig(this.configurator);
		Integer maxNumber = Integer.parseInt(configurator.getConfig().get("maxNumber"));
		String hintsConf = configurator.getConfig().get("hints");
		if(hintsConf.equals("0")) hints = false;
		else hints=true;
		this.number=rd.nextInt(maxNumber+1);
	}
	
	@Override
	public void run() {
		configurator.configMenu(pp);
		game();
		
		saveGame();
		
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
		if(this.hints==true){
		if(number>this.number) pp.print("Za du¿a");
		else if (number<this.number) pp.print("Za ma³a");
		}
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

	@Override
	public void setConfig(Configurator configurator) {
		this.configurator = configurator;
		configurator.readFile();
		
	}


	private void saveGame(){
		Integer amountOfGames = Integer.parseInt(configurator.getConfig().get("amountOfGames"));
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String currentTime = dateFormat.format(date);
		amountOfGames++;
		this.configurator.getConfig().put("amountOfGames", amountOfGames.toString());
		this.configurator.getConfig().put("lastTime", currentTime);
		this.configurator.saveFile(this.configurator.getConfig());
	}
	
	public Configurator getConfigurator(){
		return this.configurator;
	}
	
	
	
}
