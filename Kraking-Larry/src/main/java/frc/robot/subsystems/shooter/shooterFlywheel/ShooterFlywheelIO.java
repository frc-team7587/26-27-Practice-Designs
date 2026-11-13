package frc.robot.subsystems.shooter.shooterFlywheel;

import org.littletonrobotics.junction.AutoLog;

public interface ShooterFlywheelIO {
  @AutoLog
  public static class ShooterFlywheelIOInputs {}

  default void updateInputs(ShooterFlywheelIOInputs inputs) {}
}
