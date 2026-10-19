package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

@TeleOp(name = "oneMotorTest")
public final class oneMotorTest extends OpMode {
    private Motor intakeMotor;
    private Motor outtakeMotor;
    private Motor outtakeMotor2;
    private Motor frontLeft;
    private Motor frontRight;
    private Motor backRight;
    private Motor backLeft;
    private GamepadEx gp1;


    @Override
    public void init() {
        intakeMotor = new Motor(hardwareMap, "intakeMotor");
        outtakeMotor = new Motor(hardwareMap, "outtakeMotor");
        outtakeMotor2 = new Motor(hardwareMap, "outtakeMotor2");
        frontLeft = new Motor(hardwareMap, "fl");
        frontRight = new Motor(hardwareMap, "fr");
        backLeft = new Motor(hardwareMap, "bl");
        backRight = new Motor(hardwareMap, "br");
        //frontRight.setInverted(true);
        //backRight.setInverted(true);
        gp1 = new GamepadEx(gamepad1);
    }

    @Override
    public void loop(){
        //--  drivetrain  --
        double y  = applyDeadzone(gp1.getLeftY());   // forward/back
        double x  =  -applyDeadzone(gp1.getLeftX());   // strafe
        double rx =  applyDeadzone(gp1.getRightX());  // rotate

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

        double frontLeftPower  = (y + x + rx) / denominator;
        double backLeftPower   = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower  = (y + x - rx) / denominator;
        double rightCorrection = 0.935;

        frontRightPower *= rightCorrection;
        backRightPower  *= rightCorrection;

        frontLeft.set(-frontLeftPower);
        backLeft.set(-backLeftPower);
        frontRight.set(frontRightPower);
        backRight.set(backRightPower);

        //--  intake  --
        boolean intakePower2 = gamepad1.left_bumper;
        boolean intakePower = gamepad1.right_bumper;
        if(intakePower){
            intakeMotor.set(-1.0);
        } else if(intakePower2){
            intakeMotor.set(1.0);
        } else {
            intakeMotor.set(0);
        }

        //--  outtake --
        double outtakePower = gamepad1.left_trigger;
        double outtakePower2 = gamepad1.right_trigger;

        if(outtakePower > 0){
            outtakeMotor.set(1.0);
            outtakeMotor2.set(-1.0);
        } else if(outtakePower2 > 0){
            outtakeMotor.set(-1.0);
            outtakeMotor2.set(1.0);
        } else {
            outtakeMotor.set(0.0);
            outtakeMotor2.set(0.0);
        }
    }

    private double applyDeadzone(double value) {
        return Math.abs(value) > 0.3 ? value : 0.0;
    }
}
