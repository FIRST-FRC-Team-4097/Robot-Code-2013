
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private Joystick leftJoy;
    private Joystick rightJoy;
    private Joystick shootController;
    
    private Button rightTriggerButton;
    private Button loadButton;
    private Button overrideButton;
    private Button shootButton;
    private Button shootUp;
    private Button shootDown;
    private Button LEDButton;
    
    public double control = 0;
    public double changeSpeed = 0;
    public boolean overrideMode = false;
    
    public OI() {        
        leftJoy = new Joystick(RobotMap.LEFT_JOY_PORT);
        rightJoy = new Joystick(RobotMap.RIGHT_JOY_PORT);
        shootController = new Joystick(RobotMap.SHOOTER_CONTROLLER_PORT);
        
        rightTriggerButton = new JoystickButton(rightJoy, 1);
        
        loadButton = new JoystickButton(shootController, 9);
        
        shootButton = new JoystickButton(shootController, 2);
        shootUp = new JoystickButton(shootController,6);
        shootDown = new JoystickButton(shootController,5);
        
        overrideButton = new JoystickButton(shootController,8);
        LEDButton = new JoystickButton(shootController,7);       

        rightTriggerButton.whenPressed(new WriteHeight());
        loadButton.whenPressed(new Load());
        shootUp.whenPressed(new ShootSpeedUp());
        shootDown.whenPressed(new ShootSpeedDown());
        overrideButton.whenPressed(new OverrideMode());
        LEDButton.whenPressed(new LED());
    }
    
    public boolean isLoadButtonPressed(){
        return loadButton.get();
    }
   public boolean isShootButtonPressed(){
       return shootButton.get();
   }
   
   public boolean isInOverrideMode(){
       return overrideButton.get();
   }
    
    public double getRightY() {
        return rightJoy.getY();
    }
    public double getLeftY() {
        return leftJoy.getY();
    }
    public boolean getRightTrigger() {
        return rightJoy.getTrigger();
    }
    
    public boolean shootUp(){
        return shootUp.get();
    }
    
    public boolean shootDown(){
        return shootDown.get();
    }
        
    public double getEccentricAxis(){
        return shootController.getRawAxis(5);
    }
        
//    public boolean getClimbButton() {
//        return shootController.getButton(Joystick.ButtonType.kTop);
//    }
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}
