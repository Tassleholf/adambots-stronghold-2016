package com.github.adambots.stronghold2016.auton;

import com.github.adambots.stronghold2016.drive.Drive;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

import com.github.adambots.stronghold2016.arm.Arm;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

public class Barrier_Drawbridge extends Barrier {
	boolean raised; // is arm raised
	double distance; // distance from where this code takes over to the position
						// we need to be to lower the drawbridge
	boolean there; // are we at the distance
	boolean down; // is the arm lowered
	double crossingDistance; // distance required to complete the crossing from
								// position after backing up
	boolean crossed; // are we crossed

	public Barrier_Drawbridge() {
		super();
		raised = false;
		distance = 10;
		there = false;
		down = false;
		crossingDistance = 20;
		crossed = false;
		super.category = 'C';
		super.categoryNum = 1;
	}

	public void go() {

		if (Sensors.getArmMaxLimitSwitch().get()) {
			raised = true;
		}
		if (!raised) {
			Arm.moveArm(1);
		}
		double leftError = Actuators.getLeftDriveMotor().getError();
		leftError = Math.abs(leftError);
		double rightError = Actuators.getRightDriveMotor().getError();
		rightError = Math.abs(rightError);
		there = rightError < 100 && leftError < 100;
		if (raised && !there) {
			Drive.driveWithPID(distance, distance);
		} else {
			Drive.drive(Actuators.STOP_MOTOR);
			there = true;
		}

		if (there && !down) {
			Arm.moveArm(-1);
		}
		if (Sensors.getArmMinLimitSwitch().get()) {
			down = true;

		}
		leftError = Actuators.getLeftDriveMotor().getError();
		leftError = Math.abs(leftError);
		rightError = Actuators.getRightDriveMotor().getError();
		rightError = Math.abs(rightError);
		crossed = rightError < 100 && leftError < 100;
		if (raised && !crossed) {
			Drive.driveWithPID(crossingDistance, crossingDistance);
		} else {
			Drive.drive(Actuators.STOP_MOTOR);
			crossed = true;
		}
		if (down && !crossed) {
			Drive.drive(1, 0);
		}

	}
}
