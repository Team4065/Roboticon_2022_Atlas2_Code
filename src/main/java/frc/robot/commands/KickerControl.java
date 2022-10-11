// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallMovement.Kicker;

public class KickerControl extends CommandBase {
  private Kicker k_kicker;
  private double PO;
  private boolean BB;
  private boolean FIN = false;
  /** Creates a new KickerControl. */
  public KickerControl(Kicker k_kicker, double PO, boolean BB) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.k_kicker = k_kicker;
    this.PO = PO;
    this.BB = BB;
    addRequirements(k_kicker);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    k_kicker.setKM(PO);
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
