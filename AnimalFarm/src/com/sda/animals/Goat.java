package com.sda.animals;

public class Goat extends AbstractAnimal {

	private AnimalType animal = AnimalType.GOAT;

	@Override
	public AnimalType getAnimal() {
		return animal;
	};
}
