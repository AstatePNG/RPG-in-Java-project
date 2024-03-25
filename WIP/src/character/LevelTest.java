package character;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LevelTest {

	@Test
	void testConstructorWithoutParam() {
		Level test = new Level();
		assertEquals(1,test.getCurrentLevel());
	}
	
	@Test
	void testConstructorLevelWithLevelParam() {
		Level test = new Level(5);
		assertEquals(5,test.getCurrentLevel());
	}
	
	@Test
	void testConstructorTotalXpWithLevelParam() {
		Level test = new Level(5);
		assertEquals(700,test.getTotalXp());
	}

	@Test
	void testConstructorXpToNextLevelWithLevelParam() {
		Level test = new Level(5);
		assertEquals(300,test.getXpToNextLevel());
	}

	@Test
	void testConstructorLevelWithLevelAndXpParam() {
		Level test = new Level(5,50);
		assertEquals(5,test.getCurrentLevel());
	}

	@Test
	void testConstructorTotalXpWithLevelAndXpParam() {
		Level test = new Level(5,50);
		assertEquals(750,test.getTotalXp());
	}
	
	@Test
	void testConstructorLevelOverMaxLevelRaiseException() {
		assertThrows(IllegalArgumentException.class, 
				() ->{
					new Level(256);
				});
	}
	
	@Test
	void testConstructorLevelUnderMinLevelRaiseException() {
		assertThrows(IllegalArgumentException.class, 
				() ->{
					new Level(0);
				});
	}
	
	@Test
	void testConstructorXpNegativeRaiseException() {
		assertThrows(IllegalArgumentException.class, 
				() ->{
					new Level(1,-1);
				});
	}
	
	@Test
	void testLevelAfterAddXp() {
		Level test = new Level();
		test.addXp(100);
		assertEquals(2,test.getCurrentLevel());
	}
	
	@Test
	void testXpAfterAddXpLevelUp() {
		Level test = new Level();
		test.addXp(100);
		assertEquals(0,test.getXp());
	}
	
	@Test
	void testXpAfterAddXp() {
		Level test = new Level(1,15);
		test.addXp(10);
		assertEquals(25,test.getXp());
	}
	
	@Test
	void testLevelMaxStaticAfterAddXp(){
		Level test = new Level(255);
		test.addXp(12800);
		assertEquals(255,test.getCurrentLevel());
	}

	@Test
	void valueXpOfMaxLevel() {
		Level test = new Level(255);
		System.out.println(test.getTotalXp() + " " + test.getXpToNextLevel());
	}

}
