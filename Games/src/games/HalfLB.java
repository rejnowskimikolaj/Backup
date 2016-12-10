package games;

import java.util.ArrayList;

public class HalfLB implements LifeBelt {

	@Override
	public void help(Question question) {
		hashAnswer(question);
	}

	
	private void hashAnswer(Question question){
		ArrayList<String> answers = question.getAnswers();
		int correct = question.getCorrect();
		int left=2;
		for(int i=0;i<answers.size()&&left>0;i++){
			if(i!=correct) {
				answers.set(i,"################");
				left--;
			}
		}
		question.setAnswers(answers);
	}
	
	public String toString(){
		return "Pó³ na pó³";
	}
}
