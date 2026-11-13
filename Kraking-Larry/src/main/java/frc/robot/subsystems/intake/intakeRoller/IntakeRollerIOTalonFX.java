package frc.robot.subsystems.intake.intakeRoller;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.ParentDevice;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.math.util.Units;
import frc.robot.Configs.IntakeConfigs.IntakeRollerConfig;
import frc.robot.generated.TunerConstants;
import static frc.robot.util.PhoenixUtil.tryUntilOk;

public class IntakeRollerIOTalonFX implements IntakeRollerIO {
    private final TalonFX intakeLeaderMotor =
        new TalonFX(IntakeRollerConstants.kLeaderMotorID, TunerConstants.kCANBus);
    private final TalonFX intakeFollowerMotor =
        new TalonFX(IntakeRollerConstants.kFollowerMotorID, TunerConstants.kCANBus);

    private final VoltageOut voltageRequest = new VoltageOut(0.0);
    private final Follower followerRequest =
        new Follower(IntakeRollerConstants.kLeaderMotorID, MotorAlignmentValue.Aligned);
    private final StatusSignal<Angle> position = intakeLeaderMotor.getPosition();
    private final StatusSignal<AngularVelocity> velocity = intakeLeaderMotor.getVelocity();
    private final StatusSignal<Voltage> appliedVolts = intakeLeaderMotor.getMotorVoltage();
    private final StatusSignal<Current> current = intakeLeaderMotor.getStatorCurrent();

    public IntakeRollerIOTalonFX() {
        tryUntilOk(5, () -> intakeLeaderMotor.getConfigurator().apply(IntakeRollerConfig.rollerConfig, 0.25));
        tryUntilOk(
            5, () -> intakeFollowerMotor.getConfigurator().apply(IntakeRollerConfig.rollerConfig, 0.25));
        tryUntilOk(5, () -> intakeLeaderMotor.setPosition(0.0, 0.25));
        intakeFollowerMotor.setControl(followerRequest);

        BaseStatusSignal.setUpdateFrequencyForAll(50.0, position, velocity, appliedVolts, current);
        ParentDevice.optimizeBusUtilizationForAll(intakeLeaderMotor, intakeFollowerMotor);
    }

    @Override
    public void updateInputs(IntakeRollerIOInputs inputs) {
      BaseStatusSignal.refreshAll(position, velocity, appliedVolts, current);

      inputs.connected = BaseStatusSignal.isAllGood(position, velocity, appliedVolts, current);
      inputs.position = Units.rotationsToRadians(position.getValueAsDouble());
      inputs.velocity = velocity.getValue();
      inputs.voltage = appliedVolts.getValue();
      inputs.current = current.getValue();
    }

    @Override
    public void setVoltage(Voltage voltage) {
      intakeLeaderMotor.setControl(voltageRequest.withOutput(voltage));
    }
}
