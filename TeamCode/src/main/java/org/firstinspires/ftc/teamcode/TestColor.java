package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by knxtd on 1/10/2017.
 */

public class TestColor extends OpMode{
ProgbotHardware robot = new ProgbotHardware();


    @Override
    public void init(){
        telemetry.addData("Color Sensor Test", "Init");
        telemetry.update();
    }
    @Override
    public void loop(){
        telemetry.addData("Red",robot.pokerColor.red());
        telemetry.addData("Blue",robot.pokerColor.blue());
        telemetry.addData("Green",robot.pokerColor.green());
        telemetry.addData("Alpha", robot.pokerColor.alpha());
        telemetry.update();

    }

}
