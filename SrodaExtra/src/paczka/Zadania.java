package paczka;

import org.junit.Test;

public class Zadania {
	// 5. Napisz funkcjê, która zamienia dla zadanego ci¹gu znaków pierwszy znak
	// z ostatnim

	public static String switchLetters(String text) {
		String lastLetter = text.substring(text.length() - 1);
		String firstLetter = text.substring(0, 1);
		text = text.substring(1, text.length() - 1);
		text = lastLetter + text + firstLetter;
		return text;
	}

	@Test
	public void switchLettersTest() {
		System.out.println(switchLetters("Jakis string"));
	}

	// 6. Napisz funkcjê, która dla wczytanego od u¿ytkownika s³owa,
	// wyœwietla jego litery w kolejnoœci odwrotnej.

	public static String[] oppositeString(String text) {
		text = text.replaceAll(" ", "");
		String[] array = text.split("");
		String[] array2 = new String[array.length];
		int arr2LastIndex = array.length - 1;
		for (String x : array) {
			array2[arr2LastIndex] = x.toLowerCase();
			arr2LastIndex--;
		}

		 for(String x:array2) System.out.println(x);
		return array2;
	}

	@Test
	public void testOppositeString() {

		oppositeString("ze spacjami");
	}

	// 7. Napisz funkcjê, która jako argument przyjmuje dodatni¹ liczbê
	// ca³kowit¹ wiêksz¹ od zera.
	// Dla podanego zakresu wydrukuj kolejne wartoœci pomijaj¹c te, które s¹
	// podzielne przez 3 lub przez 4

	public static void printWithout(int number) {

		for (int i = 0; i < number; i++) {
			if (i % 3 != 0 && i % 4 != 0)
				System.out.print(i + ",");
		}
	}

	@Test
	public void testPrintWithout() {
		printWithout(120);
	}

	public static void printAdresses(String street, int lastBlock) {
		if (lastBlock % 2 == 0)
			lastBlock--;
		while (lastBlock >= 1) {
			String[] klatkaArray = { "A", "B", "C" };
			int klatkaDifference = 0;
			for (String x : klatkaArray) {
				for (int floor = 0; floor < 3; floor++) {
					int increase = 0;
					if (floor == 0) {
						increase = 1;
					} else
						increase = floor + 1;
					for (int flat = floor + increase + klatkaDifference; flat < (2 + floor + increase
							+ klatkaDifference); flat++) {
						// System.out.printf("%d %d %d przez %d",
						// street,lastBlock,klatka,flat);
						System.out.print(street + " " + lastBlock + x + "/" + flat + " (" + floor + " floor)");
						System.out.println();
					}
				}
				klatkaDifference = klatkaDifference + 6;
			}
			lastBlock = lastBlock - 2;

		}
	}

	@Test
	public void printAdressesTest() {
		printAdresses("Mazowiecka", 9);
	}

	// 9.Napisz funkcjê, sprawdzaj¹c¹ czy przekazany argument (String) jest
	// palindromem (nale¿y uwzglêdniæ pomijanie spacji).

	public boolean checkIfPalindrom(String text) {
		text = text.toLowerCase();
		String[] oppText = oppositeString(text);
		text = text.replaceAll(" ", "");

		String[] textArr = text.split("");

		// for(String x: oppText) System.out.println(x);
		// System.out.println();
		// for(String x: textArr) System.out.println(x);

		for (int i = 0; i < oppText.length; i++) {
			if (!oppText[i].equals(textArr[i]))
				return false;
		}

		return true;

	}

	@Test
	public void testCheckIfPalidrom() {
		System.out.println(checkIfPalindrom("Jakis text"));
		System.out.println(checkIfPalindrom("kajak"));
		System.out.println(checkIfPalindrom("ka jak"));
		System.out.println(checkIfPalindrom("Madam Im Adam"));

	}

	public String sayHundreds(int number) {
		String result = "";
		if (number % 100 > 0 || number / 100 != 0) {
			switch (number / 100) {
			case 1:
				result = result + "sto";
				break;
			case 2:
				result = result + "dwiescie";
				break;
			case 3:
				result = result + "trzysta";
				break;
			case 4:
				result = result + "czterysta";
				break;
			case 5:
				result = result + "piecset";
				break;
			case 6:
				result = result + "szescset";
				break;
			case 7:
				result = result + "siedemset";
				break;
			case 8:
				result = result + "osiemset";
				break;
			case 9:
				result = result + "dziewiecset";
				break;
			}
			
			
		
		}
		return result;
	}
	
	

	public String sayNumber(int number) {
		String result = "";

		return result;

	}

	@Test
	public void testSayNumber() {

		System.out.println(sayNumber(10000));
	}

}
