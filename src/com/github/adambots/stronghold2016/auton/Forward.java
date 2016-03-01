package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.stronghold2016.drive.Drive;

public class Forward {
	static double finishDistance = -48, allotedError = 60;
	static boolean reset = false, isDone;

	//Position_Optimizer optimizer;

	//public Forward() {
		//optimizer = new Position_Optimizer();
	//}

	public Forward() {}
	public static void go() {
		//optimizer.forwardClassCode(finishDistance);
		
		  //double done = Actuators.getLeftDriveMotor().getError(); 
		  
			  Drive.driveWithPID(finishDistance, finishDistance);
		  
		  
		  }
	public static boolean go (double driveDistance1) {
		Drive.driveWithPID(driveDistance1, driveDistance1);
/*if(Math.abs(Actuators.getLeftDriveMotor().getError()) <allotedError || Math.abs(Actuators.getRightDriveMotor().getError()) < allotedError) {
			
			reset = true;
		}
			if(reset==true){
				Actuators.getLeftDriveMotor().setEncPosition(0);
				Actuators.getRightDriveMotor().setEncPosition(0);
				reset=false;
				isDone=true;
*/			
		return isDone;
	}
		 

	}


