/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Administrator
 */
public class AimRobot extends CommandBase {
    
    public AimRobot() {
        this.requires(cam);
        this.requires(drive);
    }

    protected void initialize() {
        cam.enable();
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return cam.onTarget();
    }

    protected void end() {
        cam.disable();
    }

    protected void interrupted() {
        cam.disable();
    }
    
}
