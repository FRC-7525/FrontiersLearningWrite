package frc.robot.Subsystem;
import java.io.File;
import java.io.IOException;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.XboxController;
import swervelib.parser.SwerveParser;
import swervelib.telemetry.SwerveDriveTelemetry;
import swervelib.telemetry.SwerveDriveTelemetry.TelemetryVerbosity;
import swervelib.SwerveDrive;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;



public class Drive {
    SwerveDrive swerveController; 
    XboxController controller = new XboxController(0); 
    
    public Drive () {
        double maxSpeed = Units.feetToMeters (16);
        File swerveJsonDirectory = new File(Filesystem.getDeployDirectory(), "swerve");
        try {
            swerveController = new SwerveParser(swerveJsonDirectory).createSwerveDrive(maxSpeed);
        } catch (IOException e){
            e.printStackTrace();
        } 
        SwerveDriveTelemetry.verbosity = TelemetryVerbosity.HIGH;
    }

    public void drivePeriodic () {
        swerveController.drive(new Translation2d(controller.getLeftX() * swerveController.getMaximumVelocity(), 
                                                controller.getLeftY() * swerveController.getMaximumVelocity() *-1), 
                                    controller.getRightX() * swerveController.getMaximumAngularVelocity(), 
                                false, 
                                false); 
                                    
                    
  }
}
    