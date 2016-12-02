package zad16;

import zad11.FileIO;

public class VerticalChart {

	private String fileName;
	private FileIO fio;
	
	public VerticalChart(String fileName) {
		this.fileName = fileName;
		this.fio = new FileIO(fileName);
	}
	
	public VerticalChart(){
		this.fileName="src\\zad15\\input.txt";
		this.fio = new FileIO(fileName);

	}
	
	
	
}
