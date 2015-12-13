package homework8;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot<T> {

	private int parkingLootSize;
	private int floorSize;
	private List<Floor<T>> parkingLot = new ArrayList<>(parkingLootSize);

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

		private final int findEmptySpot() throws IllegalAccessException {
			for (int spotNumber : floor.keySet()) {
				if (floor.get(spotNumber) == null) {
					return spotNumber;
				}
			}
			throw new IllegalAccessException("This floor is full!");
		}

		/**
		 * 
		 * @param element
		 *            The object to be saved
		 * @return The parking spot of that vehicle on this floor
		 * @throws IllegalAccessException
		 *             if the floor is full.
		 */
		public final int park(E element) throws IllegalAccessException {
			int emptySpot = findEmptySpot();
			floor.put(emptySpot, element);
			return emptySpot;
		}

		/**
		 * 
		 * @param parkingSpot
		 * @return The object saved in this ParkingSpot or null if there is no
		 *         object on that spot
		 */
		public final E retrieve(int parkingSpot) {
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

	private final int findNotFullFloor() throws ArrayIndexOutOfBoundsException {
		for (Floor<T> floor : parkingLot) {
			if (floor.isNotFull()) {
				return parkingLot.indexOf(floor);
			}
		}
		throw new ArrayIndexOutOfBoundsException("The parking lot is full come back later");
	}

	/**
	 * 
	 * @param vehicle
	 *            The vehicle to be parked
	 * @return A parking ticket with the corresponding info;
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the parking lot is full
	 */
	public final ParkingTiket parkVehicle(T vehicle) throws ArrayIndexOutOfBoundsException {
		int notFullFloor = findNotFullFloor();
		int spotOnFloor = 0;
		try {
			spotOnFloor = parkingLot.get(notFullFloor).park(vehicle);
		} catch (IllegalAccessException e) {
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
	public final T retrieveVehicle(ParkingTiket ticket) {

		return parkingLot.get(ticket.getFloor()).retrieve(ticket.getSpotOnFloor());
	}

	public ParkingLot(int parkingLootSize, int floorSize) {
		this.parkingLootSize = parkingLootSize;
		this.floorSize = floorSize;
		constructBuilding();
	}

	private final void constructBuilding() {
		for (int i = 0; i < parkingLootSize; i++) {
			parkingLot.add(new Floor<T>(this.floorSize));
		}

	}

}
