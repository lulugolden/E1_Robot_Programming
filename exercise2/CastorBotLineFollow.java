package exercise2;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Extension of the castorbot setup for a robot with two lightsensors
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

	public LightSensor getLeft()
	{
		return leftSensor;
	}
	
	public LightSensor getRight()
	{
		return rightSensor;
	}
	
	public SensorPort getLeftPort()
	{
		return leftLocation;
	}
	
	public SensorPort getRightPort()
	{
		return rightLocation;
	}
	
	
}
