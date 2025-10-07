package org.firstinspires.ftc.teamcode.Lesson1OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="SimpleMotorControlProgram")
public class SimpleMotorControlProgram extends OpMode {

    // We are declaring our motor variable, it is of type DcMotor and it is named motor1
    DcMotor motor1;


    // Every OpMode must have init and loop, it is mandatory
    @Override
    public void init() {
        // We are initializing our motor1 variable
        // We use the built-in hardwareMap object to grab the actual hardware and assign it to our variable

        motor1 = hardwareMap.get(DcMotor.class, "frontLeft");
    }

    // This is continuously run once our program starts
    @Override
    public void loop() {
        // Simple logic for turning motor on and off

        if (gamepad1.a) {
            motor1.setPower(1);
        }
        else {
            motor1.setPower(0);
        }
    }
}
