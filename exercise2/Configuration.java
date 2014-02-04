package exercise2;

import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTRegulatedMotor;

public interface Configuration {

	public int getLength();
	public int getWheelBase();
	public int getDiameter();
	public int getWheelDiameter();
	public NXTRegulatedMotor getLeftMotor();
	public NXTRegulatedMotor getRightMotor();
	
}
