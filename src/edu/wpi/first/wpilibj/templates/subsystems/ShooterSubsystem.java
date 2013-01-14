/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author SEVERHAL2014
 */
public class ShooterSubsystem extends Subsystem implements PIDOutput {
    private Jaguar topMotor;
    private Jaguar bottomMotor;
    Encoder topEncoder;
    Encoder bottomEncoder;
    PIDController topSpeedControl;
    PIDController bottomSpeedControl;
    
    public ShooterSubsystem() {
        topMotor = new Jaguar(RobotMap.SHOOTER_MOTOR_PORT1);
        bottomMotor = new Jaguar(RobotMap.SHOOTER_MOTOR_PORT2);
        topEncoder = new Encoder(RobotMap.TOP_ENCODER_A, RobotMap.TOP_ENCODER_B);
        bottomEncoder = new Encoder(RobotMap.BOTTOM_ENCODER_A, RobotMap.BOTTOM_ENCODER_B);
        topSpeedControl = new PIDController(0, 0, 0, topEncoder, topMotor); //initialize a PIDController for each shooter wheel.
        bottomSpeedControl = new PIDController(0, 0, 0, bottomEncoder, bottomMotor); //fill in kp ki and kd values later
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(double speed) {
        topSpeedControl.setSetpoint(speed);
        bottomSpeedControl.setSetpoint(speed);
    }
    public void pidWrite(double e) {
        set(e);
    }
    public boolean isUpToSpeed() {
        return (topSpeedControl.onTarget() && bottomSpeedControl.onTarget());
    }
}
