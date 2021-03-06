package ro.sci.java_dev.homework8.parking;

/**
 * Parking tickets can be created using this class witch save information about
 * a parking spot(Floor nr. and spot nr.);
 * 
 * @author Oltean-Andrei-Florin
 *
 */
public class ParkingTicket {

	private final int numberOfFloors;
	private final int spotOnFloor;

	/**
	 * constructor for parking ticket
	 * 
	 * @param numberOfFloors
	 * @param spotOnFloor
	 * @throws IllegalArgumentException
	 *             if you pass an illegal spot on floor number(must be >0);
	 */
	public ParkingTicket(int numberOfFloors, int spotOnFloor) throws IllegalArgumentException {
		validate(spotOnFloor);
		this.numberOfFloors = numberOfFloors;
		this.spotOnFloor = spotOnFloor;
	}

	private final void validate(int spotOnFloor) {
		if (spotOnFloor < 0) {
			throw new IllegalArgumentException("The spot on froos cant be negative numbers");
		}
	}

	/**
	 * @return the floor
	 */
	public final int getNumberOfFloors() {
		return numberOfFloors;
	}

	/**
	 * @return the spotOnFloor
	 */
	public final int getSpotOnFloor() {
		return spotOnFloor;
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
		result = prime * result + numberOfFloors;
		result = prime * result + spotOnFloor;
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
		ParkingTicket other = (ParkingTicket) obj;
		if (numberOfFloors != other.numberOfFloors)
			return false;
		if (spotOnFloor != other.spotOnFloor)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParkingTiket [floor=" + numberOfFloors + ", spotOnFloor=" + spotOnFloor + "]";
	}

}
