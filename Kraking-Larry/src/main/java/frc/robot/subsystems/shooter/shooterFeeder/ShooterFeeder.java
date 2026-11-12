package frc.robot.subsystems.shooter.shooterFeeder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterFeeder extends SubsystemBase {
    private final ShooterFeederIO io;

    public ShooterFeeder(ShooterFeederIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
    
}
