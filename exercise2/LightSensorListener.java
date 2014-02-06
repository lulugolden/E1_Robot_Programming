package exercise2;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.nxt.Sound;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class LightSensorListener implements SensorPortListener {

	private boolean side;
	public static final boolean LEFT = false;
	public static final boolean RIGHT = true;
	public final LineDancing demo;
	private boolean adjusting;
	public static final int THRESHOLD = 580;

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
	public LightSensorListener(boolean side, LineDancing demo) {
		this.side = side;
		this.demo = demo;
	}

	@Override
	public void stateChanged(SensorPort aSource, int aOldValue, int aNewValue) {

		if (!side) {
			aNewValue = aNewValue + 40;
		}
		if (aNewValue > THRESHOLD) {
			adjusting = true;
			demo.adjustPosition(side);
			adjusting = false;

		}

	}

	public boolean adjusting() {
		return adjusting;
	}

}
