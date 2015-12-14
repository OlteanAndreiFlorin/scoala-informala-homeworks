package homework8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
	public void testParkVehicle_first_parking() {
		ParkingTiket expected = new ParkingTiket(0, 1);
		ParkingTiket actual = carPark.parkVehicle(new MockVehicle());
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testParkVehicle_pakingLot_full() {
		carPark.parkVehicle(new MockVehicle());
		carPark.parkVehicle(new MockVehicle());
		carPark.parkVehicle(new MockVehicle());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRetrieveVehicle_invalid_floor_spot() {
		ParkingTiket ticket = new ParkingTiket(0, 5);
		carPark.retrieveVehicle(ticket);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRetrieveVehicle_invalid_floor() {
		ParkingTiket ticket = new ParkingTiket(5, 0);
		carPark.retrieveVehicle(ticket);
	}

	@Test
	public void testRetrieveVehicle() {
		MockVehicle expected = new MockVehicle();
		ParkingTiket t = carPark.parkVehicle(expected);
		MockVehicle actual = carPark.retrieveVehicle(t);
		Assert.assertEquals(expected, actual);
	}

}
