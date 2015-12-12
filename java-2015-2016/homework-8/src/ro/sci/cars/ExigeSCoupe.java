package ro.sci.cars;

public class ExigeSCoupe extends Lotus {
	protected static final float FUEL_TANK_SIZE =60; //Factory specifications
	protected static final String FUEL_TYPE="Petrol"; //Factory specifications
	protected static final int MAX_NUMBER_OF_GEARS=6; //Factory specifications
	protected static final float POLLUTION=235; //Factory specifications co2 g/km
	protected static final float FUEL_CONSUMED_AT_SART=0.45f;//Custom consumption of fuel at the start of the motor may vary from reality
	protected static final float FUEL_CONSUMPTION_AVERAGE = 10.1f; //Factory specifications liters/100km combined
	protected static final float FUEL_CONSUMPTION_AVARAGE_URBAN = 14.5f;//Factory specifications liters/100km urban environment
	protected static final float FUEL_CONSUMPTION_AVARAGE_EXTRA_URBAN = 7.6f;//Factory specifications liters/100km extraUrban environment
	protected final String chassisNumber;
	
	public String getChassisNumber() {
		return this.chassisNumber;
	}
	
	@Override
	protected final float calculateFuelConsumptionAlgorithm(int gear) {
		if (gear == 0){
			return 0;
		}else
		if (gear<4){
			return FUEL_CONSUMPTION_AVARAGE_URBAN;
		}else{
			return FUEL_CONSUMPTION_AVARAGE_EXTRA_URBAN;
		}
	}
	@Override
	protected float calculateStarPollution() {
		float co2Produced = FUEL_CONSUMED_AT_SART * 2392;  //1 L of gasoline produces 2392 g of co2
		return co2Produced;
	}
	@Override
	protected float getFuelConsumedAtStart() {
		return FUEL_CONSUMED_AT_SART;
	}


	@Override
	protected float getCo2Emissions(float currentFuelConsumed) {
		float currentCo2Emmisions = currentFuelConsumed * 2326.7326f;
		return currentCo2Emmisions;
	}
	
	public ExigeSCoupe(double availableFuel,String chassisNumber)throws RuntimeException{
		super(FUEL_TANK_SIZE, FUEL_TYPE, MAX_NUMBER_OF_GEARS, (float)availableFuel);
		if (availableFuel>FUEL_TANK_SIZE ){
			throw new RuntimeException("Too mutch fuel!");
		}
		this.chassisNumber = chassisNumber;
	}

	
}