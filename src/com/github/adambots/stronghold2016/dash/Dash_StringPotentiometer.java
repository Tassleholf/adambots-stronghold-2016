package com.github.adambots.stronghold2016.dash;

import org.usfirst.frc.team245.robot.Actuators;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dash_StringPotentiometer {
	public static void stringPotDash(){
		SmartDashboard.putString("StringPot position", Double.toString(Actuators.getArmAngleMotor().getPosition()));
	}
}
