// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.RobotMovement;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    // RDMM.config_kP(slotIdx, value)
    // RDMM.config_kD(slotIdx, value)
    // RDMM.config_kF(slotIdx, value)
    // LDMM.config_kP(slotIdx, value)
    // LDMM.config_kD(slotIdx, value)
    // LDMM.config_kF(slotIdx, value)
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  private TalonFX RDMM = new TalonFX(Constants.DriveTrain.Right_Drive_Master_ID);
  private TalonFX RDMS = new TalonFX(Constants.DriveTrain.Right_Drive_Slave_ID);

  private TalonFX LDMM = new TalonFX(Constants.DriveTrain.Left_Drive_Master_ID);
  private TalonFX LDMS = new TalonFX(Constants.DriveTrain.Left_Drive_Slave_ID);

  public void setRM(Double PO) {
    RDMM.set(ControlMode.PercentOutput, PO);
    RDMS.follow(RDMM);
  }

  public void setLM(Double PO) {
    LDMM.set(ControlMode.PercentOutput, PO);
    LDMS.follow(LDMM);
  }

    public void setRMD(Double PO) {
      RDMM.set(ControlMode.Position, PO);
      RDMS.follow(RDMM);
    }
  
    public void setLMD(Double PO) {
      LDMM.set(ControlMode.Position, PO);
      LDMS.follow(LDMM);

  }
}
