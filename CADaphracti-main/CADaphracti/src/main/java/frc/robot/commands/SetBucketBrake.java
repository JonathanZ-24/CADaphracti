package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Bucket;

public class SetBucketBrake extends InstantCommand {

    Bucket cBucket;

    public SetBucketBrake(Bucket bucket) {
        cBucket = bucket;
    }

    @Override
    public void initialize() {
        cBucket.bucketMotor.setNeutralMode(NeutralMode.Brake);
    }

}
