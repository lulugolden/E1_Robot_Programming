package exercise2;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.robotics.RangeFinder;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class Distance {

	private final RangeFinder rFinder;
	private final DifferentialPilot pilot;
	private final static float STATIC_POINT = 200;
	private static final float MAX_RANGE = 800;
	private int travelDirection = 1;
	private final static int FORWARDS = 1;
	private final static int BACKWARDS = -1;
	private final static int STATIONARY = 0;
	private final static double movementTime = 0.25;

	public Distance(RangeFinder rFinder, DifferentialPilot pilot) {
		this.rFinder = rFinder;
		this.pilot = pilot;
	}

	public void run() {
		Sound.setVolume(Sound.VOL_MAX);

		double speed = 0;
		int delayMS = 150;

		while (true) {
			pilot.setTravelSpeed(Math.abs(speed));
			pilot.travel(speed * movementTime, true);
			Delay.msDelay(delayMS);
			Thread.yield();
			float reading = 10* rFinder.getRange();
			float error = reading - STATIC_POINT;
			System.out.println(error);
			speed = (0.2f * error);
			
			
			
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Button.waitForAnyPress();
		Distance distance = new Distance(new OpticalDistanceSensor(
				SensorPort.S1), new DifferentialPilot(5.6, 12.9, Motor.C,
				Motor.B));
		distance.run();
	}
}
