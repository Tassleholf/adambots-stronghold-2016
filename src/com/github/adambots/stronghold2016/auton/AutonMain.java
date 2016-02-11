package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Actuators;

import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonMain {
	private static final float NOMINAL_REVERSE_VOLTAGE = -0f;
	private static final float NOMINAL_FORWARD_VOLTAGE = +0f;
	private static final int ACCEPTABLE_ERROR = 0;
	private static final float PEAK_REVERSE_VOLTAGE = -12f;
	private static final float PEAK_FORWARD_VOLTAGE = +12f;
	private static final int CODES_PER_REV = 720;

	public static void init(){
		Actuators.getLeftDriveMotor().reset();
		Actuators.getLeftDriveMotor().enableZeroSensorPositionOnIndex(true, true);
		Actuators.getLeftDriveMotor().setPosition(0);
		Actuators.getLeftDriveMotor().setFeedbackDevice(FeedbackDevice.QuadEncoder);
		Actuators.getLeftDriveMotor().reverseSensor(true);
		
		Actuators.getLeftDriveMotor().configEncoderCodesPerRev(CODES_PER_REV);
		
		Actuators.getLeftDriveMotor().configNominalOutputVoltage(NOMINAL_FORWARD_VOLTAGE, NOMINAL_REVERSE_VOLTAGE);
		Actuators.getLeftDriveMotor().configPeakOutputVoltage(PEAK_FORWARD_VOLTAGE, PEAK_REVERSE_VOLTAGE);
		
		Actuators.getLeftDriveMotor().setAllowableClosedLoopErr(ACCEPTABLE_ERROR);
		Actuators.getLeftDriveMotor().setPID(0.1, 0, 0);
		
		
		
	}
	
	public static void test(){
		SmartDashboard.putNumber("ERROR", Actuators.getLeftDriveMotor().getError());
		Actuators.getLeftDriveMotor().changeControlMode(TalonControlMode.Position);
		final int testTarget = 1;
		Actuators.getLeftDriveMotor().set(testTarget);
		Actuators.getLeftDriveMotor().enable();
		
	}
}
