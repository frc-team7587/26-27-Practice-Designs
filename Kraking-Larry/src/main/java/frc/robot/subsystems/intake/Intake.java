// Copyright (c) 2021-2026 Littleton Robotics
// http://github.com/Mechanical-Advantage
//
// Use of this source code is governed by a BSD
// license that can be found in the LICENSE file
// at the root directory of this project.

package frc.robot.subsystems.intake;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj.Alert;
import edu.wpi.first.wpilibj.Alert.AlertType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.intake.intakePivot.IntakePivotIO;
import frc.robot.subsystems.intake.intakePivot.IntakePivotIOInputsAutoLogged;
import frc.robot.subsystems.intake.intakeRoller.IntakeRollerIO;
import frc.robot.subsystems.intake.intakeRoller.IntakeRollerIOInputsAutoLogged;
import org.littletonrobotics.junction.Logger;

public class Intake extends SubsystemBase {
  private final IntakeRollerIO rollerIO;
  private final IntakePivotIO pivotIO;

  private final IntakeRollerIOInputsAutoLogged rollerInputs = new IntakeRollerIOInputsAutoLogged();
  private final IntakePivotIOInputsAutoLogged pivotInputs = new IntakePivotIOInputsAutoLogged();

  private final Alert rollerDisconnectedAlert =
      new Alert("Disconnected intake roller motor.", AlertType.kError);
  private final Alert pivotDisconnectedAlert =
      new Alert("Disconnected intake pivot motor.", AlertType.kError);

  public Intake(IntakeRollerIO rollerIO, IntakePivotIO pivotIO) {
    this.rollerIO = rollerIO;
    this.pivotIO = pivotIO;
  }

  @Override
  public void periodic() {
    rollerIO.updateInputs(rollerInputs);
    pivotIO.updateInputs(pivotInputs);

    Logger.processInputs("Intake/Roller", rollerInputs);
    Logger.processInputs("Intake/Pivot", pivotInputs);

    rollerDisconnectedAlert.set(!rollerInputs.connected);
    pivotDisconnectedAlert.set(!pivotInputs.connected);
  }

  public void runRollers(Voltage voltage) {
    rollerIO.setVoltage(voltage);
  }

  public void stopRollers() {
    rollerIO.stop();
  }

  public void runPivotVolts(Voltage voltage) {
    pivotIO.setVoltage(voltage);
  }

  public void setPivotPosition(Rotation2d position) {
    pivotIO.setPosition(position);
  }

  public void stopPivot() {
    setPivotPosition(getPivotPosition());
  }

  public void stop() {
    stopRollers();
    stopPivot();
  }

  public Rotation2d getPivotPosition() {
    return pivotInputs.position;
  }

  public Command runRollersCommand(Voltage voltage) {
    return Commands.startEnd(() -> runRollers(voltage), this::stopRollers, this);
  }

  public Command setPivotPositionCommand(Rotation2d position) {
    return Commands.runOnce(() -> setPivotPosition(position), this);
  }

  public Command runPivotVoltsCommand(Voltage voltage) {
    return Commands.startEnd(() -> runPivotVolts(voltage), this::stopPivot, this);
  }
}
