package drawingTools;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;
import shapes.Triangle;

public class DrawingToolTest {

	DrawingTool d;
	Shape c = new Circle(10);
	Shape r = new Rectangle(10, 20);
	Shape s = new Square(10);
	Shape t = new Triangle(10);
	
	class MokShape implements Shape{

		@Override
		public float calculateSurface() {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		public float calculatePerimetre() {
			// TODO Auto-generated method stub
			return 1;
		}
		
	}
	
	@Before
	public void setUp(){
		d=new DrawingTool();
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddShape_similar_shape(){
		d.addShape(c);
		Shape c1 = new Circle(10);
		d.addShape(c1);
	}
	@Test
	public void testAddShape_different_shape(){
		d.addShape(c);
		d.addShape(r);
		d.addShape(s);
		d.addShape(t);
		Assert.assertEquals(d.getShapeList().size(), 4);
	}
	@Test(expected = NullPointerException.class)
	public void testCalculateTotalSurface_list_empty(){
		d.calculateTotalSurface();
	}
	@Test
	public void testCalculateTotalSurface_3_mokShapes(){
		d.addShape(new MokShape());
		d.addShape(new MokShape());
		d.addShape(new MokShape());
		Assert.assertEquals(3, d.calculateTotalSurface(), 0);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCalculateTotalPerimeter_list_empty(){
		d.calculateTotalPerimeter();
	}
	@Test
	public void testCalculateTotalPerimeter_3_mokShapes(){
		d.addShape(new MokShape());
		d.addShape(new MokShape());
		d.addShape(new MokShape());
		Assert.assertEquals(3, d.calculateTotalPerimeter(), 0);
	}
}
