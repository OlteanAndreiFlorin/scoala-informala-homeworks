package ro.sci.cars;
/**
 * Tesla is the abstract bases class for all Tesla cars created
 * Extends from Car() class
 */

public abstract class Tesla extends Car {

	public Tesla(float fuelTankSize, String fuelType, int maxNumberOfGears, float availableFuel) {
		super(fuelTankSize, fuelType, maxNumberOfGears, availableFuel);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected float calculateFuelConsumption(float tripLength, int gear) {
		float fuelConsumed = returnFuelConsumptionAlgorithm(gear)/100 * tripLength;
		return fuelConsumed;
	}
	protected abstract float returnFuelConsumptionAlgorithm(int gear);
	@Override
	protected float calculatePollution(float fuelConsumed) {
		return 0;
	}

}
