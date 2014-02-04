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

	
	private LightSensor left;
	private LightSensor right;
	private SensorPort leftLocation;
	private SensorPort rightLocation;
	
	public CastorBotLineFollow(Configuration config, SensorPort leftPort, SensorPort rightPort) {
		super(config);
		leftLocation = leftPort; 
		rightLocation = rightPort;		
		left = new LightSensor(leftLocation);
		right = new LightSensor(rightLocation);
		
	}

	public LightSensor getLeft()
	{
		return left;
	}
	
	public LightSensor getRight()
	{
		return right;
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
