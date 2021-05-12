package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Chassis;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunChassis extends CommandBase {

    private final Chassis m_drive;

    /**
     * Creates a new ExampleCommand.
     *
     * @param drive The subsystem used by this command.
     */
    public RunChassis(Chassis drive) {
        m_drive = drive;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(m_drive);
    }


  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double chassisSpeed = RobotContainer.driverController.getRawAxis(Constants.DRIVER_CONTROLLER_MOVE_AXIS);
        double chassisRotation = 0.6*RobotContainer.driverController.getRawAxis(Constants.DRIVER_CONTROLLER_ROTATE_AXIS);

        m_drive.runJoystick(chassisSpeed, chassisRotation);
    }

  
}
