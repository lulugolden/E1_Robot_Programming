package exercise2;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.robotics.RangeFinder;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

/**
 * Makes the robot move using proportional feedback to be within a certain
 * distance of an object in front of.
 * 
 * @author E1
 * 
 */
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

	/**
	 * Constructor, creates an instance of this class
	 * 
	 * @param rFinder
	 *            a range finder (Infrared) attached to the robot
	 * @param pilot
	 *            Differential pilot to allow movement
	 */
	public Distance(RangeFinder rFinder, DifferentialPilot pilot) {
		this.rFinder = rFinder;
		this.pilot = pilot;
	}

	/**
	 * Method executes the desired behavior of this program. In an infinite loop
	 * (Meaning program must be terminated by button press) this method makes
	 * the robot travel at a speed dependent upon its distance from the wall and
	 * maintain a set distance from it by updating its status on every iteration
	 * of the loop. Travel continues for a set amount of time based on SUVAT
	 * equations
	 * 
	 */
	public void run() {
		Sound.setVolume(Sound.VOL_MAX);

		double speed = 0;
		int delayMS = 150;

		while (true) {
			pilot.setTravelSpeed(Math.abs(speed));
			pilot.travel(speed * movementTime, true);
			Delay.msDelay(delayMS);
			Thread.yield();
			float reading = 10 * rFinder.getRange();
			float error = reading - STATIC_POINT;
			System.out.println(error);
			speed = (0.2f * error);

		}
	}

	/**
	 * Main method, used when program is executed which instantiates required
	 * objects and then calls the run method to start the robots desired
	 * behaviour
	 * 
	 * @param args Main method arguments.
	 */
	public static void main(String[] args) {

		Button.waitForAnyPress();
		Distance distance = new Distance(new OpticalDistanceSensor(
				SensorPort.S1), new DifferentialPilot(5.6, 12.9, Motor.C,
				Motor.B));
		distance.run();
	}
}
