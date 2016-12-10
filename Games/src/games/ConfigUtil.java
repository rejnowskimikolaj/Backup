package games;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ConfigUtil {


	public static void printConfig(ProperPrinter pp, Configurator configurator){
		
		Iterator it = configurator.getConfig().entrySet().iterator();
		int i=1;
		 while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        pp.delim();
		        pp.print(i+". "+pair.getKey()+" = " + pair.getValue());
		        i++;
		        pp.delim();
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		
	}
	
	public static void configMenu(ProperPrinter pp, Configurator configurator){
		printConfig(pp,configurator);
		configurator.readFile();
		pp.delim();
		pp.print("1. Options");
		pp.print("0. Return");
		Scanner sc = new Scanner(System.in);
		String answer = "";
		while(!answer.equals("0")){
			answer=sc.nextLine();
		if(answer.equals("1")){
			pp.print("Podaj klucz: ");
			//configurator.readFile();
			String key = sc.nextLine();
			if(!configurator.getConfig().containsKey(key)){
				pp.print("Nie ma takiego klucza");
				return;
			}
			pp.print("Podaj wartoœæ");
			answer = sc.nextLine();
			configurator.getConfig().put(key, answer);
			printConfig(pp,configurator);
			configurator.saveFile();
			
			}
		}
		
	}	
	
	
}
