/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author team4097
 */
public class EccentricSubsystem extends Subsystem {
     private Jaguar angle;
     
     public EccentricSubsystem(){
        angle = new Jaguar(RobotMap.ECCENTRIC_MOTOR_PORT);    
     }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
     public void setEccentric(double num){
        angle.set(num);
    }
     
      public void initDefaultCommand() {
       
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
