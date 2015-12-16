package ro.sci.java_dev.homework8.other;

import ro.sci.java_dev.homework8.vehicles.Vehicle;

public class MyHorse implements Vehicle {

	public float haySuply;

	@Override
	public void start() {
		System.out.println("Neigh!!!! Goes the horse:D");
	}

	@Override
	public void drive(double tripLength) throws RuntimeException {
		this.haySuply -= 0.1f;
		if (this.haySuply <= 0) {
			throw new RuntimeException("You starved the horse!");
		}

	}

	/**
	 * @param haySuply
	 */
	public MyHorse(float haySuply) {
		super();
		this.haySuply = haySuply;
	}

	@Override
	public void stop() {

	}

	/**
	 * @return the fuel
	 */
	public float getAvailableFuel() {
		return haySuply;
	}

}
