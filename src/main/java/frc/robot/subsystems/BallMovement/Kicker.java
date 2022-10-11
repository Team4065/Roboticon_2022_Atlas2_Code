// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.BallMovement;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Kicker extends SubsystemBase {
  /** Creates a new Kicker. */
  public Kicker() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
    
  }

  private CANSparkMax KM = new CANSparkMax(Constants.BallMovement.Kicker_Motor_ID, MotorType.kBrushless);
  private DigitalInput BB = new DigitalInput(Constants.BallMovement.Beam_Break_ID);

  public void setKM (Double PO) {
    KM.set(PO);
  }
  public boolean getBB () {
    return BB.get();
  }
}
