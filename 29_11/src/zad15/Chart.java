package zad15;

import zad11.FileIO;

public class Chart {

	private String fileName;
	private FileIO fio;

	public Chart(String fileName) {
		this.fileName = fileName;
		this.fio = new FileIO(fileName);
	}

	public Chart() {
		this.fileName = "src\\zad15\\input.txt";
		this.fio = new FileIO(fileName);

	}

	private double countSum(String[] lineChar) {
		double sum = 0;
		for (String x : lineChar) {
			String[] arr = x.split("\\s");
			int number = Integer.parseInt(arr[1]);
			sum += number;
		}

		return sum;
	}

	private void printLine(int lineCount, int number, double sum) {

		System.out.print(lineCount + " | ");
		double hashes = (number / sum) * 100;
		for (int i = 1; i <= hashes; i++) {
			System.out.print("#");
		}
		System.out.println("  " + hashes + "%");
	}

	private void printLegend(String[] lineChar) {
		System.out.println("Legenda:");
		int line = 1;
		for (String x : lineChar) {
			String[] arr = x.split("\\s");
			System.out.println(line + " - " + arr[0] + " (" + arr[1] + ")");
			line++;
		}
	}

	public void printChart() {
		String[] lineChar = fio.readFile();
		int lineCount = 1;
		double sum = countSum(lineChar);
		System.out.println("-----------Microsoft Excel 1945-----------");
		System.out.println();
		for (String x : lineChar) {
			String[] arr = x.split("\\s");
			int number = Integer.parseInt(arr[1]);
			printLine(lineCount, number, sum);
			System.out.println();
			lineCount++;
		}

		System.out.println("suma: " + sum);
		System.out.println();
		printLegend(lineChar);
	}

	private void addLineToArr(int number, double sum, String[][] arr, int index) {
		double hashes = (number / sum) * 100;
		int line = 0;
		for (int i = 1; i <= hashes; i++) {
			arr[index][line] = "#";
			line++;
		}
		for (int i = line; i < arr[0].length; i++) {
			arr[index][line] = " ";
			line++;
		}
	}

	private int giveLongestHash(String[][] arr) {
		int result = 0;
		int hashCounter = 0;
		for (int i = 0; i < arr.length; i++) {
			hashCounter = 0;
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j].equals("#")) {
					hashCounter++;
				}
			}
			if (hashCounter > result)
				result = hashCounter;
		}
		return result;
	}

	public void printVerticalChart() {
		String[] lineChar = fio.readFile();
		int longest = 0;
		double sum = countSum(lineChar);
		String[][] vertChart = new String[lineChar.length][100];
		int index = 0;
		for (String x : lineChar) {
			String[] arr = x.split("\\s");
			int number = Integer.parseInt(arr[1]);
			addLineToArr(number, sum, vertChart, index);
			index++;
		}
		int hashLength = giveLongestHash(vertChart);
		// vertChart[0].length-1
		for (int j = hashLength; j >= 0; j--) {
			for (int i = 0; i < vertChart.length; i++) {
				System.out.print(vertChart[i][j] + " ");
			}
			System.out.println();
		}

	}

}
