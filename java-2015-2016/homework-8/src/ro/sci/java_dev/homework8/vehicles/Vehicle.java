package ro.sci.java_dev.homework8.vehicles;
/**
 * Implements a interface for all cars that implement it;
 * @author Oltean Andrei-Florin
 *
 */
public interface Vehicle {

	void start();

	void drive(double tripLength);

	void stop();

	float getAvailableFuel();

}
