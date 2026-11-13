package frc.robot.subsystems.conveyor;

import org.littletonrobotics.junction.AutoLog;

public interface ConveyorIO {
  @AutoLog
  public static class ConveyorIOInputs {}

  default void updateInputs(ConveyorIOInputs inputs) {}
}
