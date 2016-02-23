package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.stronghold2016.arm.Arm;
import com.github.adambots.stronghold2016.drive.Drive;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

public class Barrier_Porticullis extends Barrier {
	static int counter;
	static int clearanceTime = 20;// Susceptible to change
	static int armIncrement;

	public static void Porticullis(double raise, double speed) {
		boolean position = false;
		double tolerance = 0;
		if (position == false) {
			Drive.drive(speed);

		}
		if (position == true)
			if (Sensors.getStringPotArmAngle() < raise) {
				Arm.moveArm(armIncrement);// Arm speed may change
			} else {
				Drive.drive(speed);
				// needs positioning
				if (Sensors.getRobotGyro().getAngle() > -tolerance) {

				}
			}
		// needs positioning
		if (Sensors.getRobotGyro().getAngle() > -tolerance && Sensors.getRobotGyro().getAngle() < tolerance) {
			counter++;
			if (counter >= clearanceTime) {
				Drive.drive(speed);
			}
			if (counter >= clearanceTime && Sensors.getRobotGyro().getAngle() > -tolerance
					&& Sensors.getRobotGyro().getAngle() < tolerance) {
				if (Sensors.getArmMinLimitSwitch().get() == false) {
					Arm.moveArm(-armIncrement);// might need to change increment
				}
			}
		}

	}
}
