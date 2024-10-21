package frc.robot.Subsystem;
import java.io.File;
import edu.wpi.first.wpilibj.Filesystem;
import swervelib.parser.SwerveParser;
import swervelib.SwerveDrive;
import edu.wpi.first.math.util.Units;

public class Drive {
    SwerveDrive swerveController; 
    
    public Drive (String pathToConfig) {
        File swerveDirectory = new File(FileSystem.getDeployDirectory(), "swerve");
        SwerveDriveParser Parser = new SwerveDriveParser(swerveDirectory);
        swerveController = Parser.createSwerveDrive()
        
    }

    public void drive(double translationX, double translationY, double ) {
        swerveDrive.drive(new Translation2d(translationX.getAsDouble() * swerveDrive.getMaximumVelocity(),
                                        translationY.getAsDouble() * swerveDrive.getMaximumVelocity()),
                    angularRotationX.getAsDouble() * swerveDrive.getMaximumAngularVelocity(),
                    true,
                    false);
        
    }

    public void periodic() {
    }
  }
    