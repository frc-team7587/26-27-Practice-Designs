package frc.robot.subsystems.conveyor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Conveyor extends SubsystemBase {
  private final ConveyorIO io;

  public Conveyor(ConveyorIO io) {
    this.io = io;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
