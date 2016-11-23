package com.sda.animals;

import com.sda.feed.Feed;
import com.sda.products.Product;

public abstract class AbstractAnimal {
	protected AnimalType animal;
	private Product product;
	private int livesLeft;
	private static int COUNT =0;
	private final int uid = COUNT++;
	

	public long getUid(){
		return this.uid;
	}
	public int getLivesLeft() {
		return livesLeft;
	}

	public abstract AnimalType getAnimal();

	public AbstractAnimal() {
		livesLeft = 10;	
//		product = animal.getProduct(); 
	}

	public int eat(Feed feedType) {
		if (feedType == Feed.REGULAR || feedType==Feed.GREAT) {
			this.livesLeft--;
			return feedType.getMultiplier();}
		else throw new IllegalArgumentException("Unknown type of feed");
		
		
	}

}
