package shapes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class ShapeTest {
	public Shape r;

	@After
	public void cleanUp() {
		r = null;
	}

	@Test
	public void testCalculateSurface_rectangle() {
		r = new Rectangle(10, 20);
		float expected = 200;
		float actual = r.calculateSurface();
		Assert.assertEquals(expected, actual, 0);
	}

	@Test
	public void testCalculateSurface_circle() {
		r = new Circle(10);
		float PI = 3.14f;
		float expected = PI * 100;
		float actual = r.calculateSurface();
		Assert.assertEquals(expected, actual, 0);
	}

	@Test
	public void testCalculateSurface_triangle() {
		r = new Triangle(10);
		float SQRT3 = 1.732f;// SQRT - square root;
		float expected = SQRT3 * 100;// formula is A=side^2*Sqrt(3)/4
		expected /= 4;
		float actual = r.calculateSurface();
		Assert.assertEquals(expected, actual, 0);
	}

	@Test
	public void testCalculateSurface_square() {
		r = new Square(10);
		float expected = 100;
		float actual = r.calculateSurface();
		Assert.assertEquals(expected, actual, 0);
	}

	@Test
	public void testCalculatePErimetre_rectangle() {
		r = new Rectangle(10, 20);
		float expected = 60;
		float actual = r.calculatePerimetre();
		Assert.assertEquals(expected, actual, 0);
	}

	@Test
	public void testCalculatePErimetre_square() {
		r = new Square(10);
		float expected = 40;
		float actual = r.calculatePerimetre();
		Assert.assertEquals(expected, actual, 0);
	}

	@Test
	public void testCalculatePErimetre_circle() {
		r = new Circle(10);
		float PI = 3.14f;
		float expected = 2 * PI * 10;
		float actual = r.calculatePerimetre();
		Assert.assertEquals(expected, actual, 0);
	}

	@Test
	public void testCalculatePErimetre_triangle() {
		r = new Triangle(10);
		float expected = 30;// Equilateral triangle 3 equal sides
		float actual = r.calculatePerimetre();
		Assert.assertEquals(expected, actual, 0);
	}
}
