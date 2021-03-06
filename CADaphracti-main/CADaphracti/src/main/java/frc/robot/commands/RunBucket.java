// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Bucket;

public class RunBucket extends CommandBase {

  public static Bucket mBucket;

  /** Creates a new RunBucket. */
  public RunBucket(Bucket bucket) {
    // Use addRequirements() here to declare subsystem dependencies.

    mBucket = bucket;

    addRequirements(mBucket);


  }

  @Override
  public void execute() {
    mBucket.runBucket(0.35);
//    if (mBucket.bucketMotor.getSelectedSensorPosition() <= -1000.0) {
//      mBucket.bucketMotor.set(TalonFXControlMode.PercentOutput, 0.3);
//
//    } else {
//      mBucket.bucketMotor.set(0.0);
//    }
//    System.out.println(mBucket.bucketMotor.getSelectedSensorPosition());
  }

  @Override
  public void end(boolean isFinished) {
    mBucket.bucketMotor.set(0);
  }

}
