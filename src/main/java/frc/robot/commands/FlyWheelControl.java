// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallMovement.FlyWheel;

public class FlyWheelControl extends CommandBase {
  private FlyWheel f_flywheel;
  private double VOL;
  private boolean FIN = false;
  /** Creates a new FlyWheelControl. */
  public FlyWheelControl(FlyWheel f_flywheel, double VOL) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.f_flywheel = f_flywheel;
    this.VOL = VOL;
    addRequirements(f_flywheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    f_flywheel.SMM.set(ControlMode.PercentOutput, VOL);
    f_flywheel.SMS.set(ControlMode.PercentOutput, VOL);
    FIN = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return FIN;
  }
}
