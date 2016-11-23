package AnimalFarmTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sda.animals.AnimalType;
import com.sda.animals.Chicken;

import com.sda.farm.AnimalFarm;
import com.sda.feed.Feed;
import com.sda.products.Product;

public class AnimalFarmTest {

	private AnimalFarm farm;

	@Before
	public void setUp() {
		farm = new AnimalFarm(1000);
	}

	@Test
	public void shouldReturnOne() {
		Chicken chick = new Chicken();
		Assert.assertEquals(1, chick.eat(Feed.REGULAR));
	}

	@Test
	public void ShouldReturnTwo() {
		Chicken chick = new Chicken();
		Assert.assertEquals(2, chick.eat(Feed.GREAT));
	}

	@Test
	public void ShouldAddChickenToTheList() {
		farm.buyAnimal(AnimalType.CHICKEN);
		Assert.assertEquals(1, farm.getAnimals().size());
		Assert.assertEquals(farm.getAnimals().get(0).getAnimal(), AnimalType.CHICKEN);
	}

	@Test
	public void ShouldAddCowToTheList() {
		farm.buyAnimal(AnimalType.COW);
		Assert.assertEquals(1, farm.getAnimals().size());
		Assert.assertEquals(farm.getAnimals().get(0).getAnimal(), AnimalType.COW);
	}

	@Test(expected = IllegalStateException.class)
	public void ShouldThrowExceptionToLittleMoney() {
		farm = new AnimalFarm(10);
		farm.buyAnimal(AnimalType.GOAT);
	}

	@Test(expected = IllegalStateException.class)
	public void ShouldThrowExceptionToLittleMoneyAfterBuyinTwoChickens() {
		farm = new AnimalFarm(10);
		farm.buyAnimal(AnimalType.CHICKEN);
		farm.buyAnimal(AnimalType.CHICKEN);
		Assert.assertEquals(1, farm.getAnimals().size());
	}

	@Test
	public void ChickenShouldEatFeedAndProduceEgg() {
		farm.buyAnimal(AnimalType.CHICKEN);
		farm.buyFeed(Feed.REGULAR);
		farm.feedAnimal(0, Feed.REGULAR);
		Assert.assertEquals(1, farm.getAnimals().size());
		Assert.assertEquals(1, farm.getStorage().getChickenEggCount());
		farm.buyFeed(Feed.GREAT);
		farm.feedAnimal(0, Feed.GREAT);
		Assert.assertEquals(3, farm.getStorage().getChickenEggCount());
	}

	@Test
	public void TestBuyingMultipleAnimals() {
		buyAnimalsParametrized(1, 1, 1, 1, farm);
		Assert.assertEquals(4, farm.getAnimals().size());

	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionNotEnoughFeed(){
		buyAnimalsParametrized(1, 1, 1, 1, farm);
		farm.feedAnimal(0, Feed.GREAT);
		
	}
	
	@Test
	public void shouldSellGoatMilk(){
		buyAnimalsParametrized(0,0,1,0,farm);
		farm.buyFeed(Feed.REGULAR);
		farm.feedAnimal(0, Feed.REGULAR);
		Assert.assertEquals(farm.getStorage().getGoatMilkCount(), 1);
		farm.sellProduct(Product.GOATMILK);
		Assert.assertEquals(farm.getBalance(), (1000-20-1+5));
		Assert.assertEquals(farm.getStorage().getGoatMilkCount(), 0);
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldThrowIllegalStateExceptionNoProduct(){
		buyAnimalsParametrized(0,0,1,0,farm);
		farm.sellProduct(Product.GOATMILK);
	}
	
	@Test
	public void shouldSubtractLivesWhenEats(){
		buyAnimalsParametrized(1,0,0,0,farm);
		farm.buyFeed(Feed.REGULAR);
		farm.buyFeed(Feed.REGULAR);
		farm.feedAnimal(0, Feed.REGULAR);
		farm.feedAnimal(0, Feed.REGULAR);
		int lives =farm.getAnimals().get(0).getLivesLeft();
		Assert.assertEquals(lives, 8);
		farm.buyFeed(Feed.GREAT);
		farm.feedAnimal(0, Feed.GREAT);
		lives =farm.getAnimals().get(0).getLivesLeft();
		Assert.assertEquals(lives, 7);

	}

	private static void buyAnimalsParametrized(int chickens, int cows, int goats, int ducks,AnimalFarm farm){
		for(int i=chickens;i>=1;i--){
			farm.buyAnimal(AnimalType.CHICKEN);
		}
		
		for(int i=cows;i>=1;i--){
			farm.buyAnimal(AnimalType.COW);
		}
		
		for(int i=goats;i>=1;i--){
			farm.buyAnimal(AnimalType.GOAT);
		}
		
		for(int i=ducks;i>=1;i--){
			farm.buyAnimal(AnimalType.DUCK);
		}
		
	}

}
