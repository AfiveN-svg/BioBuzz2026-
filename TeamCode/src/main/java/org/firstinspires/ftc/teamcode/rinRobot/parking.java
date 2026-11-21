package org.firstinspires.ftc.teamcode.rinRobot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous
public class parking extends LinearOpMode {
    ElapsedTime runtime;
    double tetoTurn = 1;
    double mikuForward = 1;
    double mikuback = -.5;
    double shoot = -1;
    double on = .25;

    @Override
    public void runOpMode() {
        DcMotor leftBackMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");
        DcMotor leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        DcMotor rightBackMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");
        DcMotor rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");

        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);
        runtime = new ElapsedTime();
        waitForStart();

        while (opModeIsActive() && (runtime.seconds() <= .5)) {
            leftFrontMotor.setPower(mikuForward);
            leftBackMotor.setPower(-mikuForward);
            rightBackMotor.setPower(mikuForward);
            rightFrontMotor.setPower(mikuForward);
        }
    }
}
