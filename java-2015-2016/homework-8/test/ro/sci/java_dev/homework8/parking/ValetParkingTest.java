package ro.sci.java_dev.homework8.parking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ro.sci.java_dev.homework8.vehicles.Vehicle;

public class ValetParkingTest {

	ValetParking<MockVehicle> valet;

	@Before
	public void setUp() {
		valet = new ValetParking<>();
	}

	class MockVehicle implements Vehicle {

		private float fuel;

		/**
		 * @param fuel
		 */
		public MockVehicle(float fuel) {
			this.fuel = fuel;
		}

		@Override
		public void start() {

		}

		@Override
		public void drive(double tripLength) {
			this.fuel -= 0.2f;
			if (this.fuel <= 0) {
				throw new RuntimeException("No more fuel");
			}
		}

		@Override
		public void stop() {

		}

		@Override
		public float getAvailableFuel() {
			// TODO Auto-generated method stub
			return fuel;
		}

	}

	@Test
	public void testParkVehicle_normal_flow() {
		MockVehicle testCar = new MockVehicle(1);
		ParkingTicket actual = valet.parkVehicle(testCar);
		ParkingTicket expected = new ParkingTicket(0, 1);
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = RuntimeException.class)
	public void testParkVehicle_no_more_fuel() {
		MockVehicle testCar = new MockVehicle(0.1f);
		valet.parkVehicle(testCar);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testParkVehicle_full_lot() {
		for (int i = 0; i < 101; i++) {
			valet.parkVehicle(new MockVehicle(1));
		}

	}

	@Test
	public void testRetrieveVehicle_no_car_found() {
		Assert.assertNull(valet.retrieveVehicle(new ParkingTicket(2, 4)));
	}

	@Test
	public void testRetrieveVehicle_normal_flow() {
		MockVehicle expected = new MockVehicle(5);
		ParkingTicket ticket = valet.parkVehicle(expected);
		MockVehicle actual = valet.retrieveVehicle(ticket);
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRetrieveVehicle_illegal_ticket() {
		ParkingTicket ticket = new ParkingTicket(-7, 2);
		valet.retrieveVehicle(ticket);
	}

	@Test(expected = RuntimeException.class)
	public void testRetrieveVehicle_no_more_gas() {
		MockVehicle vehicle = new MockVehicle(.3f);// it will drive to the
													// lot(-0.2l of fuel) than
													// back(need0.2l of fuel)
		ParkingTicket t = valet.parkVehicle(vehicle);
		valet.retrieveVehicle(t);
	}
}
