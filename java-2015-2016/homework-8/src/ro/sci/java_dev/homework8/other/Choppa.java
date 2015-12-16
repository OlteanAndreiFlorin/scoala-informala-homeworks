package ro.sci.java_dev.homework8.other;

import ro.sci.java_dev.homework8.vehicles.Vehicle;

public class Choppa implements Vehicle {

	private float fuel;

	/**
	 * @param fuel
	 */
	public Choppa(float fuel) {
		super();
		this.fuel = fuel;
	}

	@Override
	public void start() {
		this.fuel -= 1;

	}

	@Override
	public void drive(double tripLength) {
		this.fuel -= 10;
		if (this.fuel < 0) {
			throw new RuntimeException("You will die cose this Chopa's going DOWN!!!");
		}

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the fuel
	 */
	public float getAvailableFuel() {
		return fuel;
	}

}
