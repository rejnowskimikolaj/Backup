package AnimalFarmTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sda.animals.AnimalType;
import com.sda.animals.Chicken;
import com.sda.farm.AnimalFarm;
import com.sda.feed.Feed;

public class AnimalTest {

	private AnimalFarm farm;
	@Before
	public void setUp(){
		 farm = new AnimalFarm(1000);
	}
	@Test
	public void shouldReturnOne(){
		Chicken chick = new Chicken();
		Assert.assertEquals(1, chick.eat(Feed.REGULAR));
	}
	
	@Test
	public void ShouldReturnTwo(){
		Chicken chick = new Chicken();
		Assert.assertEquals(2, chick.eat(Feed.GREAT));
	}
	
	@Test
	public void ShouldAddChickenToTheList(){
		farm.buyAnimal(AnimalType.CHICKEN);
		Assert.assertEquals(1, farm.getAnimals().size());
		Assert.assertEquals(farm.getAnimals().get(0).getAnimal(), AnimalType.CHICKEN);
	}
	
	@Test
	public void ShouldAddCowToTheList(){
		farm.buyAnimal(AnimalType.COW);
		Assert.assertEquals(1, farm.getAnimals().size());
		Assert.assertEquals(farm.getAnimals().get(0).getAnimal(), AnimalType.COW);
	}
	
	@Test(expected=IllegalStateException.class)
	public void ShouldThrowExceptionToLittleMoney(){
		farm = new AnimalFarm(10);
		farm.buyAnimal(AnimalType.GOAT);
	}
	
	@Test(expected=IllegalStateException.class)
	public void ShouldThrowExceptionToLittleMoneyAfterBuyinTwoChickens(){
		farm = new AnimalFarm(10);
		farm.buyAnimal(AnimalType.CHICKEN);
		farm.buyAnimal(AnimalType.CHICKEN);
		Assert.assertEquals(1, farm.getAnimals().size());
	}
	
	
	
}
