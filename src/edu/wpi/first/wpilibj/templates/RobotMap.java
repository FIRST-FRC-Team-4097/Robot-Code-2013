package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final int RIGHT_MOTOR_PORT = 0;
    public static final int LEFT_MOTOR_PORT = 0;
    
    public static final int LEFT_JOY_PORT = 0;
    public static final int RIGHT_JOY_PORT = 0;
    public static final int SHOOTER_CONTROLLER_PORT = 0;
    
    public static final int SHOOTER_MOTOR_PORT1 = 0;
    public static final int SHOOTER_MOTOR_PORT2 = 0;
    
    public static final int TOP_ENCODER_A = 0;
    public static final int TOP_ENCODER_B = 0;
    public static final int BOTTOM_ENCODER_A = 0;
    public static final int BOTTOM_ENCODER_B = 0;
    
    public static final int A = 1;
    public static final int B = 2;
    public static final int X = 3;
    public static final int Y = 4;
    public static final int LEFT_BUTTON = 5;
    public static final int RIGHT_BUTTON = 6;
    public static final int BACK = 7;
    public static final int START = 8;
    public static final int TRIGGER_AXIS = 3; //left axis+ right axis-
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
}
