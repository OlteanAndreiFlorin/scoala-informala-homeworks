package drawingTools;


import org.junit.Before;
import org.junit.Test;

import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;

public class DrawingToolTest {

	DrawingTool d;
	Shape c = new Circle(10);
	Shape r = new Rectangle(10, 20);
	
	@Before
	public void cleanUp(){
		d=new DrawingTool();
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddShape_similar_shape(){
		d.addShape(c);
		Shape c1 = new Circle(10);
		d.addShape(c1);
	}
}
