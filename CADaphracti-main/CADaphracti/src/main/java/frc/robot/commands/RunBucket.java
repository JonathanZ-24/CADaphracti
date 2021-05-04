// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

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
    mBucket.runBucket();
  }

}
