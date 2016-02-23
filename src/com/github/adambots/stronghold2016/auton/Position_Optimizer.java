package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Actuators;

import com.github.adambots.stronghold2016.drive.Drive;

public class Position_Optimizer {
	// lets see
	public Position_Optimizer(){
		
	}
public void rightClassCode(double turnamountL,double turnamountR,double driveDistance, double finishDistance){
	double turned  = Actuators.getLeftDriveMotor().getError();
	double inPosition  = Actuators.getLeftDriveMotor().getError();
	double turned2  = Actuators.getLeftDriveMotor().getError();
	
	double inPosAbs=Math.abs(inPosition);
	double turnAbs1=Math.abs(turned);
	double turnAbs2=Math.abs(turned2);
	if (turnAbs1 < 100)
		Drive.drive(Actuators.STOP_MOTOR);
	else{
		Drive.driveWithPID(turnamountL, -turnamountR);
	}	
	if (inPosAbs > 100 && turnAbs1 < 100)
		Drive.driveWithPID(driveDistance, driveDistance);
	else{
		Drive.drive(Actuators.STOP_MOTOR);
	}

	if (inPosAbs < 100 && turnAbs2 > 100)
		Drive.driveWithPID(-turnamountL, turnamountR);
	else{
		Drive.drive(Actuators.STOP_MOTOR);
	}
	if (inPosAbs < 100 && turnAbs2 < 100)
		Drive.driveWithPID(finishDistance, finishDistance);
	else{
		Drive.drive(Actuators.STOP_MOTOR);
	}
	
}
public void leftClassCode(double turnamountL,double turnamountR,double driveDistance, double finishDistance){
	double turned  = Actuators.getLeftDriveMotor().getError();
	double inPosition  = Actuators.getLeftDriveMotor().getError();
	double turned2  = Actuators.getLeftDriveMotor().getError();
	
	double inPosAbs=Math.abs(inPosition);
	double turnAbs1=Math.abs(turned);
	double turnAbs2=Math.abs(turned2);
	if (turnAbs1 < 100)
		Drive.drive(Actuators.STOP_MOTOR);
	else{
		Drive.driveWithPID(-turnamountL, turnamountR);
	}	
	if (inPosAbs > 100 && turnAbs1 < 100)
		Drive.driveWithPID(driveDistance, driveDistance);
	else{
		Drive.drive(Actuators.STOP_MOTOR);
	}

	if (inPosAbs < 100 && turnAbs2 > 100)
		Drive.driveWithPID(turnamountL, -turnamountR);
	else{
		Drive.drive(Actuators.STOP_MOTOR);
	}
	if (inPosAbs < 100 && turnAbs2 < 100)
		Drive.driveWithPID(finishDistance, finishDistance);
	else{
		Drive.drive(Actuators.STOP_MOTOR);
	}
}
public void forwardClassCode(double finishDistance){
	double done = Actuators.getLeftDriveMotor().getError();
	double doneAbs= Math.abs(done);
	if(doneAbs > 100)
	Drive.driveWithPID(finishDistance, finishDistance);
	if(doneAbs < 100){
		Drive.drive(Actuators.STOP_MOTOR);
		
	}
}
}
