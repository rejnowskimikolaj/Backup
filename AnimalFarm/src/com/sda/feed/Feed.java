package com.sda.feed;

public enum Feed {

	REGULAR(1,1),
	GREAT(2,2);
	
	public int getMultiplier() {
		return multiplier;
	}

	public int getPrice() {
		return price;
	}

	private final int multiplier;
	private final int price;
	
	private Feed(int multiplier, int price){
		this.multiplier=multiplier;
		this.price=price;
	}
	
}
