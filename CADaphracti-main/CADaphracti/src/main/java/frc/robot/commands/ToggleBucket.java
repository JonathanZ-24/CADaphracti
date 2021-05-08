package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Bucket;
import frc.robot.subsystems.Chassis;

public class ToggleBucket extends InstantCommand {

    private Bucket bBucket;
    public ToggleBucket(Bucket bucket){
        bBucket = bucket;
        addRequirements(bBucket);
    }
    @Override
    public void initialize(){
        bBucket.toggleBrake();
    }
}
