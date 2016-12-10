package games;

import java.util.ArrayList;

public class Question {
private String question;
private ArrayList<String> answers;
private int correct;
private int level;
private int worth;

	public Question(String text){
		String[] arr = text.split(";");
		answers = new ArrayList<String>();
		this.question=arr[0];
		for(int i=1;i<=4;i++){
			answers.add(arr[i]);
		}
		this.correct=Integer.parseInt(arr[5]);
		this.level=Integer.parseInt(arr[6]);
		switch(this.level){
		case 1: this.setWorth(1000);
		break;
		case 2: this.setWorth(10000);
		break;
		case 3: this.setWorth(100000);
		break;
		case 4: this.setWorth(1000000);

		}
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}
	
	public String toString(){
		return question+":\n"+answers.get(0)+" " +answers.get(1)+" "+answers.get(2)+" "+answers.get(3);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getWorth() {
		return worth;
	}

	public void setWorth(int worth) {
		this.worth = worth;
	}
	
	
}
