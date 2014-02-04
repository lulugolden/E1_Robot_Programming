import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.Button;

public class Movement {


	public static void main(String[] args){
		
		Button.waitForAnyPress();
		DifferentialPilot pilot = new DifferentialPilot(2.1f, 2.1f, Motor.B, Motor.C, false);
		//change wheel size
		pilot.travel(40);
		pilot.rotate(-90);
		pilot.travel(40);
		pilot.rotate(-90);
		pilot.travel(40);
		pilot.rotate(-90);
		pilot.travel(40);
		pilot.rotate(-90);
	}
}
