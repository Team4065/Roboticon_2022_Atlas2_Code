package frc.robot.util;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

public class XBoxTrigger extends Button {
    XboxController joystick;
    int axis;

    public XBoxTrigger(XboxController xboxC, int axis) {
        this.joystick = xboxC;
        this.axis = axis;
    }

    public double getTriggerValue() {
        return joystick.getRawAxis(axis);
    }

    @Override
    public boolean get() {
        return joystick.getRawAxis(axis) > 0.8;
    }
}