package ro.sci.java_dev.homework8.vehicles;

public class ModelX extends Tesla {
	protected static final float BATTERY =100; //Factory specifications represents 100% charged batteries ~ 402.336km or 250 miles
	protected static final String FUEL_TYPE="Electricity"; //Factory specifications
	protected static final int MAX_NUMBER_OF_GEARS=1; //Factory specifications
	protected static final float BATTERY_USED_IN_100KM=24.854f; //Represents a % of the battery used in 100 km
	protected final String chassisNumber;
	
	public String getChassisNumber() {
		return this.chassisNumber;
	}
	@Override
	protected float calculateStarPollution() {
		return 0;
	}
	@Override
	protected float getFuelConsumedAtStart() {
		return 0;
	}
	@Override
	protected float returnFuelConsumptionAlgorithm(int gear) {

		if (gear == 0){
			return 0;
		}else{
			return BATTERY_USED_IN_100KM;
		}
	}
	public ModelX(double availableFuel,String chassisNumber)throws RuntimeException{  //In this case i will consider the available fuel as % battery charged
		super(BATTERY, FUEL_TYPE, MAX_NUMBER_OF_GEARS, (float)availableFuel);
		if (availableFuel>BATTERY ){
			throw new RuntimeException("Too mutch POWER!");
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
		ModelX other = (ModelX) obj;
		if (chassisNumber == null) {
			if (other.chassisNumber != null)
				return false;
		} else if (!chassisNumber.equals(other.chassisNumber))
			return false;
		return true;
	}
}


