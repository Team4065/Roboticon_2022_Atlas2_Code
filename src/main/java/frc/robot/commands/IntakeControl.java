// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.AirSystem;
import frc.robot.subsystems.BallMovement.Intake;

public class IntakeControl extends CommandBase {
  private Intake i_intake;
  private boolean state;
  private double PO;
  private boolean FIN = false;
  /** Creates a new IntakeControl. */
  public IntakeControl(Intake i_intake, boolean state, double PO) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.i_intake = i_intake;
    this.state = state;
    this.PO = PO;
    addRequirements(i_intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (PO < 0.3) {
      AirSystem.setIS(false);
    }else if (PO > 0.3){
      AirSystem.setIS(true);
    }
    i_intake.setIT(PO);
    FIN = true;
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println(state);
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
