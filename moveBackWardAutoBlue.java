package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

@Autonomous(name = "moveBackwardBlue")
public final class moveBackWardAutoBlue extends LinearOpMode {
    private Motor frontLeft;
    private Motor frontRight;
    private Motor backRight;
    private Motor backLeft;
    private Motor outtakeMotor1;
    private Motor outtakeMotor2;
    private Motor intakeMotor;

    @Override
    public void runOpMode(){
        frontLeft = new Motor(hardwareMap, "fl");
        frontRight = new Motor(hardwareMap, "fr");
        backLeft = new Motor(hardwareMap, "bl");
        backRight = new Motor(hardwareMap, "br");
        frontLeft.setInverted(true);
        backLeft.setInverted(true);

        intakeMotor = new Motor(hardwareMap, "intakeMotor");
        outtakeMotor1 = new Motor(hardwareMap, "outtakeMotor");
        outtakeMotor2 = new Motor(hardwareMap, "outtakeMotor2");

        waitForStart();
        if (opModeIsActive()){
            frontLeft.set(-0.5);
            frontRight.set(-0.5);
            backLeft.set(-0.5);
            backRight.set(-0.5);
            sleep(900);
            frontLeft.set(0.0);
            frontRight.set(0.0);
            backLeft.set(0.0);
            backRight.set(0.0);
            outtakeMotor1.set(1.0);
            outtakeMotor2.set(-1.0);
            sleep(2500);
            intakeMotor.set(-1.0);
            sleep(4000);
            outtakeMotor1.set(0.0);
            outtakeMotor2.set(0.0);
            intakeMotor.set(0.0);
//            frontRight.set(-0.5);
//            backRight.set(-0.5);
//            frontLeft.set(0.5);
//            backLeft.set(0.5);
//            sleep(1000);
//            frontRight.set(0.0);
//            backRight.set(0.0);
//            frontLeft.set(0.0);
//            backLeft.set(0.0);
        }
    }
}
