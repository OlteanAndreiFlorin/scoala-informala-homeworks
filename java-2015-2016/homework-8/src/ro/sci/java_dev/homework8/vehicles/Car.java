package ro.sci.cars;



/**
 *Car is the abstract bases class for all cars created.
 *It implements the Vehicle() interface.
 * @author Oltean Andrei-Florin
 *
 */
public abstract class Car implements Vehicle {

	protected final float fuelTankSize; //Factory specifications
	protected final String fuelType; //Factory specifications
	protected final int maxNumberOfGears; //Factory specifications
	protected float availableFuel;
	protected float fuleConsumedThisTrip = 0;
	protected float pollutionThisTrip  = 0;
	protected float tripLengthTotal=0;
	private int currentGear=0;
	private float totalFuelUsed=0;
	private float totalPollutionStats=0;
	private boolean carStatus;
	
	/**
	 * Overwrites the vehicle() implementation 
	 * implementing the start() method for the Car() object;
	 * saves the fuel consumed and pollution created when "starting a car";
	 * invokes the System.exit(); method when the 
	 * car is started while running or
	 * when the car is started in a >1'st gear ;
	 */
	@Override
	public void start()throws RuntimeException {
		if (this.availableFuel<this.getFuelConsumedAtStart()){
			throw new RuntimeException("The car dose not have fuel for start");
		}
		if (carStatus){
			throw new RuntimeException("The car was alredy started!You cant start a runniing car!");
		}
		this.carStatus = true;
		if (this.currentGear>1){
			throw new RuntimeException("Nice you broke the car :|,who starts their car in "+ this.currentGear+"nd/rd gear");
		
		}
		System.out.println("Car has started");
		saveStats(getFuelConsumedAtStart(),calculateStarPollution());
		this.availableFuel-=getFuelConsumedAtStart();
		resetStats();

	}
	
	/**
	 *Calculates the fuel consumed in a certain trip length;
	 *Invokes System.exit() if the car remains with no fuel 
	 *Saves the fuel consumed and pollution for the given length;
	 */
	@Override
	public void drive(double tripLength)throws RuntimeException {
		if(!carStatus){
			System.out.println("The car was not started yet, i will start it for you!");
			start();
		}
		float fuelConsumed = calculateFuelConsumption((float)tripLength, getGear());
		if ((this.availableFuel - fuelConsumed)<=0){
			throw new RuntimeException("Well shoot no more fuel!");
		}
		manadgeDriveModificationsToFields(tripLength, fuelConsumed);
	}
	private void manadgeDriveModificationsToFields(double tripLength, float fuelConsumed) {//Manages the states of the car 
		this.availableFuel-=fuelConsumed;
		this.fuleConsumedThisTrip += fuelConsumed;
		this.pollutionThisTrip += calculatePollution(fuelConsumed);
		this.tripLengthTotal += tripLength;
	}

	/**
	 * Saves consumption and pollution;
	 * Prints out a message confirming the invoking of the method
	 * sets the car status; 
	 */
	@Override
	public void stop() {
		saveStats(getfuleConsumedThisTrip(),getPollutionThisTrip());
		System.out.println("The car has stoped.");
		this.carStatus = false;

	}
	/**
	 * Shifts the gear saving the new value in the same field 
	 * invokes System.exit() if the gear dose not exist
	 * @param gear current gear
	 */
	public void shiftGear(int gear)throws RuntimeException {
		if (!carStatus){
			throw new RuntimeException("You broke the car!! Dont shift gear when the car stoped!");
			
		}
		if (gear >maxNumberOfGears ){
			throw new RuntimeException("Nice you broke the car :| the car only has "+maxNumberOfGears+" gear/s dude");
		}
		setGear(gear);


	}

	protected abstract float calculateFuelConsumption (float tripLength , int gear);

	protected abstract float calculatePollution(float fuelConsumed);

	protected abstract float calculateStarPollution();

	protected abstract float getFuelConsumedAtStart();


	private void saveStats(float fuelConsumed , float pollution){//Saves the fuel and pollutuin
		this.totalFuelUsed += fuelConsumed;
		this.totalPollutionStats += pollution;
	}

	private void resetStats() {//resets the fuel consumed and pollution when the car is started
		setFuleConsumedThisTrip(0);
		setPollutionThisTrip(0);		
	}
	/**
	 * 
	 * @return The fuel type
	 */
	public String getFuelType() {
		return fuelType;
	}


	public float calculateAverageFuelConsumption()throws RuntimeException {//calculates the avarage fuel consumption / 100km
		if (carStatus&&tripLengthTotal == 0){
			throw new RuntimeException("The average is not available for a started car that has moved 0km");
		}
		if (tripLengthTotal == 0){
			return 0;
		}
		float fuelConsumedPer100Km = totalFuelUsed / tripLengthTotal *100 ;
		return fuelConsumedPer100Km;
	}
	public float calculatePollution()throws RuntimeException {
		if (carStatus&&tripLengthTotal == 0){
			throw new RuntimeException("The average is not available for a started car that has moved 0km");
		}
		if (tripLengthTotal == 0){
			return 0;
		}
		float pollutionPerKm = totalPollutionStats / tripLengthTotal;
		return pollutionPerKm;
	}


	public float getAvailableFuel() {
		return availableFuel;
	}

	private float getfuleConsumedThisTrip() {
		return fuleConsumedThisTrip;
	}


	private void setFuleConsumedThisTrip(float fuleConsumedThisTrip) {
		this.fuleConsumedThisTrip = fuleConsumedThisTrip;
	}

	private float getPollutionThisTrip() {
		return pollutionThisTrip;
	}

	private void setPollutionThisTrip(float pollutionThisTrip) {
		this.pollutionThisTrip = pollutionThisTrip;
	}

	private int getGear() {
		return currentGear;
	}

	private void setGear(int gear)throws RuntimeException {
		if(gear < 0){
			throw new RuntimeException("Gear dose not exist");
		}
		this.currentGear = gear;
	}

	public float getTripTotalLength() {
		return tripLengthTotal;
	}

	/**
	 * Constructor for the Car class
	 * @param fuelTankSize
	 * @param fuelType
	 * @param maxNumberOfGears
	 * @param availableFuel
	 */
	public Car(float fuelTankSize, String fuelType, int maxNumberOfGears, float availableFuel) {
		this.fuelTankSize = fuelTankSize;
		this.fuelType = fuelType;
		this.maxNumberOfGears = maxNumberOfGears;
		this.availableFuel = availableFuel;
	}

}
