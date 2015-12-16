package ro.sci.java_dev.homework8.vehicles;
/**
 * Lotus is the abstract bases class for all Lotus cars created
 * Extends from Car() class;
 */
public abstract class Lotus extends Car {

	public Lotus(float fuelTankSize, String fuelType, int maxNumberOfGears, float availableFuel) {
		super(fuelTankSize, fuelType, maxNumberOfGears, availableFuel);
	}

	@Override
	protected float calculateFuelConsumption(float tripLength, int gear) {
		float fuelConsumed = calculateFuelConsumptionAlgorithm(gear)/100 * tripLength;
		return fuelConsumed;
	}

	protected abstract float calculateFuelConsumptionAlgorithm(int gear);

	@Override
	protected float calculatePollution(float fuelConsumed){
		return getCo2Emissions(fuelConsumed);
	}

	protected abstract float getCo2Emissions(float currentFuelConsumption);

}
