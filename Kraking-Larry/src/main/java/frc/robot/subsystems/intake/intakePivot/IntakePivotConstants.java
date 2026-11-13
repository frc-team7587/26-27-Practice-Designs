package frc.robot.subsystems.intake.intakePivot;

import edu.wpi.first.units.measure.Voltage;
import static edu.wpi.first.units.Units.Volts;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;

public class IntakePivotConstants {
    private IntakePivotConstants() {}

    public static final int kLeaderID = 11;
    public static final int kFollowerID = 10;

    public static final double kMinOutput = -0.4;
    public static final double kMaxOutput = 0.4;
    public static final double kNominalVoltage = 12.0;

    public static final Voltage kPivotSpeedDown = Volts.of(0.12 * kNominalVoltage);
    public static final Voltage kPivotSpeedUp = Volts.of(-0.18 * kNominalVoltage);

    public static final double kP = 0.07;
    public static final double kI = 0.0;
    public static final double kD = 0.0;
    public static final double kFF = 0.00375;

    //estimated values for the pivot
    public static final DCMotor PIVOT_GEARBOX = DCMotor.getKrakenX60Foc(1);
    public static final double PIVOT_GEAR_RATIO = 60.0;

    public static final double PIVOT_LENGTH_METERS = 0.45;
    public static final double PIVOT_MASS_KG = 4.5;

    public static final Rotation2d PIVOT_MIN_ANGLE = Rotation2d.fromDegrees(-95.0);
    public static final Rotation2d PIVOT_MAX_ANGLE = Rotation2d.fromDegrees(0.0);
    public static final Rotation2d PIVOT_STOW_ANGLE = Rotation2d.fromDegrees(0.0);
    public static final Rotation2d PIVOT_DEPLOY_ANGLE = Rotation2d.fromDegrees(-55.0);
}
