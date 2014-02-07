package exercise2;

import java.util.ArrayList;
import java.util.Random;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;

public class GridNavigate extends LineDancing {

	private static final int UP = 0;
	private static final int RIGHT = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;
	private ArrayList<Integer> directions = new ArrayList<Integer>();
	private boolean repeatPattern;
	private int currentMovement = 0;
	private boolean randomise = false;
	private boolean junctionReached = false;

	public GridNavigate(CastorBotLineFollow robot, boolean repeat) {
		super(robot);
		repeatPattern = repeat;
	}

	// RIGHT is TRUE, FALSE is LEFT
	public void adjustPosition(boolean side) {
		if (side) {// If the right sensor has been called (too far to the left)
			if (!leftListener.adjusting()) {// If the left one is not adjusting
											// then we only need to correct
											// course
				robot.getPilot().rotate(-ROTATION_CONSTANT);
			} else {// Otherwise both of them have been called
				junctionReached();
			}
		}
		if (!side) {
			if (!rightListener.adjusting()) {
				robot.getPilot().rotate(ROTATION_CONSTANT);
			} else {// Otherwise both of them are called - junction
				junctionReached();
			}
		}

	}

	@Override
	public void run()
	{
		robot.getRight().setFloodlight(true);
		robot.getLeft().setFloodlight(true);
		robot.getPilot().setTravelSpeed(robot.getPilot().getMaxTravelSpeed());
		
		while(true){
			while(!junctionReached)
			{
				while (!(leftListener.adjusting() || rightListener.adjusting())){
							robot.getPilot().travel(10,true);
							Thread.yield();
						}
				Thread.yield();
				}
		}
		
	}

	private void junctionReached() {

		int turn = 0;
		junctionReached = true;

		if (currentMovement >= directions.size()) {
			if (repeatPattern) {
				currentMovement = 0;
			}

			else {
				randomise = true;
			}

		}

		if (randomise) {
			turn = (int) (Math.random() * 5);
		} else {
			turn = directions.get(currentMovement);
		}

		currentMovement++;
		robot.getPilot().rotate(90 * turn);
		junctionReached = true;

	}

	public static void main() {
		Configuration config = new WHEATLEYCONFIG();
		CastorBotLineFollow robot = new CastorBotLineFollow(config,
				SensorPort.S4, SensorPort.S2);
		Button.waitForAnyPress();
		GridNavigate demo = new GridNavigate(robot, true);
		demo.run();
	}

}
