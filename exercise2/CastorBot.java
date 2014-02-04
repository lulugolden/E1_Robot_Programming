package exercise2;

import lejos.robotics.navigation.DifferentialPilot;

public class CastorBot  {

	private DifferentialPilot pilot;
	private Configuration config;

	public CastorBot(Configuration config) {
		this.config = config;
		pilot = new DifferentialPilot(config.getWheelDiameter(),
				config.getWheelBase(), config.getLeftMotor(),
				config.getRightMotor());
		
		
	}

	
	public DifferentialPilot getPilot()
	{
		return pilot;
	}
	
	public Configuration getConfig()
	{
		return config;
	}
	
}
