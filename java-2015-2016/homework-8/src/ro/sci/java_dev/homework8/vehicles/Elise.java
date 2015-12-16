package ro.sci.java_dev.homework8.vehicles;

// TODO CODE REVIEW: Your code is a bit messy and unformatted; take care uf unecessary empty lines, and watch out for indentation.
public class Elise extends Lotus {
	protected static final float FUEL_TANK_SIZE =60; //Factory specifications
	protected static final String FUEL_TYPE="Petrol"; //Factory specifications
	protected static final int MAX_NUMBER_OF_GEARS=6; //Factory specifications
	protected static final float POLLUTION=149; //Factory specifications
	protected static final float FUEL_CONSUMED_AT_SART=0.23f;//Custom consumption of fuel at the start of the motor may vary from reality
	protected static final float FUEL_CONSUMPTION_AVERAGE = 6.3f;//Factory specifications
	protected final String chassisNumber;

	public String getChassisNumber() {
		return this.chassisNumber;
	}
	@Override
	protected final float calculateFuelConsumptionAlgorithm(int gear) {

		switch (gear){
		case 1:
			return 9.95f;
		case 2:
			return 8.3f;
		case 3:
			return 6.55f;
		case 4:
			return 5.65f;
		case 5:
			return 5;
		case 6:
			return 4.34f;
		default:
			return 0;

		}
	}
	@Override
	protected float getCo2Emissions(float currentFuelConsumed) {
		float currentCo2Emmisions = currentFuelConsumed * 2365.08f;
		return currentCo2Emmisions;
		
	}
	@Override
	protected float getFuelConsumedAtStart() {
		return FUEL_CONSUMED_AT_SART;
	}
	@Override
	protected float calculateStarPollution() {
		float co2Produced =FUEL_CONSUMED_AT_SART * 2392;  //1 L of gasoline produces 2392 g of co2
		return co2Produced;
	}
	public Elise(double availableFuel,String chassisNumber)throws RuntimeException{
		super(FUEL_TANK_SIZE, FUEL_TYPE, MAX_NUMBER_OF_GEARS, (float)availableFuel);
		if (availableFuel>FUEL_TANK_SIZE ){
			throw new RuntimeException("Too mutch fuel!");
		}
		this.chassisNumber = chassisNumber;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chassisNumber == null) ? 0 : chassisNumber.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elise other = (Elise) obj;
		if (chassisNumber == null) {
			if (other.chassisNumber != null)
				return false;
		} else if (!chassisNumber.equals(other.chassisNumber))
			return false;
		return true;
	}
}
