package com.sda.animals;

public class Duck extends AbstractAnimal {
	
	private AnimalType animal = AnimalType.DUCK;

	@Override
	public AnimalType getAnimal() {
		return animal;
	};
}
