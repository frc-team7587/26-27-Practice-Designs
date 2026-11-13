package frc.robot.subsystems.intake.intakePivot;

import static frc.robot.util.PhoenixUtil.*;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.ParentDevice;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.filter.Debouncer;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;
import frc.robot.Configs.IntakeConfigs.IntakePivotConfig;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.intake.intakePivot.IntakePivotConstants;

public class IntakePivotIOTalonFX implements IntakePivotIO {
  private final TalonFX intakeLeaderMotor =
      new TalonFX(IntakePivotConstants.kLeaderID, TunerConstants.kCANBus);
  private final TalonFX intakeFollowerMotor =
      new TalonFX(IntakePivotConstants.kFollowerID, TunerConstants.kCANBus);

  private final VoltageOut voltageRequest = new VoltageOut(0.0);
  private final PositionVoltage positionRequest = new PositionVoltage(0.0);
  private final Follower followerRequest =
      new Follower(IntakePivotConstants.kLeaderID, MotorAlignmentValue.Aligned);

  private final StatusSignal<Angle> position = intakeLeaderMotor.getPosition();
  private final StatusSignal<AngularVelocity> velocity = intakeLeaderMotor.getVelocity();
  private final StatusSignal<Voltage> appliedVolts = intakeLeaderMotor.getMotorVoltage();
  private final StatusSignal<Current> current = intakeLeaderMotor.getStatorCurrent();

  private final Debouncer connectedDebounce = new Debouncer(0.5, Debouncer.DebounceType.kFalling);

  public IntakePivotIOTalonFX() {
    tryUntilOk(5, () -> intakeLeaderMotor.getConfigurator().apply(IntakePivotConfig.pivotConfig, 0.25));
    tryUntilOk(
        5, () -> intakeFollowerMotor.getConfigurator().apply(IntakePivotConfig.pivotConfig, 0.25));
    tryUntilOk(
        5,
        () -> intakeLeaderMotor.setPosition(IntakePivotConstants.PIVOT_STOW_ANGLE.getRotations(), 0.25));
    intakeFollowerMotor.setControl(followerRequest);

    BaseStatusSignal.setUpdateFrequencyForAll(50.0, position, velocity, appliedVolts, current);
    ParentDevice.optimizeBusUtilizationForAll(intakeLeaderMotor, intakeFollowerMotor);
  }

  @Override
  public void updateInputs(IntakePivotIOInputs inputs) {
    BaseStatusSignal.refreshAll(position, velocity, appliedVolts, current);

    inputs.connected = BaseStatusSignal.isAllGood(position, velocity, appliedVolts, current);
    inputs.position = Rotation2d.fromRotations(position.getValueAsDouble());
    inputs.velocity = velocity.getValue();
    inputs.voltage = appliedVolts.getValue();
    inputs.current = current.getValue();
  }

  @Override
  public void setVoltage(Voltage voltage) {
    intakeLeaderMotor.setControl(voltageRequest.withOutput(voltage));
  }

  @Override
  public void setPosition(Rotation2d position) {
    intakeLeaderMotor.setControl(
        positionRequest
            .withPosition(
                MathUtil.clamp(
                    position.getRotations(),
                    IntakePivotConstants.PIVOT_MIN_ANGLE.getRotations(),
                    IntakePivotConstants.PIVOT_MAX_ANGLE.getRotations()))
            .withFeedForward(IntakePivotConstants.kFF * IntakePivotConstants.kNominalVoltage));
  }
}

