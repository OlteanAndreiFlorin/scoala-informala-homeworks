package shapes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class ShapeTest {
	public Shape r;
	
	@After
	public void cleanUp(){
		r=null;
	}
	
	@Test
	public void testCalculateSurface_rectangle(){
		r = new Rectangle(10, 20);
		float expected = 200;
		float actual = r.calculateSurface();
		Assert.assertEquals(expected, actual ,0);
	}
	@Test
	public void testCalculateSurface_square(){
		r = new Square(10);
		float expected = 100;
		float actual = r.calculateSurface();
		Assert.assertEquals(expected, actual ,0);
	}
	@Test
	public void testCalculatePErimetre_rectangle(){
		r = new Rectangle(10, 20);
		float expected=60;
		float actual=r.calculatePerimetre();
		Assert.assertEquals(expected, actual ,0);
	}
	@Test
	public void testCalculatePErimetre_square(){
		r = new Square(10);
		float expected=40;
		float actual=r.calculatePerimetre();
		Assert.assertEquals(expected, actual ,0);
	}
}
