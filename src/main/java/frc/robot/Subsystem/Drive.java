package frc.robot.Subsystem;
import java.io.File;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.XboxController;
import swervelib.parser.SwerveParser;
import swervelib.telemetry.SwerveDriveTelemetry;
import swervelib.telemetry.SwerveDriveTelemetry.TelemetryVerbosity;
import swervelib.SwerveDrive;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import swervelib.SwerveModule;



public class Drive {
    private double maximumSpeed;
    private File swerveJsonDirectory;
    private SwerveDrive swerveDrive;
    private XboxController controller;
    SwerveModule [] modules;

    
    public Drive () {
        controller = new XboxController(0);
        maximumSpeed = Units.feetToMeters(16);
        try {
            swerveJsonDirectory = new File(Filesystem.getDeployDirectory(), "swerve");
            swerveDrive = new SwerveParser(swerveJsonDirectory).createSwerveDrive(maximumSpeed);
            SwerveDriveTelemetry.verbosity = TelemetryVerbosity.HIGH;
            System.out.println("swerve config success");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("failed swerve config");
        } 

        modules = swerveDrive.getModules();
    }

    public void drivePeriodic () {
        double xMovement = MathUtil.applyDeadband(controller.getLeftY(), 0.1) * 100;
        double rotation = MathUtil.applyDeadband(controller.getRightX(), 0.1) * 100;
        double yMovement = MathUtil.applyDeadband(controller.getLeftX(), 0.1) * 100;
        swerveDrive.drive(new Translation2d(xMovement, yMovement), rotation, false, false);   
                            
                    
  }
}
    