/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.templates.*;

/**
 *
 * @author team4097
 */
public class LoaderSubsystem extends Subsystem{
    private Jaguar loaderMotor;

    public LoaderSubsystem() {
        loaderMotor = new Jaguar(RobotMap.LOADER_MOTOR_PORT);
    }
    
    protected void initDefaultCommand() {
    }
    
    public void loadSpeed(double load){
        loaderMotor.set(load);
    }
    
}