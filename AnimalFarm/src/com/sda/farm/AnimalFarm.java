package com.sda.farm;
import java.util.ArrayList;
import java.util.List;

import com.sda.animals.*;
import com.sda.feed.Feed;
import com.sda.products.Product;
import com.sda.products.ProductStorage;

public class AnimalFarm {

	private int balance;
	private int regularFeedCount;
	private int greatFeedCount;
	private ProductStorage storage;
	
	List <AbstractAnimal> animals;
	
	public void sellProduct(Product product){
		if(storage.getProductCount(product)==0) throw new IllegalStateException("You don't have any of this product");
		else {
			storage.subtractFromStorage(product);
			this.balance=balance+product.getPrice();
		}
	}
	
	private boolean isThereEnoughFeed(Feed feedType){
		if (feedType==Feed.GREAT){
			if (greatFeedCount>0) return true;
			else return false;
		}
		else if(feedType==Feed.REGULAR){
			if (regularFeedCount>0) return true;
			else return false;
			}
		else throw new IllegalArgumentException("Unknown type of feed");
	}
	public void feedAnimal(int i, Feed feedType){
		if(isThereEnoughFeed(feedType)==true){
		int product =animals.get(i).eat(feedType);
		if(product==1){ storage.addToStorage(animals.get(i).getAnimal().getProduct());	
		regularFeedCount--;
		}
		else if (product==2){
			storage.addToStorage(animals.get(i).getAnimal().getProduct());
			storage.addToStorage(animals.get(i).getAnimal().getProduct());
			greatFeedCount--;
		}
		
		else throw new IllegalArgumentException("Unknown feedtype or animal doesn't exist");
		}
		else throw new IllegalStateException("Not enough feed. Try other one");
	}

	public ProductStorage getStorage(){
		return this.storage;
	}
	
	public List<AbstractAnimal> getAnimals(){
		return this.animals;
	}
	
	public void buyAnimal(AnimalType animal){
		if(balance>animal.getPrice()) {
			addAnimal(animal);
			balance=balance-animal.getPrice();
			}
		
		else throw new IllegalStateException("Not enough money!");
	}
	private void addAnimal(AnimalType animal){
		AbstractAnimal anim;
		if (animal == AnimalType.CHICKEN){
			anim = new Chicken();
		}
		
		else if (animal == AnimalType.GOAT){
			 anim = new Goat();
		}
		
		else if (animal == AnimalType.COW){
			 anim = new Cow();
		}
		else  if(animal == AnimalType.DUCK){
			 anim = new Duck();}
		else throw new IllegalArgumentException("Unknown animal");
		
		
		animals.add(anim);
		
	}

	public AnimalFarm(int balance) {
		this.balance = balance;
		regularFeedCount = 0;
		greatFeedCount = 0;
		this.animals=new ArrayList<>();
		this.storage = new ProductStorage();
	}

	public int getFeedCount(Feed feedType) {
		int result = 0;
		if (feedType == Feed.REGULAR)
			result = regularFeedCount;
		else if (feedType == Feed.GREAT)
			result = greatFeedCount;
		else
			throw new IllegalArgumentException("Unknown type of feed");
		return result;
	}

	public void buyFeed(Feed feedType) {
		if (balance < feedType.getPrice())
			throw new IllegalStateException("No moni");
		if (feedType == Feed.GREAT) {

			this.buyGreatFeed();

		}

		else if (feedType == Feed.REGULAR) {
			this.buyRegularFeed();
		}

		else
			throw new IllegalStateException("Unknown type of feed");
	}

	public int getBalance() {
		return balance;
	}

	private void buyRegularFeed() {

		regularFeedCount++;
		balance--;
	}

	private void buyGreatFeed() {

		greatFeedCount++;
		balance = balance - 2;
	}

}
