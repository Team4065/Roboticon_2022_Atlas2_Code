// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AirSystem extends SubsystemBase {
  /** Creates a new AirSystem. */
  public AirSystem() {
    
    compressor = PCM.makeCompressor();
    compressor.enableDigital();
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("PS", compressor.getPressureSwitchValue());
    SmartDashboard.putBoolean("C", intakeS.get());
  }

  public static PneumaticsControlModule PCM = new PneumaticsControlModule(Constants.Air.Pneumatic_Control_Module_ID);
  public static Compressor compressor;
  private static Solenoid liftS = PCM.makeSolenoid(1);
  private static Solenoid intakeS = PCM.makeSolenoid(0);

  public static void setLS (boolean state) {
    liftS.set(state);
  }

  public static void setIS (boolean state) {
    intakeS.set(state);
  }

}

