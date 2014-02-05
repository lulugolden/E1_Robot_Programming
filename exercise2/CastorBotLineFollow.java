package exercise2;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Extension of the castorbot setup for a robot with two lightsensors on either side of the robot (left and right)
 * @author david
 *
 */


public class CastorBotLineFollow extends CastorBot{

	
	private LightSensor leftSensor;
	private LightSensor rightSensor;
	private SensorPort leftLocation;
	private SensorPort rightLocation;
	
	public CastorBotLineFollow(Configuration config, SensorPort leftPort, SensorPort rightPort) {
		super(config);
		leftLocation = leftPort; 
		rightLocation = rightPort;		
		leftSensor = new LightSensor(leftLocation);
		rightSensor = new LightSensor(rightLocation);
		
	}

	/**
	 * Method returns the light sensor on the left hand side of the robot
	 * @return The light sensor on the left side of the robot
	 */
	public LightSensor getLeft()
	{
		return leftSensor;
	}
	
	/**
	 * Method returns the light sensor on the left hand side of the robot
	 * @return The light sensor on the right side of the robot
	 */
	public LightSensor getRight()
	{
		return rightSensor;
	}
	
	/**
	 * Method returns the sensor port the left hand light sensor is connected to
	 * @return The sensor port the left hand light sensor is connected to.
	 */
	public SensorPort getLeftPort()
	{
		return leftLocation;
	}
	
	/**
	 * Method returns the sensor port the right hand light sensor is connected to
	 * @return The sensor port the right hand light sensor is connected to.
	 */
	public SensorPort getRightPort()
	{
		return rightLocation;
	}
	
	
}
