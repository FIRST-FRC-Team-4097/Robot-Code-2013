/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author team4097
 */
public class LEDSubsystem extends Subsystem {
    Relay LED;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public LEDSubsystem(){
        LED = new Relay(RobotMap.LED_PORT);
        LED.setDirection(Relay.Direction.kReverse);
    }
    
    public void turnOn(){
        LED.set(Relay.Value.kOn);        
    }
    
    public void turnOff(){
        LED.set(Relay.Value.kOff);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
