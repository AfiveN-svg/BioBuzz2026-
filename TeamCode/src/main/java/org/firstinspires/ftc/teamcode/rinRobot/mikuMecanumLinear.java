package org.firstinspires.ftc.teamcode.rinRobot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class mikuMecanumLinear extends LinearOpMode {
    sFMikiServo tetoMiku = new sFMikiServo();
    private boolean tetoToggle = false;
    private boolean tetoStatePrevious = false;
    private boolean mikuToggle = false;
    private boolean mikuStatePrevious = false;

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor leftBackMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");
        DcMotor leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        DcMotor rightBackMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");
        DcMotor rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");
        DcMotor tetoIntake = hardwareMap.get(DcMotor.class, "tetoIntake");
        DcMotor mikuOuttake = hardwareMap.get(DcMotor.class, "tetoOuttake");
        tetoMiku.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            double x = gamepad1.left_stick_x * 1.1;
            double y = -gamepad1.left_stick_y;
            double z = gamepad1.right_stick_x * 1.2;

            double leftFrontPow = x + y + z;
            double leftbackPow = -x + y + z;
            double rightFrontPow = -x + y - z;
            double rightBackPow = x + y - z;
            boolean tetoStateCurrent = gamepad1.dpad_down;
            boolean mikuStateCurrent = gamepad1.b;

            leftFrontMotor.setPower(leftFrontPow / 2);
            leftBackMotor.setPower(leftbackPow / 2);
            rightFrontMotor.setPower(rightFrontPow / 2);
            rightBackMotor.setPower(rightBackPow / 2);
            if (tetoStateCurrent && !tetoStatePrevious) {
                tetoToggle = !tetoToggle;
            }
            tetoStatePrevious = tetoStateCurrent;
            if (tetoToggle) {
                tetoIntake.setPower(1);

            } else {
                tetoIntake.setPower(0);
            }

            if (mikuStateCurrent && !mikuStatePrevious) {
                mikuToggle = !mikuToggle;
            }
            mikuStatePrevious = mikuStateCurrent;
            if (mikuToggle) {
                mikuOuttake.setPower(-.7);
                sleep(1000);
                tetoMiku.setMikuServoPosition(.25);
                tetoMiku.setTetoServoPosition(-.25);
            } else {
                mikuOuttake.setPower(0);
                tetoMiku.setMikuServoPosition(0);
                tetoMiku.setTetoServoPosition(0);
            }
        }
    }
}
