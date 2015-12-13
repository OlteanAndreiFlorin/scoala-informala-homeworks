package homework8;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot<T> {

	private int parkingLootSize;
	private int floorSize;
	private List<Floor<T>> parkingLot = new ArrayList<>(parkingLootSize);

	private class Floor<E> {
		private int floorSize;
		private List<E> floor = new ArrayList<>(floorSize);// 10 spaces for each
															// floor

		public Floor(int floorSize) {
			super();
			this.floorSize = floorSize;
		}

		/**
		 * 
		 * @param vehicle
		 *            vehicle to be parked
		 * @return The parking spot of that vehicle on this floor
		 * @throws ArrayIndexOutOfBoundsException
		 *             if the floor is full
		 */
		public final int park(E vehicle) {
			if (floor.size() == this.floorSize) {
				throw new ArrayIndexOutOfBoundsException("This floor is full");
			}
			floor.add(vehicle);
			return floor.indexOf(vehicle);
		}

		/**
		 * 
		 * @param parkingSpot
		 * @return The vehicle parked in this ParkingSpot
		 */
		public final E retrieve(int parkingSpot) {
			return floor.remove(parkingSpot);
		}

		public final boolean isNotFull() {

			if (floor.size() < this.floorSize) {
				return true;
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
		int spotOnFloor = parkingLot.get(notFullFloor).park(vehicle);
		return new ParkingTiket(notFullFloor, spotOnFloor);
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
