package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.stronghold2016.drive.Drive;

public class Forward {
	static double finishDistance = 5;
	double done;
	public Forward(){

	}
	public void go(){
		done = Actuators.getLeftDriveMotor().getError();
		if(Math.abs(done) > 100)
		Drive.driveWithPID(finishDistance, finishDistance);
		if(Math.abs(done) < 100){
			Drive.drive(Actuators.STOP_MOTOR);
			
		}
			
	}

}
