package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.stronghold2016.arm.Arm;
import com.github.adambots.stronghold2016.drive.Drive;

public class Barrier_ChevalDeFrise extends Barrier {
	boolean raised; // is arm raised
	double distance; // distance from where this code takes over to the position
						// we need to be to lower the barrier
	boolean there; // are we at the distance
	boolean down; // is the arm lowered
	double crossingDistance; // distance required to complete the crossing from
								// position

	boolean crossed; // are we crossed

	public Barrier_ChevalDeFrise() {
		super();
		super.category = 'A';
		super.categoryNum = 2;
		raised = false;
		distance = 10;
		there = false;
		down = false;
		crossingDistance = 20;
		crossed = false;

	}

	public void go() {

		double leftError = Actuators.getLeftDriveMotor().getError();
		leftError = Math.abs(leftError);
		double rightError = Actuators.getRightDriveMotor().getError();
		rightError = Math.abs(rightError);
		there = rightError < 100 && leftError < 100;
		if (Sensors.getArmMaxLimitSwitch().get() == true) {
			raised = true;
			down = false;
		} else if (raised == false && down == false) {
			Arm.moveArm(1);

		}
		if (raised == true && there == false) {
			Drive.driveWithPID(distance, distance);

		} else {
			Drive.drive(Actuators.STOP_MOTOR);
			there = true;
		}
		if (Sensors.getArmMinLimitSwitch().get() == true) {
			down = true;

		} else if (there == true && down == false) {
			Arm.moveArm(-1);

		}
		leftError = Actuators.getLeftDriveMotor().getError();
		leftError = Math.abs(leftError);
		rightError = Actuators.getRightDriveMotor().getError();
		rightError = Math.abs(rightError);
		crossed = rightError < 100 && leftError < 100;
		if (down == true && crossed == false) {
			Drive.driveWithPID(crossingDistance, crossingDistance);
		} else {
			Drive.drive(Actuators.STOP_MOTOR);
			crossed = true;

		}
	}
}
