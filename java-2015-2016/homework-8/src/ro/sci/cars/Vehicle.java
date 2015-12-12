package ro.sci.cars;
/**
 * Implements a interface for all cars that implement it;
 * @author Oltean Andrei-Florin
 *
 */
public interface Vehicle {

	void start();

	void drive(double tripLength);

	void stop();

}
