package ro.sci.java_dev.homework8.parking;

import ro.sci.java_dev.homework8.other.Boat;
import ro.sci.java_dev.homework8.other.Choppa;
import ro.sci.java_dev.homework8.other.MyHorse;
import ro.sci.java_dev.homework8.other.SiegeTank;
import ro.sci.java_dev.homework8.other.Tank;
import ro.sci.java_dev.homework8.vehicles.*;
/**
 * Just playing around with my classes
 * @author oltea
 *
 */
public class Main {

	public static void main(String[] args) {

		ValetParking<Tank> tankPark = new ValetParking<>("Underground", 5, 30);
		Tank tank = new SiegeTank(120);
		useTheLots(tankPark, tank);

		ValetParking<MyHorse> myHorsePark = new ValetParking<>(1, 45);
		MyHorse myHorse = new MyHorse(12);
		useTheLots(myHorsePark, myHorse);

		ValetParking<Car> carPark = new ValetParking<>(1, 46);
		Car car = new Elise(20, "elise");
		useTheLots(carPark, car);
		
		ValetParking<Choppa> choppaPark = new ValetParking<>("Standard", 1, 45);
		Choppa choppa = new Choppa(200);
		useTheLots(choppaPark, choppa);

		ValetParking<Vehicle> vehiclePark = new ValetParking<>();
		Vehicle teslaS = new ModelS(75, "chassisNumber");
		vehiclePark.parkVehicle(car);
		vehiclePark.parkVehicle(choppa);
		useTheLots(vehiclePark, teslaS);

		// ValletParking<Boat>... will not work (compilation error) even if the
		// boat class has the same methods than any other class that implements
		// Vehicle but we can create a Parking lot for it

		ParkingLot<Boat> harbour = new ParkingLot<>(1, 100);// you will still
															// get a parking
															// ticket when the
															// boat is "parked"
															// but there will
															// not be any valet
															// to park it for
															// you :P

	}

	public static <T extends Vehicle> void useTheLots(ValetParking<T> lot, T vehicle) {
		float amountOfFuelBeforeParking = vehicle.getAvailableFuel();
		ParkingTicket ticket = lot.parkVehicle(vehicle);
		float amountOfFuelAfterParking = vehicle.getAvailableFuel();
		vehicle = lot.retrieveVehicle(ticket);

		System.out.println(amountOfFuelBeforeParking + " and after " + amountOfFuelAfterParking);
		System.out.println();
	}

}
