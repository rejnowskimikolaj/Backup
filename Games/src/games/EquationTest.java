package games;

import java.util.HashMap;

public class EquationTest {

	public static void main(String[] args) {
//
		ProperPrinter pp = new ProperPrinter(60);
//		WhoWantsToBeMillionaire ww=new WhoWantsToBeMillionaire(pp);
//		ww.game();
		
		GuessNumber gn = new GuessNumber(pp);
	//	gn.run();
		
//		HashMap<String, String> mapa = gn.getConfigurator().getConfig();
//		System.out.println(mapa.get("hints"));
//		gn.getConfigurator().printConfig(pp);
		gn.getConfigurator().configMenu(pp);
		gn.run();
		
	}

}
