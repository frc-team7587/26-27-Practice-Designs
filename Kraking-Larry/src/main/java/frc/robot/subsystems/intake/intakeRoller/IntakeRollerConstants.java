package frc.robot.subsystems.intake.intakeRoller;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.units.measure.Voltage;
import static edu.wpi.first.units.Units.Volts;

public class IntakeRollerConstants {
    public static final int kLeaderMotorID = 12;
    public static final int kFollowerMotorID = 19;

    public static final double kMinOutput = -1.0;
    public static final double kMaxOutput = 1.0;
    public static final double kNominalVoltage = 12.0;

    public static final Voltage kIntakeOutSpeed = Volts.of(-0.31 * kNominalVoltage);
    public static final Voltage kIntakeInSpeed = Volts.of(0.31 * kNominalVoltage);

    public static final DCMotor ROLLER_GEARBOX = DCMotor.getKrakenX44Foc(2);

    public static final double ROLLER_GEAR_RATIO = 1.0;

    public static final double ROLLER_MOI_KG_METERS_SQUARED = 0.004;
    }