// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.FlyWheelControl;
import frc.robot.commands.KickerControl;
import frc.robot.commands.sleepCM;
import frc.robot.subsystems.BallMovement.FlyWheel;
import frc.robot.subsystems.BallMovement.Intake;
import frc.robot.subsystems.BallMovement.Kicker;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Shoot extends SequentialCommandGroup {
  /** Creates a new Shoot. */
  public Shoot(FlyWheel f_flywheeel, Kicker k_kicker, double SPO, double KPO) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
    new FlyWheelControl(f_flywheeel, SPO),
    new sleepCM(300),
    new KickerControl(k_kicker, KPO, false));
  }
}