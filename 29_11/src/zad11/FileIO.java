package zad11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO {

	private String fileName;

	public FileIO(String fileName) {
		this.fileName = fileName;
	}

	public String[] readFile() {
		File f = new File(fileName);
		String[] arr;
		int counter = 0;
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				sc.nextLine();
				counter++;
			}
			arr = new String[counter];
			counter = 0;

			Scanner sc2 = new Scanner(f);
			while (sc2.hasNextLine()) {
				arr[counter] = sc2.nextLine();
				counter++;
			}
			return arr;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String readFileAsString() {
		String result = "";
		String arr[] = readFile();
		for (String x : arr) {
			result += x + "\n";
		}

		return result;
	}

	public String readLine(int line) {
		File f = new File(fileName);
		String result = "";
		int counter = 1;
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				if (counter == line)
					return result += sc.nextLine();
				sc.nextLine();
				counter++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public String[] readLines(int lineStart, int lineEnd) {
		int size = lineEnd - lineStart + 1;
		String[] arr = new String[size];
		for (int i = lineStart, j = 0; i <= lineEnd; i++, j++) {
			arr[j] = readLine(i);
		}

		return arr;
	}

	public String[] getArrAfterAdd(int line, String content) {
		String[] arr = readFile();
		String[] arr2 = new String[arr.length + 1];
		int i = 0;
		line--;
		for (String x : arr) {
			if (i == line) {
				arr2[i] = content;
				break;
			}
			arr2[i] = arr[i];
			i++;
		}

		for (int j = line; j < arr2.length - 1; j++) {
			arr2[j + 1] = arr[j];
		}

		return arr2;

	}

	public void writeLine(int line, String content) {

		if (line == countLines(fileName)) {
			append(content);
			return;
		}
		String[] arr = readFile();
		String[] arr2 = getArrAfterAdd(line, content);
		overrideFile(arr2);

	}

	public void writeLines(int lineStart, String[] content) {
		int length = content.length;
		int i = 0;
		for (String x : content) {
			if (i == length)
				break;
			writeLine(lineStart + i, x);
			i++;
		}
	}

	public void updateLine(int line, String content) {
		if (line > countLines(fileName))
			throw new IllegalArgumentException("nie ma takiej linii!");
		String[] arr = readFile();
		String[] arr2 = new String[countLines(fileName)];
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = arr[i];
		}

		arr2[line - 1] = content;
		overrideFile(arr2);

	}

	public void updateLines(int lineStart, String[] arr) {
		for (String x : arr) {
			updateLine(lineStart, x);
			lineStart++;
		}
	}

	public void insertBefore(int line, String content) {
		writeLine(line, content);
	}

	public void insertAfter(int line, String content) {
		writeLine(line + 1, content);
	}

	public void append(String content) {
		File f2 = new File(fileName);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f2, true);
			PrintWriter pw = new PrintWriter(fos);

			pw.println(content);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void overrideFile(String[] arr) {
		File f2 = new File(fileName);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f2);
			PrintWriter pw = new PrintWriter(fos);
			for (String x : arr) {
				pw.println(x);
			}

			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private int countLines(String fileName) {
		File f = new File(fileName);
		int counter = 0;

		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				sc.nextLine();
				counter++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return counter;

	}

	public void copyFile(String newFileName) {
		File f2 = new File(newFileName);
		String[] arr = readFile();
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f2, true);
			PrintWriter pw = new PrintWriter(fos);
			for (String x : arr) {
				pw.println(x + "\n");
			}

			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void scrolling() {
		Scanner sc = new Scanner(System.in);
		int firstLine;
		int secondLine;
		int scope;
		System.out.println("pierwsza linia:");
		firstLine = sc.nextInt();
		System.out.println("ostatnia linia:");
		secondLine = sc.nextInt();
		System.out.println("zakres:");
		scope = sc.nextInt();
		String[] arr = readLines(firstLine, firstLine + scope - 1);

		String input = "";
		while (!input.equals("q")) {
			System.out.println("DEBUG: " + input);
			for (String x : arr) {
				System.out.println(x);
			}
			System.out.println("DEBUG: 2");
			input = sc.nextLine();

			switch (input) {
				case ">": {
					firstLine += scope;
					secondLine += scope;
					arr = readLines(firstLine, secondLine);
					break;
				}
					
				case "<": {
					firstLine -= scope;
					secondLine -= scope;
					arr = readLines(firstLine, secondLine);
					break;
				}
			}

		}

	}
}
