package shapes;

public class Square implements Shape {

	private float side;
	
	public float calculateSurface() {
		float surface = side *side;
		return surface;
	}

	
	public float calculatePerimetre() {
		float perimetre = 4*side;
		return perimetre;
	}


	public Square(int side) {
		super();
		this.side = side;
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
		Square other = (Square) obj;
		if (Float.floatToIntBits(side) != Float.floatToIntBits(other.side))
			return false;
		return true;
	}

}
