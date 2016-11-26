package main;

public class Cat implements Animal, Soundable {

	@Override
	public void makeSound() {
		System.out.println("Meow");
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
