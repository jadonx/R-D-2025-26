package org.firstinspires.ftc.teamcode.Lesson3Drivetrain;

/*
THIS PROGRAM DOES NOT CONTAIN CODE FOR FIELD CENTRIC DRIVE
IT JUST HAS CODE FOR SETTING UP THE IMU NEEDED
 */

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp(name="FieldCentricDrive")
public class FieldCentricDrive extends OpMode {
    DcMotor frontLeft, frontRight, backLeft, backRight;
    IMU imu;

    @Override
    public void init() {
        imu = hardwareMap.get(IMU.class, "imu");

        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.BACKWARD,
                RevHubOrientationOnRobot.UsbFacingDirection.UP));

        imu.initialize(parameters);
    }

    @Override
    public void loop() {
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rot = gamepad1.right_stick_x;

        double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);

        if (gamepad1.a) {
            imu.resetYaw();
        }

        telemetry.addData("Bot Rotation: ", botHeading);
        telemetry.update();
    }
}
