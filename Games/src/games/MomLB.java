package games;

import java.util.Random;

public class MomLB implements LifeBelt{

	private ProperPrinter pp;
	private String momAnswer="";
	
	public MomLB(ProperPrinter pp){
		this.pp=pp;
	}
	@Override
	public void help(Question question) {
		Random rd = new Random();
		int answer=rd.nextInt(4);
		if(answer>1){
			momAnswer="Wydaje mi siê, ¿e "+question.getAnswers().get(question.getCorrect());
		}
		else momAnswer="Nie mam pojêcia. Przykro mi dzieciaczku";
		pp.print("hm....");
		pp.delim();
		pp.print(this.momAnswer);
		pp.delim();
	}
	public String toString(){
		return "Telefon do mamusi (50%)";
	}
	public String getMomAnswer() {
		return momAnswer;
	}
	public void setMomAnswer(String momAnswer) {
		this.momAnswer = momAnswer;
	}
	 
}
