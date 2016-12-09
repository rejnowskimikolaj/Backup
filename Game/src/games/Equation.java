package games;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Equation implements Playable{
	
	private ProperPrinter pp;
	private String[]signs = {"+","-"};
	
	public String randomize(int amount,int max){
		String result ="";
		Random rd = new Random();
		result+=""+rd.nextInt(max+1);
		while(amount!=1){
			result+=" "+signs[rd.nextInt(signs.length)]+" "+rd.nextInt(max+1);
			amount--;
		}
		return result;
	}
	
	public double solve(String equation){
		String[]arr = equation.split(" ");
		ArrayList<Double>numbers = new ArrayList<Double>();
		numbers.add(Double.parseDouble(arr[0]));
		for(int i=1;i<arr.length-1;i+=2){
			String number = arr[i]+arr[i+1];
			numbers.add(Double.parseDouble(number));
		}
		return numbers.stream().reduce(0.0, (x,y)->x+y);
	}
	
	public Equation(ProperPrinter pp){
		this.pp=pp;
	}

	@Override
	public void run() {
		game();
	}

	@Override
	public void game() {
		Scanner sc = new Scanner(System.in);
		pp.delim();
		pp.print("EQUATION");
		pp.delim();
		pp.spacer();
		for(int i = 1;i<=5;i++){
			pp.print("Dzia³anie " + i+":");
			String equation = randomize(i+1,3*i);
			pp.print(equation);
			pp.print("Podaj wynik:");
			double userResult=sc.nextDouble();
			if(userResult!=solve(equation)){
				pp.print("Przegra³eœ :(");
				pp.delim();
				pp.print(equation+" = "+solve(equation));
				pp.delim();
				return;
			}
			else {
				pp.print(equation+" = "+solve(equation));
				pp.print("Super!");
				pp.delim();
			}
		}
		pp.spacer();
		pp.print("WYGRA£EŒ!!!");
		pp.delim();
	}

}
