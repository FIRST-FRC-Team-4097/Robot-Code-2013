package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final int RIGHT_MOTOR_PORT = 2;
    public static final int LEFT_MOTOR_PORT = 1;
    
    public static final int ANGLE_WHEEL_PORT = 6;
    
//    public static final int WINCH_MOTOR_PORT = 7; // This is a sub, the final
                                                  //version will use the proper
                                                  //port number.
    public static final int LEFT_JOY_PORT = 1;
    public static final int RIGHT_JOY_PORT = 2;
    public static final int SHOOTER_CONTROLLER_PORT = 3;
    public static final int LED_PORT = 1;
    
    public static final int SHOOTER_MOTOR_PORT1 = 3;
    public static final int SHOOTER_MOTOR_PORT2 = 4;
    public static final int LOADER_MOTOR_PORT = 5;
    public static final int ECCENTRIC_MOTOR_PORT = 6;
    
    public static final int LEFT_ENCODER_A = 8;
    public static final int LEFT_ENCODER_B = 9;
    
    public static final int RIGHT_ENCODER_A = 10;
    public static final int RIGHT_ENCODER_B = 11;
    
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
}