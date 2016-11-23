package com.sda.animals;

public class Cow extends AbstractAnimal{
private AnimalType animal = AnimalType.COW;
	
	@Override 
	public AnimalType getAnimal() {
		return animal;
	};

}
