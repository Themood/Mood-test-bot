
package org.usfirst.frc.team4183.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4183.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */
public class Drive extends Subsystem {
	private double wheelTrack_m;
	private CANTalon leftMotor0;
	private CANTalon leftMotor1;
	private CANTalon rightMotor0;
	private CANTalon rightMotor1;
	private RobotDrive robotDrive;
	public Drive(double awheelTrack_M){
	wheelTrack_m = awheelTrack_M;
	leftMotor0 = new CANTalon(RobotMap.leftMotor0);
	leftMotor1 = new CANTalon(RobotMap.leftMotor1);
	rightMotor0 = new CANTalon(RobotMap.rightMotor0);
	rightMotor1 = new CANTalon(RobotMap.rightMotor1);
	robotDrive = new RobotDrive(leftMotor0, leftMotor1, rightMotor0, rightMotor1);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void archadeDrive(double speed, double turn){
    	robotDrive.arcadeDrive(speed, turn);
    }
    public void tankDrive(double leftStick, double rightStick){
    	robotDrive.tankDrive(leftStick, rightStick);
    }
    public void autoDrive(double speedCoefficient, double radius_m){
    	if (wheelTrack_m !=0.0){
    		robotDrive.drive(speedCoefficient, Math.exp(-radius_m / wheelTrack_m));
    	}
    }
    
    }




