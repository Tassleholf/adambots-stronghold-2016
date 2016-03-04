package com.github.adambots.stronghold2016.arm;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

/**
 * All arm code
 *
 */
public class Arm {
	static double MAX_ARM_POSITION = 5;
	static double MIN_ARM_POSITION = 3;
	
	/**
	 * Initializes arm
	 */
	public static void init() {
		Actuators.getWinchRatchetPneumatic().set(false);
	}

	private static boolean released = false;

	/**
	 * Runs intake
	 * 
	 * @param intake
	 * @param putout
	 */
	public static void rollers(boolean intake, boolean putout) {
		if (intake == putout) {
			Actuators.getBoulderIntakeMotor().set(0);
		} else if (intake == true) {
			Actuators.getBoulderIntakeMotor().set(Actuators.MAX_MOTOR_SPEED);
		} else if (putout == true) {
			Actuators.getBoulderIntakeMotor().set(Actuators.MIN_MOTOR_SPEED);
		}

	}

	/**
	 * moves arm within range
	 * 
	 * @param speed
	 */
	public static void moveArm(double speed) {
		speed = -speed;
		if ((Actuators.getArmAngleMotor().getPosition() > MAX_ARM_POSITION || Sensors.getArmMaxLimitSwitch().get()) && speed > 0) {
			Actuators.getArmAngleMotor().set(speed);
		} else if ((Actuators.getArmAngleMotor().getPosition() < MIN_ARM_POSITION || Sensors.getArmMinLimitSwitch().get()) && speed < 0) {
			Actuators.getArmAngleMotor().set(speed);
		} else {
			Actuators.getArmAngleMotor().set(Actuators.STOP_MOTOR);

		}
	}

	/**
	 * Runs winch to climb
	 * 
	 * @param button
	 */
	public static void climb(boolean button) {
		if (!Actuators.getWinchRatchetPneumatic().get() && button) {
			Actuators.getWinchRatchetPneumatic().set(true);
			Actuators.getArmWinchMotor1().set(Actuators.MAX_MOTOR_SPEED);
			Actuators.getArmWinchMotor2().set(Actuators.MAX_MOTOR_SPEED);
		} else if (Actuators.getWinchRatchetPneumatic().get() && button) {
			Actuators.getArmWinchMotor1().set(Actuators.MAX_MOTOR_SPEED);
			Actuators.getArmWinchMotor2().set(Actuators.MAX_MOTOR_SPEED);
		} else {
			Actuators.getArmWinchMotor1().set(Actuators.STOP_MOTOR);
			Actuators.getArmWinchMotor2().set(Actuators.STOP_MOTOR);
			Actuators.getWinchRatchetPneumatic().set(false);
		}
	}

}
