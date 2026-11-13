package frc.robot.subsystems.shooter.shooterPivot;

import org.littletonrobotics.junction.AutoLog;

public interface ShooterPivotIO {
  @AutoLog
  public static class ShooterPivotIOInputs {}

  default void updateInputs(ShooterPivotIOInputs inputs) {}
}
