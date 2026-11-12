package frc.robot.subsystems.intake.intakePivot;

import org.littletonrobotics.junction.AutoLog;

public interface IntakePivotIO {
    @AutoLog
    public static class IntakePivotIOInputs {
        
    }

    default void updateInputs(IntakePivotIOInputs inputs) {}
}
