package drawingTools;

import java.util.ArrayList;
import java.util.List;

import shapes.Shape;

public class DrawingTool {

	private List<Shape> shapeList = new ArrayList<>();
	
	public void addShape(Shape s)throws IllegalArgumentException{
		if(shapeList.contains(s)){
			throw new IllegalArgumentException("Argument alredy in the list");
		}
		shapeList.add(s);
	}
	
	public final float calculateTotalSurface()throws NullPointerException{
		if (shapeList.isEmpty()){
			throw new NullPointerException("No shapes added nothing to calculate");
		}
		float totalSurface=0;
		for (Shape s :shapeList){
			totalSurface +=s.calculateSurface();
		}
		return totalSurface;
	}
	
	public final float calculateTotalPerimeter()throws NullPointerException{
		if (shapeList.isEmpty()){
			throw new NullPointerException("Nothing to calculate!");
		}
		float totalPerimeter=0;
		for (Shape s :shapeList){
			totalPerimeter+=s.calculatePerimetre();
		}
		return totalPerimeter;
	}
	/**
	 * @return An ArrayList with all the shapes stored inside
	 */
	public final List<Shape> getShapeList(){
		return new ArrayList<Shape>(shapeList);
	}
}