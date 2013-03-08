/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 * @author team4097
 */
public class DriveSubsystem extends Subsystem{
    private Jaguar left;
    private Jaguar right;
    public DriveSubsystem() {
        left = new Jaguar(RobotMap.LEFT_MOTOR_PORT);
        right = new Jaguar(RobotMap.RIGHT_MOTOR_PORT);
    }
    public void tankDrive(double l, double r) {
        left.set(l);
        right.set(r);
    }

    protected void initDefaultCommand() {
    }
}