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
			momAnswer="Wydaje mi si�, �e "+question.getAnswers().get(question.getCorrect());
		}
		else momAnswer="Nie mam poj�cia. Przykro mi dzieciaczku";
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
