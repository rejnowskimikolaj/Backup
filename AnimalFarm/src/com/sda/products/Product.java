package com.sda.products;

public enum Product {

	GOATMILK(5),
	COWMILK(4),
	DUCKEGG(3),
	CHICKENEGG(2);
	
	private final int price;
	private Product(int price){
		this.price=price;
	}
	
	public int getPrice() {
		return price;
	}

}
