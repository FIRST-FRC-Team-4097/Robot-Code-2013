/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogModule;

/**
 *
 * @author team4097
 */
public class PotentiometerSubsystem extends Subsystem {
    AnalogChannel potentiometer;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public PotentiometerSubsystem(){
    potentiometer = new AnalogChannel(1);
}

public double getPotValue(){
    return potentiometer.getVoltage();
}

    public void initDefaultCommand() {
        
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
