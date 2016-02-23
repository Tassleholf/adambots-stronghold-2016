package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.stronghold2016.drive.Drive;

public class Barrier_RoughTerrain extends Barrier {
	char cat;
	int catNum;
	int crossDistance;
	boolean crossed;

	public Barrier_RoughTerrain() {
		super();
		cat = 'B';
		catNum = 1;
		crossDistance = 30;
		crossed = false;

	}

	public void go() {

		double leftError = Actuators.getLeftDriveMotor().getError();
		leftError = Math.abs(leftError);
		double rightError = Actuators.getRightDriveMotor().getError();
		rightError = Math.abs(rightError);
		crossed = rightError < 100 && leftError < 100;
		if (crossed == false) {
			Drive.driveWithPID(crossDistance, crossDistance);
		} else {
			Drive.drive(Actuators.STOP_MOTOR);
			crossed = true;
		}
	}
}