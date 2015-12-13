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
		ParkingTiket expected = new ParkingTiket(0, 0);
		ParkingTiket actual = carPark.parkVehicle(new MockVehicle());
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testParkVehicle_pakingLot_full() {
		carPark.parkVehicle(new MockVehicle());
		carPark.parkVehicle(new MockVehicle());
		carPark.parkVehicle(new MockVehicle());
	}
}
