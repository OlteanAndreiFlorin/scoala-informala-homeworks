package ro.sci.java_dev.homework8.parking;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a parking lot. A parkingLot can store multiple instances of type T
 * by using the {@link #parkVehicle(Object)} receiving a parking ticket, and
 * retrieve them using {@link #retrieveVehicle(ParkingTicket)} presenting the
 * parking ticket provided.
 * 
 * @author Oltean Andrei-Florin
 *
 * @param <E>
 *            Type of object to be used in the class specified when
 *            instantiating the class;
 */
public class ParkingLot<E> {

	private String parkingLotType = "Standard";
	private int numberOfFloors;
	private int floorSize;
	private List<Floor<E>> parkingLot = new ArrayList<>(numberOfFloors);

	@SuppressWarnings("hiding")
	private final class Floor<E> {
		private int floorSize;
		private Map<Integer, E> floor = new LinkedHashMap<>(floorSize);

		public Floor(int floorSize) {
			this.floorSize = floorSize;
			numberFloor();
		}

		private final void numberFloor() {
			for (int i = 1; i <= this.floorSize; i++) {
				floor.put(i, null);
			}
		}

		private final int findEmptySpot() throws UnsupportedOperationException {
			for (int spotNumber : floor.keySet()) {
				if (floor.get(spotNumber) == null) {
					return spotNumber;
				}
			}
			throw new UnsupportedOperationException("This floor is full!");
		}

		/**
		 * Parks an element of Of type E
		 * 
		 * @param element
		 *            The element to be stored/parked; The object to be saved
		 * @return The parking spot of that vehicle on this floor
		 * @throws UnsupportedOperationException
		 *             if the floor is full.
		 */
		public final int park(E element) throws UnsupportedOperationException {
			int emptySpot = findEmptySpot();
			floor.put(emptySpot, element);
			return emptySpot;
		}

		/**
		 * Retrieves a Instance of type E using the provided parking spot
		 * number;
		 * 
		 * @param parkingSpot
		 *            Parking number where the object is stored
		 * 
		 * @return The object saved in this ParkingSpot or null if there is no
		 *         object on that spot
		 * @throws IllegalArgumentException
		 *             if the parking number passed is invalid;
		 */
		public final E retrieve(int parkingSpot) throws IllegalArgumentException {
			if (parkingSpot > this.floorSize) {
				throw new IllegalArgumentException("This floor dose not have that manny spaces");
			}
			E element = floor.get(parkingSpot);
			floor.put(parkingSpot, null);
			return element;

		}

		public final boolean isNotFull() {

			for (E element : floor.values()) {
				if (element == null) {
					return true;
				}
			}
			return false;
		}
	}

	private final int findNotFullFloor() throws UnsupportedOperationException {
		for (Floor<E> floor : parkingLot) {
			if (floor.isNotFull()) {
				return parkingLot.indexOf(floor);
			}
		}
		throw new UnsupportedOperationException("The parking lot is full come back later");
	}

	/**
	 * Stores the instance of type E on a floor;
	 * 
	 * @param vehicle
	 *            The vehicle to be parked
	 * @return A parking ticket with the corresponding info;
	 * @throws UnsupportedOperationException
	 *             if the parking lot is full
	 */
	public final ParkingTicket parkVehicle(E vehicle) throws UnsupportedOperationException {
		int notFullFloor = findNotFullFloor();
		int spotOnFloor = 0;
		try {
			spotOnFloor = parkingLot.get(notFullFloor).park(vehicle);
		} catch (UnsupportedOperationException e) {// This should never happen
													// but just in case:P
			e.printStackTrace();
			System.exit(1);
		}
		if ("Standard".equals(parkingLotType)) {
			return new ParkingTicket(notFullFloor, spotOnFloor);
		} else {
			return new ParkingTicket(-notFullFloor, spotOnFloor);
		}
	}

	/**
	 * 
	 * @param ticket
	 *            Parking ticket.
	 * @return the vehicle parked at the specified spot or null if there is no
	 *         car there.
	 * @throws IllegalArgumentException
	 *             if the ticket passed is invalid;
	 */
	public final E retrieveVehicle(ParkingTicket ticket) throws IllegalArgumentException {
		if ("Standard".equals(parkingLotType) && ticket.getNumberOfFloors() < 0) {
			throw new IllegalArgumentException("Not a valid parking ticket for this instance");
		}
		if (!"Standard".equals(parkingLotType) && ticket.getNumberOfFloors() > 0) {
			throw new IllegalArgumentException("Not a valid parking ticket for this instance");
		}
		if ("Standard".equals(parkingLotType)) {
			if (ticket.getNumberOfFloors() > this.numberOfFloors) {
				throw new IllegalArgumentException("This parking loot dose not have that manny floors");
			}
			return parkingLot.get(ticket.getNumberOfFloors()).retrieve(ticket.getSpotOnFloor());
		} else {
			if (-ticket.getNumberOfFloors() > this.numberOfFloors) {
				throw new IllegalArgumentException("This parking loot dose not have that manny floors");
			}
			return parkingLot.get(-ticket.getNumberOfFloors()).retrieve(ticket.getSpotOnFloor());
		}
	}

	private final void constructBuilding() {
		for (int i = 0; i < numberOfFloors; i++) {
			parkingLot.add(new Floor<E>(this.floorSize));
		}

	}

	private final void validateFloorSize(int floorSize) throws IllegalArgumentException {
		if (floorSize < 1) {
			throw new IllegalArgumentException("The floor needs to have at least 1 spot on it");
		}
	}

	/**
	 * Standard constructor for the parking lot;
	 * 
	 * @param numberOfFloors
	 * @param floorSize
	 * @throws IllegalArgumentException
	 *             if an invalid floor size is passed
	 */
	public ParkingLot(int numberOfFloors, int floorSize) throws IllegalArgumentException {
		this.numberOfFloors = numberOfFloors;
		validateFloorSize(floorSize);
		this.floorSize = floorSize;
		constructBuilding();
	}

	/**
	 * Constructor for underground parking lot; If any string is passed as the
	 * parking lot type it will automatically presume is an underground parking
	 * lot except when the type passed is Standard in witch case it will handle
	 * is as if no type was passed;
	 * 
	 * @param parkingLotType
	 * @param numberOfFloors
	 * @param floorSize
	 * @throws IllegalArgumentException
	 *             if an invalid floor size is passed
	 */
	public ParkingLot(String parkingLotType, int numberOfFloors, int floorSize) throws IllegalArgumentException {
		this.parkingLotType = parkingLotType;
		this.numberOfFloors = numberOfFloors;
		validateFloorSize(floorSize);
		this.floorSize = floorSize;
		constructBuilding();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParkingLot [parkingLotType=" + parkingLotType + ", numberOfFloors=" + numberOfFloors + ", floorSize="
				+ floorSize + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + floorSize;
		result = prime * result + numberOfFloors;
		result = prime * result + ((parkingLotType == null) ? 0 : parkingLotType.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		@SuppressWarnings("rawtypes")
		ParkingLot other = (ParkingLot) obj;
		if (floorSize != other.floorSize)
			return false;
		if (numberOfFloors != other.numberOfFloors)
			return false;
		if (parkingLotType == null) {
			if (other.parkingLotType != null)
				return false;
		} else if (!parkingLotType.equals(other.parkingLotType))
			return false;
		return true;
	}

}
