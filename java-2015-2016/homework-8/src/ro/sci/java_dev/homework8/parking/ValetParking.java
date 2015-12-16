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
	private ParkingLot<T> carPark;

	private final void setUpParkingLot() {
		this.carPark = new ParkingLot<>(numberOfFloors, floorSize);
	}

	/**
	 * Drives the vehicle to the parking lot,receives a ticket from the parking
	 * lot parks the vehicle on the spot printed on the ticket;
	 * 
	 * @param vehicle
	 * @return the parking ticket with the floor and spot information on it;
	 * @throws RuntimeException
	 *             if the vehicle was mishandled(runs out of gas);
	 * @throws UnsupportedOperationException
	 *             if the lot is full;
	 */
	public final ParkingTicket parkVehicle(T vehicle) throws RuntimeException, UnsupportedOperationException {
		vehicle.start();
		vehicle.drive(distanceToParkingLot);
		ParkingTicket ticket = carPark.parkVehicle(vehicle);
		for (int i = 0; i < ticket.getNumberOfFloors(); i++) {
			vehicle.drive(distanceBetwenFloors);
		}
		vehicle.stop();
		return ticket;
	}

	/**
	 * retrieves the vehicle from the lot and drives it to the owner(initial
	 * spot)
	 * 
	 * @param ticket
	 *            received when the vehicle was parked {@link ParkingTicket}
	 * @return the vehicle parked at the specified info on the parking
	 *         {@link ParkingTicket} or null if no car was found
	 * @throws IllegalArgumentException
	 *             if the parking ticket passed is invalid;
	 * @throws RuntimeException
	 *             if the car was mishandled(runs out of gas)
	 */
	public final T retrieveVehicle(ParkingTicket ticket) throws IllegalArgumentException, RuntimeException {
		T vehicle = carPark.retrieveVehicle(ticket);
		vehicle.start();
		for (int i = ticket.getNumberOfFloors(); i > 0; i--) {
			vehicle.drive(distanceBetwenFloors);
		}
		vehicle.drive(distanceToParkingLot);
		vehicle.stop();
		return vehicle;
	}

	/**
	 * Default constructor will use the default values for the floor size(20)
	 * and number of floors(5);
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
