package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

@Autonomous(name = "moveForward")
public final class moveForwardAuto extends LinearOpMode {
    private Motor frontLeft;
    private Motor frontRight;
    private Motor backRight;
    private Motor backLeft;
    private static final double POWER_REDUCTION = 0.5;

    @Override
    public void runOpMode(){
        frontLeft = new Motor(hardwareMap, "fl");
        frontRight = new Motor(hardwareMap, "fr");
        backLeft = new Motor(hardwareMap, "bl");
        backRight = new Motor(hardwareMap, "br");
        frontLeft.setInverted(true);
        backLeft.setInverted(true);

        waitForStart();
        if (opModeIsActive()){
            frontLeft.set(0.5);
            frontRight.set(0.5);
            backLeft.set(0.5);
            backRight.set(0.5);
            sleep(700);
            frontLeft.set(0.0);
            frontRight.set(0.0);
            backLeft.set(0.0);
            backRight.set(0.0);
        }
    }
}
