package com.sda.animals;

import com.sda.products.Product;

public enum AnimalType {
	
	GOAT(20,Product.GOATMILK),
	COW(18,Product.DUCKEGG),
	DUCK(12,Product.DUCKEGG),
	CHICKEN(6,Product.CHICKENEGG);
	
	private final int price;
	public int getPrice() {
		return price;
	}

	public Product getProduct() {
		return product;
	}

	private final Product product;

	private AnimalType(int price, Product product){
		this.price=price;
		this.product = product;
	}
}
