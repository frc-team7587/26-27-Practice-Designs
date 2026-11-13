package frc.robot.subsystems.intake.intakeRoller;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Celsius;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.Volts;

public interface IntakeRollerIO {
    @AutoLog
    public static class IntakeRollerIOInputs {
        public boolean connected = false;
        public double position = 0.0;
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
    public default void updateInputs(IntakeRollerIOInputs inputs) {}

    /**
     * Applies a specific voltage to the intake roller.
     *
     * @param volts The voltage that the intake roller gets set to.
     */
    public default void setVoltage(Voltage voltage) {}

    /**
     * Sets the speed of the intake roller.
     *
     * @param speed The speed thats the intake roller gets set to.
     */
    public default void setSpeed(double speed) {}

    /** Stops the intake roller. */
    public default void stop() {
      setVoltage(Volts.of(0.0));
    }
}
