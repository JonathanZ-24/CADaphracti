// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants;
import frc.robot.commands.RunBucket;

/** Add your docs here. */
public class Bucket extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
    public static WPI_TalonFX bucketMotor = null;

    public Bucket() {
        bucketMotor = new WPI_TalonFX(Constants.BUCKET_MOTOR);
        bucketMotor.setSelectedSensorPosition(0);
        bucketMotor.config_kP(0, 1.0);
        bucketMotor.config_kI(0,0);
        bucketMotor.config_kD(0,0);

        this.setDefaultCommand(new RunBucket(this));

    }

    public void runBucket() {
        bucketMotor.setSelectedSensorPosition(0);
    }
}
