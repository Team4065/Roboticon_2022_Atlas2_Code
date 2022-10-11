// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AirSystem;
import frc.robot.subsystems.RobotMovement.Lift;

public class LiftControl extends CommandBase {
  private Lift l_lift;
  private double PO;
  private boolean fin;
  /** Creates a new LiftControl. */
  public LiftControl(Lift l_lift, double PO) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.l_lift = l_lift;
    this.PO = PO;
    addRequirements(l_lift);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (PO < 0) {
      AirSystem.setLS(true);
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {}
      l_lift.setLiftPO(PO);
      // fin = true;
    }
    if (PO > 0) {
      AirSystem.setLS(false);
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {}
      l_lift.setLiftPO(PO);
      //fin = true;
    }
    if (PO == 0) {
      l_lift.setLiftPO(0);
      //fin = true; 
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return fin;
  }
}
