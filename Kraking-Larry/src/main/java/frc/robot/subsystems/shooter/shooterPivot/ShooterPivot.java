package frc.robot.subsystems.shooter.shooterPivot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterPivot extends SubsystemBase {
  private final ShooterPivotIO io;

  public ShooterPivot(ShooterPivotIO io) {
    this.io = io;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
