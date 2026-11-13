package frc.robot.subsystems.intake.intakeRoller;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeRoller extends SubsystemBase {
  private final IntakeRollerIO io;

  public IntakeRoller(IntakeRollerIO io) {
    this.io = io;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
