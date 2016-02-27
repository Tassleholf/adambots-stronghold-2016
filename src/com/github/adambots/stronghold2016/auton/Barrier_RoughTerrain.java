package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.stronghold2016.drive.Drive;

public class Barrier_RoughTerrain extends Barrier {
	char cat;
	static double finishDistance = -200;
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

		 Drive.driveWithPID(finishDistance, finishDistance);
		  
	}
}