package shapes;
/**
 * Class Triangle 
 * defines a EQUILATERAL triangle;
 * @author Oltean Andrei-Florin
 *
 */
public class Triangle implements Shape {

	private float side;
	public static final float SQRT3 = 1.732f;
	
	public float calculateSurface() {
		float hight = side * SQRT3;
		hight /=2;
		float surface = side * hight;
		surface /=2;
		return surface;
	}

	
	public float calculatePerimetre() {
		float perimetre = 3*side;
		return perimetre;
	}


	public Triangle(float base, float hight) {
		super();
		this.side = base;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(side);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (Float.floatToIntBits(side) != Float.floatToIntBits(other.side))
			return false;
		return true;
	}


}
