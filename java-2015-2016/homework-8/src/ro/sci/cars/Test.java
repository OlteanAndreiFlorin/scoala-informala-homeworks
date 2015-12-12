package ro.sci.cars;

public class Test {

	public static void main(String[] args) {
		Car car = new Elise(50,"ASD");
		car.start();
		car.shiftGear(1);
		car.drive(10);
		car.stop();
		System.out.println(car.calculatePollution());

	}

}
