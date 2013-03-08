/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.LoaderSubsystem;


    // Called just before this Command runs the first time
    // Called repeatedly when this Command is scheduled to run
/**
 *
 * @author team4097
 */
public class Load extends CommandBase{
    private long start;
    private boolean isLoading = false;
    public Load() {
       this.requires(load);
    }
       
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

    protected void initialize() {
        isLoading = true;
        start = System.currentTimeMillis();
    }

    protected void execute() {
         if(oi.overrideMode){
             if(isLoading){
            load.loadSpeed(.2); 
        }
        if(System.currentTimeMillis() - start > 540){
                isLoading = false;
        } 
        }
    }

    protected boolean isFinished() {
        return !isLoading;
    }

    protected void end() {
        load.loadSpeed(0);
        isLoading = false;
    }

    protected void interrupted() {
        load.loadSpeed(0);
        isLoading = false;
    }

    

    }

    // Make this return true when this Command no longer needs to run execute()

    // Called once after isFinished returns true

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run