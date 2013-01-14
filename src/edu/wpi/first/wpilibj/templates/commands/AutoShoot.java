/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Administrator
 */
public class AutoShoot extends CommandGroup {
    public AutoShoot() {
        this.addSequential(new AimRobot());
        this.addSequential(new ShootForDistance(CommandBase.cam.getHeightOfTarget()));
    }
}
