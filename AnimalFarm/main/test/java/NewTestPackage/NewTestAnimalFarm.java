package NewTestPackage;

import org.junit.Assert;
import org.junit.Test;

import com.sda.animals.Chicken;
import com.sda.feed.Feed;

public class NewTestAnimalFarm {
	
	@Test
	public void testTest(){
		
	}
	@Test
	public void shouldReturnOne(){
		Chicken chick = new Chicken();
		Assert.assertEquals(1, chick.eat(Feed.REGULAR));
	}

}
