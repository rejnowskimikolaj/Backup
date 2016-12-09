package games;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WhoWantsToBeMillionaire implements Playable {

	private ArrayList<Question> questions;
	private String fileName;
	private ProperPrinter pp;
	private int money;
	private SortingGame sg;

	public WhoWantsToBeMillionaire(ProperPrinter pp) {
		this.fileName="src\\games\\questions.txt";
		this.pp=pp;
		this.money=0;
		this.questions=new ArrayList<Question>();
		this.sg=new SortingGame(this.pp);
		setUp();
	}
	
	@Override
	public void run() {
		pp.print("Najpierw musisz siê zakwalifikowaæ");
		pp.delim();
		pp.print("Twój czas musi byæ lepszy ni¿ 11 sekund");
		pp.delim();
		this.sg.run();
		if((sg.isWon()==true)&&(sg.getTime()<11000)){
			pp.print("Gratulacje!");
			pp.print("Zakwalifikowa³eœ siê");
			pp.print("Zaczynamy!");
					
			game();
		}
		
		else{
			pp.print("Nie zakwalifikowa³eœ siê");
			pp.delim();
		}
	
	}

	@Override
	public void game() {
		int level=1;
		Scanner sc = new Scanner(System.in);
		boolean done = false;
		while(!done){
			Question q=giveRandomQuestion(level);
			level++;
			pp.delim();
			printQuestion(q);
			pp.delim();
			pp.print("Podaj odpowiedŸ:");
			int answer = sc.nextInt();
			if(answer==q.getCorrect()+1){
				pp.print("Poprawna odpowiedŸ!!");
				printQuestionWithAnswer(q);
				money=q.getWorth();
				pp.print("Masz "+money+" z³");
			}
			else{
				
				pp.print("Niepoprawna odpowiedŸ.");
				printQuestionWithAnswer(q);
				pp.print("Przegra³eœ");
				return;
			}
			if (money==1000000) {
				done=true;
				
			}
			
		}
		
		pp.print("Jesteœ milionerem!!");
	}
	
	private void printQuestionWithAnswer(Question q){
		pp.print(q.getQuestion()+" "+q.getAnswers().get(q.getCorrect()));
	}
	private Question giveRandomQuestion(int level){
		ArrayList<Question> levelQuestions = new ArrayList<>();
		for(Question q:questions){
			if (q.getLevel()==level){
				levelQuestions.add(q);
			}
		}
		
		Random rd = new Random();
		return levelQuestions.get(rd.nextInt(levelQuestions.size()));
		
	}
	
	private void printQuestion(Question q){
		String subq1;
		String subq2;
//		if(q.getQuestion().length()>25){
//			subq2=q.getQuestion().substring(15);
//			subq1=q.getQuestion().substring(0,15);
//			pp.print(subq1+"-");
//			pp.print(subq2);
//		}
//			
//		else {
			pp.print(q.getQuestion());
//		}
		
		for(int i=0;i<q.getAnswers().size();i++){
			pp.print(i+1+". "+q.getAnswers().get(i));
		}
	}
	
	private void setUp(){
		File f = new File(fileName);
		ArrayList<String> textQuestions=new ArrayList<String>();
		Scanner sc;
		try {
			sc = new Scanner(f);
			while(sc.hasNextLine()){
				textQuestions.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		convertQuestions(textQuestions);
	}
	
	
	
	private void convertQuestions(ArrayList<String> textQuestions){
		for(String x:textQuestions){
			this.questions.add(new Question(x));
		}
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ProperPrinter getPp() {
		return pp;
	}

	public void setPp(ProperPrinter pp) {
		this.pp = pp;
	}


	
	
}
