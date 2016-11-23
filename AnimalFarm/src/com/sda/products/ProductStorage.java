package com.sda.products;

public class ProductStorage {

	private int goatMilkCount;
	private int cowMilkCount;
	private int duckEggCount;
	private int chickenEggCount;
	
	public int getGoatMilkCount() {
		return goatMilkCount;
	}

	public int getCowMilkCount() {
		return cowMilkCount;
	}

	public int getDuckEggCount() {
		return duckEggCount;
	}

	public int getChickenEggCount() {
		return chickenEggCount;
	}

	public ProductStorage(){
		this.goatMilkCount=0;
		this.cowMilkCount=0;
		this.duckEggCount=0;
		this.chickenEggCount=0;
	}
	
	public int getProductCount(Product product){
		if (product==Product.CHICKENEGG) return chickenEggCount;
		else if (product==Product.DUCKEGG) return duckEggCount;
		else if (product==Product.COWMILK) return cowMilkCount;
		else if (product==Product.GOATMILK) return goatMilkCount;
		else throw new IllegalArgumentException("Unknown product");



	}
	public void addToStorage(Product productType){
		if (productType==Product.CHICKENEGG) chickenEggCount++;
		else if (productType==Product.COWMILK) cowMilkCount++;
		else if (productType==Product.DUCKEGG) duckEggCount++;
		else if (productType==Product.GOATMILK) goatMilkCount++;
	}
	
	public void subtractFromStorage(Product productType){
		if (productType==Product.CHICKENEGG) chickenEggCount--;
		else if (productType==Product.COWMILK) cowMilkCount--;
		else if (productType==Product.DUCKEGG) duckEggCount--;
		else if (productType==Product.GOATMILK) goatMilkCount--;
	}
}
