
package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.Compressor;
import com.github.adambots.stronghold2016.arm.Arm;

import com.github.adambots.stronghold2016.auton.Barrier_ChevalDeFrise;
import com.github.adambots.stronghold2016.auton.Barrier_Drawbridge;
import com.github.adambots.stronghold2016.auton.Barrier_RoughTerrain;

import com.github.adambots.stronghold2016.auton.AutonMain;

import com.github.adambots.stronghold2016.camera.AutoTarget;
import com.github.adambots.stronghold2016.camera.Target;

import com.github.adambots.stronghold2016.drive.Drive;
import com.github.adambots.stronghold2016.shooter.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team245.robot.Gamepad;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;
	SendableChooser chooser;
	Compressor compressor;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		chooser = new SendableChooser();
		compressor = new Compressor();
		//TODO: Uncomment inits
		//Sensors.init();
		//Shooter.init();
		Drive.init();//does not have anything
		Actuators.init();
		//AutoTarget.init();//does not contain anything
		


		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);


		chooser.addObject("ChevalDeFrise", new Barrier_ChevalDeFrise() );
		chooser.addObject("Drawbridge", new Barrier_Drawbridge() );
		chooser.addObject("RoughTerrain", new Barrier_RoughTerrain() );

		Actuators.init();


	}
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings commands.
	 */
	public void autonomousInit() {
		autonomousCommand = (Command) chooser.getSelected();
		Actuators.teleopInit();
		
		 String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 switch(autoSelected) {
		 	case "My Auto": 
		 		//autonomousCommand = new MyAutoCommand(); 
		 		break;
		 		case "Default Auto":
		 			
		 		default:
		 			//autonomousCommand = new ExampleCommand(); 
		 			break;
		}
		 

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		AutonMain.test();

	}

	private boolean pastShift;
	
	public void teleopInit() {
		
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		//Arm.init();
		pastShift = false;
		

		 	
		 Actuators.teleopInit();
	}

	/**
	 * This function is called periodically during operator control
	 */
	
	public void teleopPeriodic() {
		
			
		
		Drive.drive(Gamepad.primary.getTriggers(), Gamepad.primary.getLeftX());
		
		if(Gamepad.primary.getLB() && pastShift == false){
			Drive.shift();
			pastShift = Gamepad.primary.getLB();
		}else if(!Gamepad.primary.getLB()){
			pastShift = Gamepad.primary.getLB();
		}
		
//		Shooter.shoot(Gamepad.primary.getRB()); //TODO: Needs to be tested
//		Scheduler.getInstance().run();
//TODO: TEST ARM CODE
//		Arm.moveArm(Gamepad.secondary.getRightY());
//
//		Arm.rollers(Gamepad.primary.getA(), Gamepad.primary.getB());
//
//		Arm.climb(Gamepad.secondary.getX());

		
		

		//TEST CODE *****************************************************************

		//***************************************************************************
//		if(Gamepad.primary.getRB()){
//			//if using PID in CANTalons
//			//Shooter.loadShooter();
//			//if using PID class on roborio
//			isShooterLoaded = Shooter.loadShooter(0);
//		}else if(!isShooterLoaded){
//			isShooterLoaded = Shooter.loadShooter(0);
//		}
//		else{
//			Shooter.stopLoadShooter();
//		}
		

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
