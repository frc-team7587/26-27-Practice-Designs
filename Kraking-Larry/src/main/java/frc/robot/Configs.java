package frc.robot;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import frc.robot.subsystems.intake.intakePivot.IntakePivotConstants;
import frc.robot.subsystems.intake.intakeRoller.IntakeRollerConstants;

public class Configs {
    private Configs() {}

    public static final class ConveyorConfig {

    }

    public static final class IntakeConfigs {
        public static final class IntakePivotConfig {
            public static final TalonFXConfiguration pivotConfig = new TalonFXConfiguration();

            static {
                pivotConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
                pivotConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
                pivotConfig.Feedback.SensorToMechanismRatio = IntakePivotConstants.PIVOT_GEAR_RATIO;
                pivotConfig.Slot0.kP = IntakePivotConstants.kP;
                pivotConfig.Slot0.kI = IntakePivotConstants.kI;
                pivotConfig.Slot0.kD = IntakePivotConstants.kD;
                pivotConfig.Voltage.PeakForwardVoltage = IntakePivotConstants.kMaxOutput * IntakePivotConstants.kNominalVoltage;
                pivotConfig.Voltage.PeakReverseVoltage = IntakePivotConstants.kMinOutput * IntakePivotConstants.kNominalVoltage;
                pivotConfig.CurrentLimits.StatorCurrentLimit = 80.0;
                pivotConfig.CurrentLimits.StatorCurrentLimitEnable = true;
            }
        }

        public static final class IntakeRollerConfig {
            public static final TalonFXConfiguration rollerConfig = new TalonFXConfiguration();

            static {
                rollerConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
                rollerConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
                rollerConfig.Feedback.SensorToMechanismRatio = IntakeRollerConstants.ROLLER_GEAR_RATIO;
                rollerConfig.Voltage.PeakForwardVoltage = IntakeRollerConstants.kMaxOutput * IntakeRollerConstants.kNominalVoltage;
                rollerConfig.Voltage.PeakReverseVoltage = IntakeRollerConstants.kMinOutput * IntakeRollerConstants.kNominalVoltage;
                rollerConfig.CurrentLimits.StatorCurrentLimit = 60.0;
                rollerConfig.CurrentLimits.StatorCurrentLimitEnable = true;
            }
        }
    }

    public static final class ShooterConfigs {
        public static final class ShooterFeederConfig {

        }

        public static final class ShooterFlywheelConfig {

        }

        public static final class ShooterPivotConfig {

        }
    }
}
