package frc.robot.subsystems.shooter;

import frc.robot.subsystems.intake.intakePivot.IntakePivotIOInputsAutoLogged;
import frc.robot.subsystems.intake.intakeRoller.IntakeRollerIOInputsAutoLogged;
import frc.robot.subsystems.shooter.shooterFeeder.ShooterFeederIO;
import frc.robot.subsystems.shooter.shooterFeeder.ShooterFeederIOInputsAutoLogged;
import frc.robot.subsystems.shooter.shooterFlywheel.ShooterFlywheelIO;
import frc.robot.subsystems.shooter.shooterFlywheel.ShooterFlywheelIOInputsAutoLogged;
import frc.robot.subsystems.shooter.shooterPivot.ShooterPivotIO;
import frc.robot.subsystems.shooter.shooterPivot.ShooterPivotIOInputsAutoLogged;

public class Shooter {
    private final ShooterFeederIO feederIO;
    private final ShooterFlywheelIO flywheelIO;
    private final ShooterPivotIO shooterIO;

    private final ShooterFeederIOInputsAutoLogged feederInputs = new ShooterFeederIOInputsAutoLogged();
    private final ShooterFlywheelIOInputsAutoLogged flywheelInputs = new ShooterFlywheelIOInputsAutoLogged();
    private final ShooterPivotIOInputsAutoLogged pivotInputs = new ShooterPivotIOInputsAutoLogged();

    public Shooter(ShooterFeederIO feederIO, ShooterFlywheelIO flywheelIO, ShooterPivotIO shooterIO) {
        this.feederIO = feederIO;
        this.flywheelIO = flywheelIO;
        this.shooterIO = shooterIO;
    }
}
