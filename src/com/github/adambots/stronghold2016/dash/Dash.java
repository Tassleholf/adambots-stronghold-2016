package com.github.adambots.stronghold2016.dash;

import org.usfirst.frc.team245.robot.Actuators;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dash {
public void dioMode(){
	
}
public  void driveMode(){
	SmartDashboard.putString("Encoder Front Right", TalonDio.talonEncodDio(Actuators.getRightDriveMotor()));
	SmartDashboard.putString("Encoder Front Left", TalonDio.talonEncodDio(Actuators.getLeftDriveMotor()));
	SmartDashboard.putBoolean("Right Front Talon", TalonDio.talonConectionDio(Actuators.getRightDriveMotor()));
	SmartDashboard.putBoolean("Left Front Talon", TalonDio.talonConectionDio(Actuators.getLeftDriveMotor()));
	SmartDashboard.putBoolean("Right Rear Talon", TalonDio.talonConectionDio(Actuators.getRightDriveMotor2()));
	SmartDashboard.putBoolean("Left Rear Talon", TalonDio.talonConectionDio(Actuators.getLeftDriveMotor2()));
	
}
public static void show(){
	
}
}
