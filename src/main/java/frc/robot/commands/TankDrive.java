// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.RobotMovement.DriveTrain;


public class TankDrive extends CommandBase {
  private DriveTrain d_drivetrain;
  private double driveR;
  private double driveL;
  /** Creates a new TankDrive. */
  public TankDrive(DriveTrain d_drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.d_drivetrain = d_drivetrain;
    addRequirements(d_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveR = RobotContainer.modifyAxis(RobotContainer.XboxC.getRawAxis(RobotContainer.RY));
    driveL = RobotContainer.modifyAxis(RobotContainer.XboxC.getRawAxis(RobotContainer.LY));
    d_drivetrain.setLM(-driveR);
    d_drivetrain.setRM(driveL);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
