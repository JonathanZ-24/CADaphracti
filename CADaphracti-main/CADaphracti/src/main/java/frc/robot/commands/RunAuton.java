package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.*;
import frc.robot.auton.AutonChassis;
import frc.robot.subsystems.Chassis;


import java.util.function.BooleanSupplier;

public class RunAuton extends SequentialCommandGroup {

   public Chassis mChassis;

    public RunAuton(Chassis chassis){

        mChassis = chassis;
        addRequirements(mChassis);

    }


    @Override
    public void initialize() {

        addCommands(new AutonChassis(-.5,0,1,mChassis));
        addCommands(new AutonChassis(0, 0, 1, mChassis));
        //addCommands(new AutonChassis(0,0,1,mChassis));
        //addCommands(new AutonChassis(.5,-.25,1,mChassis));
        //addCommands(new AutonChassis(0,0,1,mChassis));
        addCommands(new AutonChassis(.5,0,1,mChassis));

        super.initialize();
    }
}