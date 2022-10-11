// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class DriveTrain {
        public static final int Right_Drive_Master_ID = 9;
        public static final int Right_Drive_Slave_ID = 8;
        public static final int Left_Drive_Master_ID = 7;
        public static final int Left_Drive_Slave_ID = 6;
    }

    public final class Lift {
        public static final int Lift_Motor_ID = 14;
    }

    public final class Air {
        public static final int Pneumatic_Control_Module_ID = 15;
    }

    public final class BallMovement {
        public static final int Intake_Motor_ID = 3;
        public static final int Kicker_Motor_ID = 13;
        public static final int Beam_Break_ID = 0;
        public static final int Shoot_Motor_Slave_ID = 10;
        public static final int Shoot_Motor_Master_ID = 11;
    }

    public final class ShooterPIDF {
        public static final double kP = 0.1;
        public static final double kI = 0.0;
        public static final double kD = 0.0;
        public static final double kF = 1.0;
    }

    public static class OI {
        public static final int JOYSTICK_PORT = 0;
    }
}


