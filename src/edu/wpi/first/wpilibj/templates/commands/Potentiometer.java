/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 *
 * @author team4097
 */
public class Potentiometer extends CommandBase {
    private double angle;
     
    
    public Potentiometer() {
        this.requires(pot);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "Pot Value: "+pot.getPotValue()+ "                                              ");
        System.out.println("Pot Value: "+pot.getPotValue());
        angle = ((86.96*pot.getPotValue())-248.17);
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser5, 1, "Shooter Angle: "+angle);
        DriverStationLCD.getInstance().updateLCD();
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
