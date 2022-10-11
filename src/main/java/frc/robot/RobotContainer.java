// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.FlyWheelControl;
import frc.robot.commands.IntakeControl;
import frc.robot.commands.KickerControl;
import frc.robot.commands.LiftControl;
import frc.robot.commands.SolidnoidTest;
import frc.robot.commands.TankDrive;
import frc.robot.commands.setKicker;
import frc.robot.commands.Auto.Shoot_Back;
import frc.robot.commands.CommandGroups.Load;
import frc.robot.commands.CommandGroups.Shoot;
import frc.robot.subsystems.AirSystem;
import frc.robot.subsystems.BallMovement.FlyWheel;
import frc.robot.subsystems.BallMovement.Intake;
import frc.robot.subsystems.BallMovement.Kicker;
import frc.robot.subsystems.RobotMovement.DriveTrain;
import frc.robot.subsystems.RobotMovement.Lift;
import frc.robot.util.XBoxTrigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final  DriveTrain d_drivetrain = new DriveTrain();
  private final Lift l_lift = new Lift();
  private final AirSystem a_AIR_SYSTEM = new AirSystem();

  private  final FlyWheel f_flywheel = new FlyWheel();
  private  final Kicker k_kicker = new Kicker();
  private final Intake i_intake = new Intake();

  private final Shoot_Back S_Shootback = new Shoot_Back(k_kicker, f_flywheel, d_drivetrain);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    d_drivetrain.setDefaultCommand(new TankDrive(d_drivetrain));
    // Configure the button bindings
    configureButtonBindings();
  }

  public static XboxController XboxC = new XboxController(Constants.OI.JOYSTICK_PORT);

  public static int LX = XboxController.Axis.kLeftX.value;
  public static int LY = XboxController.Axis.kLeftY.value;
  public static int RX = XboxController.Axis.kRightX.value;
  public static int RY = XboxController.Axis.kRightY.value;

  public static XBoxTrigger RT = new XBoxTrigger(XboxC, XboxController.Axis.kRightTrigger.value);
  public static XBoxTrigger LT = new XBoxTrigger(XboxC, XboxController.Axis.kLeftTrigger.value);
  

  public static JoystickButton AB = new JoystickButton(XboxC, 1);
  public static JoystickButton BB = new JoystickButton(XboxC, 2);
  public static JoystickButton XB = new JoystickButton(XboxC, 3);
  public static JoystickButton YB = new JoystickButton(XboxC, 4);
  public static JoystickButton LB = new JoystickButton(XboxC, 5);
  public static JoystickButton RB = new JoystickButton(XboxC, 6);
  public static JoystickButton HB = new JoystickButton(XboxC, 7);
  public static JoystickButton ZB = new JoystickButton(XboxC, 8);
  public static JoystickButton LJB = new JoystickButton(XboxC, 9);
  public static JoystickButton RJB = new JoystickButton(XboxC, 10);
  public static POVButton up = new POVButton(XboxC, 0);
  public static POVButton right = new POVButton(XboxC, 90);
  public static POVButton down = new POVButton(XboxC, 180);
  public static POVButton left = new POVButton(XboxC, 270);

  //Swerve Drive input Axis setup (deadband)
  private static double deadband(double value, double deadband) {
    if (Math.abs(value) > deadband) {
      if (value > 0.0) {
        return (value - deadband) / (1.0 - deadband);
      } else {
        return (value + deadband) / (1.0 - deadband);
      }
    } else {
      return 0.0;
    }
  }
  public static Double modifyAxis(Double value) {
    // Deadband
    value = deadband(value, 0.08);
    // Square the axis
    value = Math.copySign(value * value, value);

    return value;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    XB.whenPressed(new IntakeControl(i_intake, true, 0.4));
    YB.whenPressed(new IntakeControl(i_intake, false, 0.0));

    AB.whenPressed(new setKicker(k_kicker, 0.7));
    AB.whenReleased(new setKicker(k_kicker, 0.0));

    LT.whenPressed(new Load(k_kicker, i_intake));
    RT.whenPressed(new IntakeControl(i_intake, false, 0.0));


    RB.whenPressed(new FlyWheelControl(f_flywheel, 0.8));
    RB.whenReleased(new FlyWheelControl(f_flywheel, 0));
    LB.whenPressed(new FlyWheelControl(f_flywheel, 0.4));
    LB.whenReleased(new FlyWheelControl(f_flywheel, 0));

    up.whenPressed(new LiftControl(l_lift, -0.4));
    up.whenReleased(new LiftControl(l_lift, 0.0));
    down.whenPressed(new LiftControl(l_lift, 0.7));
    down.whenReleased(new LiftControl(l_lift, 0.0));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return S_Shootback;
  }

  public Command getTestCommand() {
    return S_Shootback;
  }
}
