import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import lejos.nxt.LightSensor;

public class LineDancing {

	private LightSensor left;
	private LightSensor right;
	private DifferentialPilot pilot;
	private SensorPort rightSensor;
	private SensorPort leftSensor;

	public LineDancing(LightSensor left, LightSensor right,
			SensorPort leftLightPort, SensorPort rightLightPort,
			DifferentialPilot pilot) {
		super();
		this.left = left;
		this.right = right;
		this.pilot = pilot;
		this.rightSensor = rightLightPort;
		this.leftSensor = leftLightPort;

		LightSensorListener leftListener = new LightSensorListener(pilot, false);
		LightSensorListener rightListener = new LightSensorListener(pilot, true);
		rightSensor.addSensorPortListener(rightListener);
		leftSensor.addSensorPortListener(leftListener);
	}

	public void run() {

		while (true) {

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DifferentialPilot pilot = new DifferentialPilot(5.6, 12.9, Motor.C,
				Motor.B);
		SensorPort rightPort = SensorPort.S1;
		SensorPort leftPort = SensorPort.S2;
		LineDancing demo = new LineDancing(new LightSensor(leftPort),
				new LightSensor(rightPort), leftPort, rightPort, pilot);
		demo.run();

	}
}
