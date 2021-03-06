package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.auton.AutonChassis;
import frc.robot.commands.*;
import frc.robot.subsystems.Bucket;
import frc.robot.subsystems.Chassis;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final static Chassis m_Chassis = new Chassis();
  public final static Bucket cBucket = new Bucket();
  public final static RunAuton aAuton = new RunAuton(m_Chassis);
  public final RunChassis m_autoCommand = new RunChassis(m_Chassis);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings


    configureButtonBindings();

  
  }
  public static XboxController driverController = new XboxController(Constants.DRIVER_CONTROLLER);


  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

//    RobotContainer.cBucket.setDefaultCommand(new RunBucket(RobotContainer.cBucket));
    new JoystickButton(driverController, XboxController.Button.kY.value).whileHeld(new RunBucket(cBucket));
    new JoystickButton(driverController,XboxController.Button.kB.value).whileHeld(new RunBucketBack(cBucket));
    new JoystickButton(driverController, XboxController.Button.kX.value).whenPressed(new RunBackAuton(m_Chassis));
    new JoystickButton(driverController,XboxController.Button.kBumperRight.value).whenPressed(new SetBucketBrake(cBucket));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}