// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.Constants.DriveTrain;
import frc.robot.commands.sleepCM;
import frc.robot.commands.CommandGroups.Shoot;
import frc.robot.subsystems.BallMovement.FlyWheel;
import frc.robot.subsystems.BallMovement.Kicker;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Shoot_Back extends SequentialCommandGroup {
  /** Creates a new Shoot_Back. */
  public Shoot_Back(Kicker k_kicker, FlyWheel f_flywheel, frc.robot.subsystems.RobotMovement.DriveTrain d_drivetrain ) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new Shoot(f_flywheel, k_kicker, 0.4, 1.0), 
    new sleepCM(2000), 
    new Shoot(f_flywheel, k_kicker, 0.0, 0.0),
    new AutoDrive(d_drivetrain,.4),
    new sleepCM(1000),
    new AutoDrive(d_drivetrain,0.0)
    );
  }
}
