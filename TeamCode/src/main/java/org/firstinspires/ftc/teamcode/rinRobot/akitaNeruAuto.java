package org.firstinspires.ftc.teamcode.rinRobot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous
public class akitaNeruAuto extends LinearOpMode {
    private DcMotor rightBackMotor;
    private DcMotor leftFrontMotor;
    private DcMotor rightFrontMotor;
    // private sFMikiServo tetoKS = new sFMikiServo();
    private DcMotorEx tetoIntake;
    ElapsedTime runtime;
    double tetoTurn = 1;
    double mikuForward = .5;
    double mikuback = -.5;
    double shoot = -1;
    double on = .25;

    @Override
    public void runOpMode() {
        DcMotor leftBackMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");
        DcMotor leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        DcMotor rightBackMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");
        DcMotor rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");
        DcMotorEx tetoIntake = hardwareMap.get(DcMotorEx.class, "tetoIntake");
        DcMotor mikuOuttake = hardwareMap.get(DcMotor.class, "tetoOuttake");
        // tetoMiku.init(hardwareMap);
        Servo tetoServo = hardwareMap.get(Servo.class, "tetoServo");
        Servo mikuServo = hardwareMap.get(Servo.class, "mikuServo");
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);
        runtime = new ElapsedTime();
        waitForStart();

        while (opModeIsActive() && (runtime.seconds() <= 1)){
            leftFrontMotor.setPower(mikuForward);
            leftBackMotor.setPower(-mikuForward);
            rightBackMotor.setPower(mikuForward);
            rightFrontMotor.setPower(mikuForward);
        }
            while (opModeIsActive() && runtime.seconds() > 1 && runtime.seconds() <= 3) {
                mikuOuttake.setPower(shoot);
                tetoServo.setPosition(-on);
            }

        while (opModeIsActive() && runtime.seconds() > 3 && runtime.seconds() <= 5.5) {
            tetoServo.setPosition(0);
            mikuServo.setPosition(on);
        }
        while (opModeIsActive() && runtime.seconds() > 5.5 && runtime.seconds() <= 6.3) {
            mikuServo.setPosition(0);
            leftFrontMotor.setPower(mikuForward);
            leftBackMotor.setPower(-mikuForward);
            rightBackMotor.setPower(mikuForward);
            rightFrontMotor.setPower(-mikuForward);
        }
        while (opModeIsActive() && runtime.seconds() > 6.3 && runtime.seconds() <= 9.5) {
            leftFrontMotor.setPower(-mikuForward);
            leftBackMotor.setPower(mikuForward);
            rightBackMotor.setPower(-mikuForward);
            rightFrontMotor.setPower(mikuForward);
        }
        while (opModeIsActive() && runtime.seconds() > 9.5 && runtime.seconds() <= 10) {
            leftFrontMotor.setPower(mikuForward);
            leftBackMotor.setPower(-mikuForward);
            rightBackMotor.setPower(mikuForward);
            rightFrontMotor.setPower(-mikuForward);
        }
        }
    }
