package ro.sci.java_dev.homework8.parking;

import ro.sci.java_dev.homework8.vehicles.Vehicle;

public class ValetParking<T extends Vehicle> {

	private float distanceToParkingLot = 0.05f;// default distance to the
												// parking lot;
	private float distanceBetwenFloors = 0.02f;// default distance between
												// floors;
	private int numberOfFloors = 5;// default number of floors for a parking
									// lot;
	private int floorSize = 20;// default size for each floor;
	public ParkingLot<T> carPark;

	private final void setUpParkingLot() {
		this.carPark = new ParkingLot<>(numberOfFloors, floorSize);
	}

	/**
	 * Default constructor will use the default values for the floor size(20) and
	 * number of floors(5);
	 */
	public ValetParking() {
		setUpParkingLot();
	}

	/**
	 * constructor for custom parking lot where the number of floors and floors
	 * size are passed; If no arguments are passed the default sizes will be
	 * used(default number of floors is 5,default size for each floor is 20)
	 * 
	 * @param numberOfFloors
	 * @param floorSize
	 */
	public ValetParking(int numberOfFloors, int floorSize) {
		this.numberOfFloors = numberOfFloors;
		this.floorSize = floorSize;
		setUpParkingLot();
	}

	/**
	 * @return the numberOfFloors
	 */
	public final int getNumberOfFloors() {
		return numberOfFloors;
	}

	/**
	 * @return the floorSize
	 */
	public final int getFloorSize() {
		return floorSize;
	}

	/**
	 * @return the distanceToParkingLot (default is 0,05kms)
	 */
	public final float getDistanceToParkingLot() {
		return distanceToParkingLot;
	}

	/**
	 * @param distanceToParkingLot
	 *            the distanceToParkingLot to set
	 */
	public final void setDistanceToParkingLot(float distanceToParkingLot) {
		this.distanceToParkingLot = distanceToParkingLot;
	}

	/**
	 * @return the distanceBetwenFloors (default is 0,02kms)
	 */
	public final float getDistanceBetwenFloors() {
		return distanceBetwenFloors;
	}

	/**
	 * @param distanceBetwenFloors
	 *            the distanceBetwenFloors to set
	 */
	public final void setDistanceBetwenFloors(float distanceBetwenFloors) {
		this.distanceBetwenFloors = distanceBetwenFloors;
	}
}
