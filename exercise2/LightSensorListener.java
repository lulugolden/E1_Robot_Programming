package exercise2;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.robotics.navigation.DifferentialPilot;

public class LightSensorListener implements SensorPortListener {

	private DifferentialPilot pilot;
	private boolean side;
	public static final boolean LEFT = false;
	public static final boolean RIGHT = true;

	/**
	 * 
	 * @param pilot
	 *            The differential pilot that is being used to move the robot
	 * @param side
	 *            Boolean value that represents what side light sensor the
	 *            listener is being put onto. TRUE is RIGHT. FALSE is LEFT
	 *            though use of the class constants is 0
	 * 
	 */
	public LightSensorListener(DifferentialPilot pilot, boolean side) {
		this.pilot = pilot;
		this.side = side;
	}

	@Override
	public void stateChanged(SensorPort aSource, int aOldValue, int aNewValue) {
		System.out.println(aNewValue);
		// if(//VALUES FOR THRESHOLD)
		{
			// DO the correct turn.
		}

	}
}
