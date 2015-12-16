package ro.sci.java_dev.homework8.parking;

public class ParkingTiket {

	private final int floor;
	private final int spotOnFloor;
	public ParkingTiket(int floor, int spotOnFloor)throws IllegalArgumentException {
		validate(floor,spotOnFloor);
		this.floor = floor;
		this.spotOnFloor = spotOnFloor;
	}
	private final void validate(int floor,int spot){
		if(floor<0||spot<0){
			throw new IllegalArgumentException("Cant be negative numbers");
		}
	}
	/**
	 * @return the floor
	 */
	public final int getFloor() {
		return floor;
	}
	/**
	 * @return the spotOnFloor
	 */
	public final int getSpotOnFloor() {
		return spotOnFloor;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + floor;
		result = prime * result + spotOnFloor;
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
		ParkingTiket other = (ParkingTiket) obj;
		if (floor != other.floor)
			return false;
		if (spotOnFloor != other.spotOnFloor)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParkingTiket [floor=" + floor + ", spotOnFloor=" + spotOnFloor + "]";
	}
	
}
