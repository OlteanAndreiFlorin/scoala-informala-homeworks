package ro.sci.java_dev.homework8.other;

public class SiegeTank implements Tank {

	public float fuel;

	/**
	 * @param fuel
	 */
	public SiegeTank(float fuel) {
		super();
		this.fuel = fuel;
	}

	@Override
	public void start() {
		this.fuel -= 0.5f;

	}

	@Override
	public void drive(double tripLength) {
		this.fuel -= 0.5f;
		if (this.fuel <= 0) {
			throw new RuntimeException("No more fuel");
		}

	}

	@Override
	public void stop() {

	}

	@Override
	public void shotCannon() {
		// shoot something

	}
	/**
	 * @return the fuel
	 */
	public float getAvailableFuel() {
		return fuel;
	}

}
