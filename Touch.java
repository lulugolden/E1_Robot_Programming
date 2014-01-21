import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import lejos.nxt.Button;

public class Touch {
	public static void main(String[] args) throws Exception {

		TouchSensor touch = new TouchSensor(SensorPort.S1);
		DifferentialPilot pilot = new DifferentialPilot(2.1f, 2.1f, Motor.B, Motor.C, false);

		boolean buttonPressed = false;

		while(true){
		//buttonPressed = Button.isDown();	

			while (!touch.isPressed()) {

				pilot.forward();


			}
		if(touch.isPressed())
		{
			pilot.rotate(180);
		}
		}
		//LCD.drawString("Finished", 3, 4);

	}
}
