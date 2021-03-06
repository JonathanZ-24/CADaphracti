package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.RunChassis;

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

        leftChassisMotor.setNeutralMode(NeutralMode.Brake);
        rightChassisMotor.setNeutralMode(NeutralMode.Brake);


        this.setDefaultCommand(new RunChassis(this));
    }

    public void runChassis(double chassisSpeed, double chassisRotation) {
        chassisDifferentialDrive.arcadeDrive(chassisSpeed, chassisRotation);
    }


    public void runJoystick(double x, double z){
      chassisDifferentialDrive.curvatureDrive(-x, z,true);
    }
}