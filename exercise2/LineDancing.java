package exercise2;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import lejos.nxt.LightSensor;

public class LineDancing {

	private LightSensorListener leftListener;
	private LightSensorListener rightListener;
	private CastorBotLineFollow robot;
	private final static int ROTATION_CONSTANT = 10;

	// Takes in a CastorBotLineFollow which is a robot with two light sensors on
	// it as a parameter
	public LineDancing(CastorBotLineFollow robot) {

		// Listeners are declared now because they are specific to the task.
		this.robot = robot;
		leftListener = new LightSensorListener(LightSensorListener.LEFT, this);
		rightListener = new LightSensorListener(LightSensorListener.RIGHT, this);
		robot.getLeftPort().addSensorPortListener(leftListener);
		robot.getRightPort().addSensorPortListener(rightListener);
	}

	public void run() {

		robot.getRight().setFloodlight(true);
		robot.getLeft().setFloodlight(true);
		robot.getPilot().setTravelSpeed(robot.getPilot().getMaxTravelSpeed());
		while (true) {
			while (!(leftListener.adjusting() || rightListener.adjusting())) {
				robot.getPilot().travel(10, true);
				Thread.yield();
			}

		}

	}

	/**
	 * 
	 * @param side
	 *            the side the light sensor is on TRUE is RIGHT. FALSE is LEFT
	 */
	public void adjustPosition(boolean side) {
		if (side) {// If right hand side
			robot.getPilot().rotate(-ROTATION_CONSTANT);
		} else {// If left hand side
			robot.getPilot().rotate(ROTATION_CONSTANT);
		}
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Configuration config = new WHEATLEYCONFIG();
		CastorBotLineFollow robot = new CastorBotLineFollow(config,
				SensorPort.S4, SensorPort.S2);
		Button.waitForAnyPress();
		LineDancing demo = new LineDancing(robot);
		demo.run();
	}
}
