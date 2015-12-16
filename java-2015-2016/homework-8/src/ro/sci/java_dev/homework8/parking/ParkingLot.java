package homework8;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a parking lot. A parkingLot can store multiple instances of type T
 * by using the {@link #parkVehicle(Object)} receiving a parking ticket, and
 * retrieve them using {@link #retrieveVehicle(ParkingTiket)} presenting the
 * parking ticket provided.
 * 
 * @author Oltean Andrei-Florin
 *
 * @param <E>
 *            Type of object to be used in the class specified when
 *            instantiating the class;
 */
public class ParkingLot<E> {

	private int parkingLootSize;
	private int floorSize;
	private List<Floor<E>> parkingLot = new ArrayList<>(parkingLootSize);

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
	public final ParkingTiket parkVehicle(E vehicle) throws UnsupportedOperationException {
		int notFullFloor = findNotFullFloor();
		int spotOnFloor = 0;
		try {
			spotOnFloor = parkingLot.get(notFullFloor).park(vehicle);
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
			System.exit(1);// This should never happen but just in case:P
		}
		return new ParkingTiket(notFullFloor, spotOnFloor);
	}

	/**
	 * 
	 * @param ticket
	 *            Parking ticket.
	 * @return the vehicle parked at the specified spot or null if there is no
	 *         car there.
	 */
	public final E retrieveVehicle(ParkingTiket ticket) throws IllegalArgumentException {

		if (ticket.getFloor() > this.parkingLootSize) {
			throw new IllegalArgumentException("This parking loot dose not have that manny floors");
		}
		return parkingLot.get(ticket.getFloor()).retrieve(ticket.getSpotOnFloor());
	}

	public ParkingLot(int parkingLootSize, int floorSize) {
		this.parkingLootSize = parkingLootSize;
		this.floorSize = floorSize;
		constructBuilding();
	}

	private final void constructBuilding() {
		for (int i = 0; i < parkingLootSize; i++) {
			parkingLot.add(new Floor<E>(this.floorSize));
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParkingLot [parkingLootSize=" + parkingLootSize + ", floorSize=" + floorSize + "]";
	}

}