package frc.robot.subsystems.intake.intakeRoller;

import org.littletonrobotics.junction.AutoLog;

public interface IntakeRollerIO {
  @AutoLog
  public static class IntakeRollerIOInputs {}

  default void updateInputs(IntakeRollerIOInputs inputs) {}
}
