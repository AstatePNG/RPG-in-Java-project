package movement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Point2DTest {

	@Test
	void testConstructorWithoutParameters() {
		Point2D test = new Point2D();
		assertEquals(0,test.getX());
	}
	
	@Test
	void testConstructorWithParameters() {
		Point2D test = new Point2D(2,5);
		assertEquals(2,test.getX());
	}
	
	@Test
	void testMoveSelf() {
		Point2D test = new Point2D();
		test.moveSelf(2,5);
		assertEquals(5,test.getY());
	}
	
	@Test
	void testEquals() {
		Point2D test = new Point2D(1,1);
		Point2D testage = new Point2D(1,1);
		assertEquals(test,testage);
	}

}
