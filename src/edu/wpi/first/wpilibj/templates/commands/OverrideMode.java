/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
/**
 *
 * @author team4097
 */
public class OverrideMode extends CommandBase {
    
    public OverrideMode() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        oi.overrideMode = !oi.overrideMode;
        if (oi.overrideMode){
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser5, 2, "OVERRIDE MODE :P");
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser6, 2, "Good Luck Team!");
        DriverStationLCD.getInstance().updateLCD();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
