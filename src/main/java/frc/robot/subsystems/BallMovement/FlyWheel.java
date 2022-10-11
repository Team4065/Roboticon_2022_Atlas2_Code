// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.BallMovement;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheel extends SubsystemBase {
  /** Creates a new FlyWheel. */
  public FlyWheel() {
    SMS.setInverted(true);
    SMM.config_kP(0, Constants.ShooterPIDF.kP);
    SMM.config_kI(0, Constants.ShooterPIDF.kI);
    SMM.config_kD(0, Constants.ShooterPIDF.kD);
    SMM.config_kF(0, Constants.ShooterPIDF.kF);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public TalonFX SMM = new TalonFX(Constants.BallMovement.Shoot_Motor_Master_ID);
  public TalonFX SMS = new TalonFX(Constants.BallMovement.Shoot_Motor_Slave_ID);

  public void setSM (Double PO) {
    SMM.set(ControlMode.PercentOutput, PO);
    SMS.follow(SMM);
  }
}
