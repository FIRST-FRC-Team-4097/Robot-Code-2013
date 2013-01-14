/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author SEVERHAL2014
 */
public class RunShooter extends CommandBase{
    public RunShooter() {
        this.requires(shooter);
    }
    public void initialize() {
        
    }
    public void interrupted() {
        shooter.set(0);
    }
    public void end() {
        
    }
    public boolean isFinished() {
        return false;
    }
    public void execute() {
        shooter.set(1);
    }
}
