package zad13;

import zad11.FileIO;

public class Cypher {
	private FileIO fio;
	private String fileInput;
	private String fileOutput;
	public Cypher(String fileInput, String fileOutput){
		this.fileInput=fileInput;
		this.fileOutput=fileOutput;
		this.fio=new FileIO(fileInput);
	}

	public Cypher(){
		this.fileInput="src\\zad13\\input.txt";
		this.fileOutput="src\\zad13\\output.txt";
		this.fio=new FileIO(fileInput);
	}
	
	public void rot13(){
		String[] arr=fio.readFileAsString().split("");
	
		fio.saveArrAsNewFile(fileOutput, rot13.cypher(arr));
	}
	
	public void deRot13(){
		String[] arr=fio.readFileAsString().split("");
	
		fio.saveArrAsNewFile(fileOutput, rot13.deCypher(arr));
	}
	
}

