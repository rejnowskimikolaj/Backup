package com.sda.animals;

public class Chicken extends AbstractAnimal {
	
	private AnimalType animal = AnimalType.CHICKEN;

	@Override
	public AnimalType getAnimal() {
		return animal;
	};

}
