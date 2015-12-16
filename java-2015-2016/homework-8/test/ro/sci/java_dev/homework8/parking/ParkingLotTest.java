package ro.sci.java_dev.homework8.parking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ro.sci.java_dev.homework8.parking.ParkingLot;
import ro.sci.java_dev.homework8.parking.ParkingTicket;

public class ParkingLotTest {

	ParkingLot<MockVehicle> carPark;

	class MockVehicle {
		// this dose nothing
		// the point is to test the methods in ParkingLot
	}

	@Before
	public void setUp() {
		carPark = new ParkingLot<>(1, 2);
	}

	@Test
	public void testParkVehicle_normal_parking() {
		ParkingTicket expected = new ParkingTicket(0, 1);
		ParkingTicket actual = carPark.parkVehicle(new MockVehicle());
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testParkVehicle_pakingLot_full() {
		carPark.parkVehicle(new MockVehicle());
		carPark.parkVehicle(new MockVehicle());
		carPark.parkVehicle(new MockVehicle());
	}
	
	@Test
	public void testParkVehicle_underground_normal_parking(){
		carPark=new ParkingLot<>("Banana", 2, 1);
		ParkingTicket expected = new ParkingTicket(-1, 1);
		carPark.parkVehicle(new MockVehicle());
		ParkingTicket actual = carPark.parkVehicle(new MockVehicle());
		Assert.assertEquals(expected, actual);
	}
	@Test(expected = UnsupportedOperationException.class)
	public void testParkVehicle_underground_pakingLot_full() {
		carPark= new ParkingLot<>("", 2, 1);
		carPark.parkVehicle(new MockVehicle());
		carPark.parkVehicle(new MockVehicle());
		carPark.parkVehicle(new MockVehicle());
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testRetrieveVehicle_invalid_parkingTicket_standard(){
		carPark.retrieveVehicle(new ParkingTicket(-1, 1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRetrieveVehicle_invalid_floor_spot_standard() {
		ParkingTicket ticket = new ParkingTicket(0, 5);
		carPark.retrieveVehicle(ticket);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRetrieveVehicle_invalid_floor_standard() {
		ParkingTicket ticket = new ParkingTicket(5, 0);
		carPark.retrieveVehicle(ticket);
	}

	@Test
	public void testRetrieveVehicle_standard() {
		MockVehicle expected = new MockVehicle();
		ParkingTicket t = carPark.parkVehicle(expected);
		MockVehicle actual = carPark.retrieveVehicle(t);
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testRetrieveVehicle_invalid_parkingTicket_underground(){
		carPark = new ParkingLot<>("Underground", 2, 1);
		carPark.retrieveVehicle(new ParkingTicket(1, 1));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testRetrieveVehicle_invalid_floor_spot_underground() {
		carPark = new ParkingLot<>("Underground", 2, 1);
		ParkingTicket ticket = new ParkingTicket(0, 5);
		carPark.retrieveVehicle(ticket);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRetrieveVehicle_invalid_floor_underground() {
		carPark = new ParkingLot<>("Underground", 2, 1);
		ParkingTicket ticket = new ParkingTicket(-5, 0);
		carPark.retrieveVehicle(ticket);
	}

	@Test
	public void testRetrieveVehicle_underground() {
		carPark = new ParkingLot<>("Underground", 2, 1);
		MockVehicle expected = new MockVehicle();
		ParkingTicket t = carPark.parkVehicle(expected);
		MockVehicle actual = carPark.retrieveVehicle(t);
		Assert.assertEquals(expected, actual);
	}

}
