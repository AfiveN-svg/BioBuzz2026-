package org.firstinspires.ftc.teamcode.rinRobot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.lang.Object;
import java.time.Duration;
//import com.qualcomm.robotcore.hardware.DcMotorEx;*/

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class mikuMechanum extends OpMode {
        private boolean tetoToggle = false;
        private boolean tetoStatePrevious = false;
        private boolean mikuToggle = false;
        private boolean mikuStatePrevious = false;
    private boolean neruStatePrevious = false;
    private boolean neruToggle = false;

   private DcMotor lBMotor;
    private DcMotor lFMotor;
    private DcMotor rBMotor;
    private DcMotor rFMotor;
    private DcMotor Intake;
    private DcMotor Outtake;
    private Servo sLServo;
    private Servo sRServo;
    private Servo bLServo;
    private Servo bRServo;
    @Override
    public void init() {
        lBMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");
         lFMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
         rBMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");
         rFMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");
         Intake = hardwareMap.get(DcMotor.class, "tetoIntake");
         Outtake = hardwareMap.get(DcMotor.class, "tetoOuttake");
        sLServo = hardwareMap.get(Servo.class, "mikuServo");
        sRServo = hardwareMap.get(Servo.class, "tetoServo");
        sRServo.setDirection(Servo.Direction.REVERSE);
        bLServo = hardwareMap.get(Servo.class, "neruServo");
        bRServo = hardwareMap.get(Servo.class, "gumiServo");
        bRServo.setDirection(Servo.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double x = gamepad1.left_stick_x * 1.1;
        double y = -gamepad1.left_stick_y;
        double z = gamepad1.right_stick_x/1.2;

        double leftFrontPow = x + y + z;
        double leftBackPow = -x + y + z;
        double rightFrontPow = -x + y - z;
        double rightBackPow = x + y - z;
        boolean tetoStateCurrent = gamepad1.dpad_down;
        boolean mikuStateCurrent = gamepad1.b;
        boolean neruStateCurrent = gamepad1.a;

        lFMotor.setPower(leftFrontPow);
        lBMotor.setPower(leftBackPow);
        rFMotor.setPower(rightFrontPow);
        rBMotor.setPower(rightBackPow);

        if (tetoStateCurrent && !tetoStatePrevious) {
            tetoToggle = !tetoToggle;
        }
        tetoStatePrevious = tetoStateCurrent;
        if (tetoToggle) {
            Intake.setPower(1);

        } else {
            Intake.setPower(0);
        }

        if (mikuStateCurrent && !mikuStatePrevious) {
            mikuToggle = !mikuToggle;
        }
        mikuStatePrevious= mikuStateCurrent;
        if (mikuToggle) {
            Outtake.setPower(-.7);

        } else {
            Outtake.setPower(0);
        }
        if (gamepad1.right_trigger > .5) {
            sLServo.setPosition(.25);
            sRServo.setPosition(.25);
            bLServo.setPosition(-.25);
            bRServo.setPosition(-.25);
        }
        else {

            sLServo.setPosition(0);
            sRServo.setPosition(0);
            bLServo.setPosition(0);
            bRServo.setPosition(0);
        }
        if ( neruStateCurrent && !neruStatePrevious) {
            neruToggle = !neruToggle;
        }
        tetoStatePrevious = tetoStateCurrent;
        if(!neruToggle) {

            lFMotor.setPower(leftFrontPow / 1.2);
            lBMotor.setPower(leftBackPow / 1.2);
            rFMotor.setPower(rightFrontPow / 1.2);
            rBMotor.setPower(rightBackPow / 1.2);
        }
        else {
            lFMotor.setPower(leftFrontPow / 1.5);
            lBMotor.setPower(leftBackPow / 1.5);
            rFMotor.setPower(rightFrontPow / 1.5);
            rBMotor.setPower(rightBackPow / 1.5);
        }
    }
}
