package shapes;

public class Rectangle implements Shape {

	private float side;
	private float width;

	public float calculateSurface() {
		float surface = side * width;
		return surface;
	}

	public float calculatePerimetre() {
		float perimetre = side + width;
		perimetre *= 2;
		return perimetre;
	}

	public Rectangle(int side, int base) {
		this.side = side;
		this.width = base;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(side);
		result = prime * result + Float.floatToIntBits(width);
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
		Rectangle other = (Rectangle) obj;
		if (Float.floatToIntBits(side) != Float.floatToIntBits(other.side))
			return false;
		if (Float.floatToIntBits(width) != Float.floatToIntBits(other.width))
			return false;
		return true;
	}

}
