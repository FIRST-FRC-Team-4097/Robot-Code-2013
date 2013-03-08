/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

/**
 *
 * @author Administrator
 */
public class CameraSubsystem extends Subsystem {
    private static int numMisses = 0;
    private BinaryImage bi;
    private AxisCamera cam;
    private boolean isProcessing = false;
    private CriteriaCollection cc = new CriteriaCollection();
    private ParticleAnalysisReport top = null;
    
    private static final int MIN_HEIGHT = 6;
    private static final int MAX_HEIGHT = 25;
    private static final int MIN_WIDTH = 40;
    private static final int MAX_WIDTH = 100;
    
    private static final int RED_LOW = 0;
    private static final int RED_HIGH = 90;
    private static final int GREEN_LOW = 35;
    private static final int GREEN_HIGH = 255;
    private static final int BLUE_LOW = 200;
    private static final int BLUE_HIGH = 255;
    
    private static final double kp = .5;
    private static final double ki = 0;
    private static final double kd = 0;
    
    public void initDefaultCommand() {
        
    }
    
    public boolean isProcessing() {
        return isProcessing;
    }
    
    public void startProcessing() {
        if(!isProcessing) {
            System.out.println("Starting new processing thread.");
            isProcessing = true;
            new Thread() {
                public void run() {
                    try{
                        storeTop();
                    }
                    catch(Exception e) {
                        System.out.println("Error processing image.");
                        isProcessing = false;
                    }
                }
            }.start();
        }
        else {
            System.out.println("Thread already running...");
        }
    }
    
    public String getCoordinates() {
        try {
            storeTop();
            return top.center_mass_x+", "+top.center_mass_y;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return "Error getting coordinates of target.";
        }
    }
    
    public CameraSubsystem() {
//        super(kp, ki, kd);
        try {
            cam = AxisCamera.getInstance();
            cam.writeResolution(AxisCamera.ResolutionT.k320x240);
        }
        catch(Exception e) {
            cam = null;
            System.out.println("Could not connect to camera.");
        }
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, MIN_HEIGHT, MAX_HEIGHT, true);
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, MIN_WIDTH, MAX_WIDTH, true);
//        this.setSetpoint(160);
//        this.setAbsoluteTolerance(.03);
    }
    
    public int getTopX() {
        return top.center_mass_x;
    }
    
    public int getTopY() {
        return top.center_mass_y;
    }
    
    public int getHeightOfTarget() {
        try {
            storeTop();
        } catch (AxisCameraException ex) {
        }
        return top.boundingRectHeight;
    }
    
    public BinaryImage getFilteredImage() throws Exception {
        ColorImage ci = getImage();
        bi = ci.thresholdRGB(RED_LOW, RED_HIGH, GREEN_LOW, GREEN_HIGH, BLUE_LOW, BLUE_HIGH);
        bi = bi.convexHull(false);
        bi = bi.removeSmallObjects(true, 3);
        bi = bi.particleFilter(cc);
        ci.free();
        return bi;
    }
    
    private void storeTop() throws AxisCameraException {
        top = null;
        ColorImage ci = getImage();
        ParticleAnalysisReport target = null;
        if(ci != null) {
            try{
                System.out.println("Storing top details...");
                bi = ci.thresholdRGB(RED_LOW, RED_HIGH, GREEN_LOW, GREEN_HIGH, BLUE_LOW, BLUE_HIGH);
//                ci.free();
//                ci.image.clear();
//                ci.image.free();
                bi = bi.convexHull(false);
                bi = bi.particleFilter(cc);
                bi = bi.removeSmallObjects(true, 2);
                System.out.println("Got here.");
                ParticleAnalysisReport[] reports = bi.getOrderedParticleAnalysisReports();
                ParticleAnalysisReport tmp;
                int lastHighest = 321;
                for(int i=0; i<reports.length; i++) {
                    tmp = reports[i];
                    if(tmp.center_mass_y < lastHighest) {
                        lastHighest = tmp.center_mass_y;
                        target = tmp;
                    }
                }
                }
            catch(Exception e) {
                isProcessing = false;
                System.out.println("Error in the processing.");
                throw new AxisCameraException("Error: "+e.getMessage());
            }
                if(target == null) {
                        isProcessing = false;
                        throw new AxisCameraException("No targets found that fit the specified criteria.");
                    }
                    else {
                        System.out.println(target.toString());
                        top = target;
                    }
                
//            }
//            catch(Exception e) {
//                isProcessing = false;
//                throw new AxisCameraException("Error: "+e.getMessage());
//            }
        }
        else {
            isProcessing = false;
            throw new AxisCameraException("Couldn't get image.");
        }
        isProcessing = false;
        System.out.println("Finished processing.");
    }
    public ColorImage getImage() {
        try{
            return cam.getImage();
        }
        catch(Exception e) {
            return null;
        }
    }
    protected double returnPIDInput() {
        if(numMisses < 6) {
            try{
                storeTop();
    //           startProcessing();
                System.out.println("Feeding in : "+top.center_mass_x);
                numMisses = 0;
                return top.center_mass_x;
            }
            catch(AxisCameraException e) {
                numMisses++;
                System.out.println("Error (165): "+e.getMessage());
                return 165;
            }
        }
        else {
            System.out.println("Could not process 6 times in a row. Exiting...");
            numMisses = 0;
//            this.disable();
            return 165;
        }
    }

    protected void usePIDOutput(double d) {
        System.out.println(d);
//        CommandBase.drive.tankDrive(-d/3, d/3);
    }
}