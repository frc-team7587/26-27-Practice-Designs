package frc.robot.subsystems.shooter.shooterFlywheel;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterFlywheel extends SubsystemBase {
    private final ShooterFlywheelIO io;

    public ShooterFlywheel(ShooterFlywheelIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
    
}
