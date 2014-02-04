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

	//Takes in a CastorBotLineFollow which is a robot with two light sensors on it as a parameter
	public LineDancing(CastorBotLineFollow robot){
		
		//Listeners are declared now because they are specific to the task.
		this.robot = robot;
		leftListener = new LightSensorListener(robot.getPilot(),LightSensorListener.LEFT);
		rightListener = new LightSensorListener(robot.getPilot(),LightSensorListener.RIGHT);
		robot.getLeftPort().addSensorPortListener(leftListener);
		robot.getRightPort().addSensorPortListener(rightListener);
	}

	public void run() {

		while (true) {
			//Code for movement in here
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Configuration config = new WHEATLEYCONFIG();
		CastorBotLineFollow robot = new CastorBotLineFollow(config,SensorPort.S1,SensorPort.S2);
		Button.waitForAnyPress();
		LineDancing demo = new LineDancing(robot);
	}
}
