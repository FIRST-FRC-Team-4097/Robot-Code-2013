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
   private long start;
   private int loop = 0;
    
    public RunShooter() {
        this.requires(shooter);
    }
    
     public void initialize() {
         start = System.currentTimeMillis();
    }
     
    public void execute() {
        if (oi.overrideMode){
            if(oi.isShootButtonPressed()){
                shooter.VariableSet(oi.changeSpeed);  
                shooter.InitialSet();
                shooter.Display();
                if(oi.changeSpeed != 0){
                    oi.changeSpeed = 0;
                }
            }
            else{
                shooter.end();
            }
        }
        if(!oi.overrideMode){
            if(loop <= 4){
                if(System.currentTimeMillis()-start <= 1000){
                    shooter.accelerate();
                }
                if(System.currentTimeMillis()-start > 1000 && System.currentTimeMillis() - start <= 5000){
                    shooter.InitialSet();   
                }
                if(System.currentTimeMillis()-start > 5000 && System.currentTimeMillis() - start <= 5100){
                    load.loadSpeed(.2);
                }
                if (System.currentTimeMillis() - start > 5540){ 
                    load.loadSpeed(0);
                    loop++;
                    start = System.currentTimeMillis();
                }
            }
            else{
                end();
            }
        }
        
    }
   
    
    public void interrupted() {
        shooter.end();
        loop = 0;

    }
    public void end() {
        shooter.end();
        loop = 0;

    }
    public boolean isFinished() {
        return false;
    }
    
    }
