package ro.sci.java_dev.homework8.parking;

import ro.sci.java_dev.homework8.vehicles.Car;
import ro.sci.java_dev.homework8.vehicles.Elise;
import ro.sci.java_dev.homework8.vehicles.Vehicle;

public class Main {

	public static void main(String[] args) {
		ValetParking<Vehicle> carPark1=new ValetParking<>();
		System.out.println(carPark1);
		ValetParking<Vehicle> carPark = new ValetParking<>(1,45);
		System.out.println(carPark);
	}

}
