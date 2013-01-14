/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Administrator
 */
public class CameraSubsystem extends PIDSubsystem {
    private AxisCamera cam;
    private boolean isProcessing = false;
    private CriteriaCollection cc = new CriteriaCollection();
    private ParticleAnalysisReport top = null;
    
    private static final int RED_LOW = 0;
    private static final int RED_HIGH = 255;
    private static final int GREEN_LOW = 0;
    private static final int GREEN_HIGH = 255;
    private static final int BLUE_LOW = 0;
    private static final int BLUE_HIGH = 255;
    
    private static final double kp = 0;
    private static final double ki = 0;
    private static final double kd = 0;
    
    public void initDefaultCommand() {
        
    }
    
    public boolean isProcessing() {
        return isProcessing;
    }
    
    public void startProcessing() {
        if(!isProcessing) {
            new Thread() {
                public void run() {
                    isProcessing = true;
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
    }
    
    public CameraSubsystem() {
        super(kp, ki, kd);
        cam = AxisCamera.getInstance();
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 30, 140, true);
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 40, 140, true);
        this.setSetpoint(0);
        this.setAbsoluteTolerance(.03);
    }
    
    public int getTopX() {
        return top.center_mass_x;
    }
    
    public int getHeightOfTarget() {
        return top.boundingRectHeight;
    }
    
    public double getDistance(int height) {
        return 11000/height; //replace with an actual algorithm to find distance given height of the target;
    }
    
    private void storeTop() throws AxisCameraException {
        ColorImage ci = getImage();
        if(ci != null) {
            try{
                BinaryImage bi = ci.thresholdRGB(RED_LOW, RED_HIGH, GREEN_LOW, GREEN_HIGH, BLUE_LOW, BLUE_HIGH);
                bi = bi.convexHull(true);
                bi = bi.particleFilter(cc);
                bi = bi.removeSmallObjects(true, 2);
                ParticleAnalysisReport[] reports = bi.getOrderedParticleAnalysisReports();
                ParticleAnalysisReport tmp;
                ParticleAnalysisReport target = null;
                int lastHighest = 0;
                for(int i=0; i<reports.length; i++) {
                    tmp = reports[i];
                    if(tmp.center_mass_y > lastHighest) {
                        lastHighest = tmp.center_mass_y;
                        target = tmp;
                    }
                }
                if(target == null) {
                        throw new AxisCameraException("No targets found that fit the specified criteria.");
                    }
                    else {
                        top = target;
                    }
                
            }
            catch(Exception e) {
                throw new AxisCameraException("Error: "+e.getMessage());
            }
        }
        else {
            throw new AxisCameraException("Couldn't get image.");
        }
        isProcessing = false;
    }
    private ColorImage getImage() {
        try{
            return cam.getImage();
        }
        catch(Exception e) {
            return null;
        }
    }

    protected double returnPIDInput() {
        try{
            storeTop();
            return top.center_mass_x;
        }
        catch(Exception e) {
            System.out.println("Error getting PID input: "+e.getMessage());
            return 160.01;
        }
    }

    protected void usePIDOutput(double d) {
        CommandBase.drive.tankDrive(0, d);
    }
}
