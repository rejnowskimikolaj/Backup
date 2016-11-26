package main;

public class Dog implements Animal,Soundable{

	@Override
	public void makeSound() {
		System.out.println("Woof woof!");
		
	}

	@Override
	public int getNumOfLegs() {
		return 4;
	}

	@Override
	public String getEnv() {
		return "House";
	}

}
