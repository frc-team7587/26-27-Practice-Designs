package frc.robot.subsystems.shooter.shooterFeeder;

import org.littletonrobotics.junction.AutoLog;

public interface ShooterFeederIO {
    @AutoLog
    public static class ShooterFeederIOInputs {

    }

    default void updateInputs(ShooterFeederIOInputs inputs) {}
}
