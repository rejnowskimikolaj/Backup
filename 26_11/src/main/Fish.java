package main;

public class Fish implements Animal {

	@Override
	public int getNumOfLegs() {
		return 0;
	}

	@Override
	public String getEnv() {
		return "Water";
	}

}
