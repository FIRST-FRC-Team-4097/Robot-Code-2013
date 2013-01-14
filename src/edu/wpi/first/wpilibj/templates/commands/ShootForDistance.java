/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Administrator
 */
public class ShootForDistance extends CommandBase {
    private boolean gotSpeed = false;
    private double distance;
    public ShootForDistance(double _distance) {
        this.requires(shooter);
        distance = _distance;
    }

    protected void initialize() {
    }

    protected void execute() {
        shooter.set(getSpeedForDistance(distance));
    }

    protected boolean isFinished() {
        return gotSpeed;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    public double getSpeedForDistance(double distance) {
        return 1; //replace with algorithm for finding shooter speed based on distance.
    }
}