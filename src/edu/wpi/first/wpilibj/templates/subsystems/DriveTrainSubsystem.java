/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Drive;

/**
 *
 * @author Administrator
 */
public class DriveTrainSubsystem extends Subsystem {
    private Jaguar leftMotor;
    private Jaguar rightMotor;
    public DriveTrainSubsystem() {
        leftMotor = new Jaguar(RobotMap.LEFT_MOTOR_PORT);
        rightMotor = new Jaguar(RobotMap.RIGHT_MOTOR_PORT);
    }
    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void tankDrive(double left, double right) {
        leftMotor.set(left);
        rightMotor.set(right);
    }
}
