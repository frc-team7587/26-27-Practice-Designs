package frc.robot.subsystems.intake.intakePivot;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Celsius;
import static edu.wpi.first.units.Units.Radians;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.Volts;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;
import org.littletonrobotics.junction.AutoLog;

public interface IntakePivotIO {
  @AutoLog
  public static class IntakePivotIOInputs {
    public boolean connected = false;
    public Rotation2d position = Rotation2d.kZero;
    public Angle angle = Radians.of(0.0);
    public Voltage voltage = Volts.of(0.0);
    public AngularVelocity velocity = RadiansPerSecond.of(0.0);
    public Current current = Amps.of(0.0);
    public Temperature temperature = Celsius.of(0.0);
  }

  /**
   * Updates the set of loggable inputs.
   *
   * @param inputs The set of loggable inputs to update.
   */
  public default void updateInputs(IntakePivotIOInputs inputs) {}

  /**
   * Applies a specific voltage to the intake pivot.
   *
   * @param volts The voltage the intake pivot gets set to.
   */
  public default void setVoltage(Voltage voltage) {}

  /**
   * Sets the position of the intake pivot.
   *
   * @param position
   */
  public default void setPosition(Rotation2d position) {}

  /** Stops the intake pivot. */
  public default void stop() {
    setVoltage(Volts.of(0.0));
  }
}
