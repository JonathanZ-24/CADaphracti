package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Chassis extends SubsystemBase {
    // Define chassis motors
    public static WPI_TalonFX leftChassisMotor = null;
    public static WPI_TalonFX rightChassisMotor = null;

    //Define chassis differential drive
    DifferentialDrive chassisDifferentialDrive = null;

    public Chassis() {
        leftChassisMotor = new WPI_TalonFX(Constants.CHASSIS_LEFT_MOTOR);
        rightChassisMotor = new WPI_TalonFX(Constants.CHASSIS_RIGHT_MOTOR);

        chassisDifferentialDrive = new DifferentialDrive(leftChassisMotor, rightChassisMotor);
    }

    public void runChassis(double chassisSpeed, double chassisRotation) {
        chassisDifferentialDrive.arcadeDrive(chassisSpeed, chassisRotation);
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
  
    @Override
    public void simulationPeriodic() {
      // This method will be called once per scheduler run during simulation
    }
}