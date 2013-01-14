/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Administrator
 */
public class AutonomousCommand extends CommandBase {

    protected void initialize() {
    }

    protected void execute() {
        new AutoShoot().start();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
