package games;

import java.util.ArrayList;

public class CrowdLB implements LifeBelt {

	private ProperPrinter pp;
	public CrowdLB(ProperPrinter pp){
		this.pp=pp;
	}
	@Override
	public void help(Question question) {
		ArrayList<String> answers = question.getAnswers();
		for(int i=0;i<answers.size();i++){
			if(i==question.getCorrect()){
				answers.set(i, answers.get(i)+" 40%");
			}
			else answers.set(i, answers.get(i)+" 20%");
		}
		
		pp.print("Odpowiedzi publicznoœci:");
		pp.delim();
	}
	
	public String toString(){
		return "Pytanie do publicznoœci";
	}
	
	

}
