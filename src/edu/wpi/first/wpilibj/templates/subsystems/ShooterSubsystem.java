/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author SEVERHAL2014
 */
public class ShooterSubsystem extends Subsystem {
    private Jaguar topMotor;
    private Jaguar bottomMotor;
    private double speed = .6;
//    Encoder topEncoder;
//    Encoder bottomEncoder;
//    PIDController topSpeedControl;
//    PIDController bottomSpeedControl;
    
    public ShooterSubsystem() {
        topMotor = new Jaguar(RobotMap.SHOOTER_MOTOR_PORT1);
        bottomMotor = new Jaguar(RobotMap.SHOOTER_MOTOR_PORT2);
 
    }
    public void InitialSet() {
        topMotor.set(speed);
        bottomMotor.set(speed); 
        
    }public void end(){
        topMotor.set(0);
        bottomMotor.set(0);
    }
    public void accelerate(){
        topMotor.set(.2);
        bottomMotor.set(.2); 
    }
     public void Display(){    
        
        System.out.println(speed);
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 1, "Shooter speed: "+ speed);
        DriverStationLCD.getInstance().updateLCD();
    }
     
    public void VariableSet(double newSpeed){
       speed += newSpeed; 
       if (speed > .7){
           speed = .7;
       }
       if(speed < .4){
           speed = .4;
       }
       
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}