/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.*;
/**
 *
 * @author team4097
 */
public class WriteHeight extends CommandBase {
//    private static int num = 0;
    private boolean done = false;
    public WriteHeight() {
        this.requires(cam);
    }
    protected void initialize() {
        try{
//            cam.getFilteredImage().write("/image"+num+".jpg");
//            System.out.println("Wrote image.");
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser4, 1, "Chunk: "+cam.getHeightOfTarget() +" tall at "+cam.getTopX()+", "+cam.getTopY()+".");
            DriverStationLCD.getInstance().updateLCD();
            done = true;
        }
        catch(Exception e) {
            System.out.println("Couldn't write: "+e.getMessage());
            done = true;
        }
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}