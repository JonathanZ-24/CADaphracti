package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Chassis;

public class RunBackAuton extends InstantCommand {
    public RunAuton bAuton;
    public Chassis cChassis;

    public RunBackAuton(Chassis chassis){
        cChassis = chassis;
        addRequirements(cChassis);
    }

    @Override
    public void initialize() {
        bAuton = new RunAuton(cChassis);
        bAuton.schedule();
    }
}
