package shapes;

public class Circle implements Shape {

	private float radius;
	public static final float PI = 3.14f;
	
	
	public float calculateSurface() {
		float surface = PI * radius * radius;
		return surface;
	}

	
	public float calculatePerimetre() {
		float perimetre = 2 * PI * radius;
		return perimetre;
	}

	public Circle(float radius) {
		this.radius = radius;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(radius);
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
		Circle other = (Circle) obj;
		if (Float.floatToIntBits(radius) != Float.floatToIntBits(other.radius))
			return false;
		return true;
	}

}
