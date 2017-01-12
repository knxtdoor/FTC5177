package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by knxtd on 1/12/2017.
 */



    /**
     * This is NOT an opmode.
     *
     * This class can be used to define all the specific hardware for a single robot.
     * In this case that robot is a K9 robot.
     *
     * This hardware class assumes the following device names have been configured on the robot:
     * Note:  All names are lower case and some have single spaces between words.
     *
     * Motor channel:  Left  drive motor:        "left motor"
     * Motor channel:  Right drive motor:        "right motor"
     * Servo channel:  Servo to raise/lower arm: "arm"
     * Servo channel:  Servo to open/close claw: "claw"
     *
     * Note: the configuration of the servos is such that:
     *   As the arm servo approaches 0, the arm position moves up (away from the floor).
     *   As the claw servo approaches 0, the claw opens up (drops the game element).
     */
    public class Hardware4232
    {
        /* Public OpMode members. */
        public DcMotor leftMotor   = null;
        public DcMotor  rightMotor  = null;
        public Servo beacon = null;
        public Servo leftball = null;
        public Servo rightball = null;
        public Servo leftflipper = null;
        public Servo rightflipper = null;


        /* Local OpMode members. */
        HardwareMap hwMap  = null;
        private ElapsedTime period  = new ElapsedTime();

        /* Constructor */
        public Hardware4232() {
        }

        /* Initialize standard Hardware interfaces */
        public void init(HardwareMap ahwMap) {
            // save reference to HW Map
            hwMap = ahwMap;
            // groundSensor = hwMap.colorSensor.get("ground color sensor");
            //pokerColor = hwMap.colorSensor.get("poker color sensor");
            //gyro = (ModernRoboticsI2cGyro)hwMap.gyroSensor.get("gyro");
            // Define and Initialize Motors
            leftMotor   = hwMap.dcMotor.get("left motor");
            rightMotor  = hwMap.dcMotor.get("right motor");
            beacon = hwMap.servo.get("beacon");


            leftball = hwMap.servo.get("leftcap");
            rightball = hwMap.servo.get("rightcap");

            leftflipper = hwMap.servo.get("leftflipper");
            rightflipper = hwMap.servo.get("rightflipper");
            rightMotor.setDirection(DcMotor.Direction.REVERSE);

            // Set all motors to zero power
            leftMotor.setPower(0);
            rightMotor.setPower(0);

            // Set all motors to run without encoders.
            // May want to use RUN_USING_ENCODERS if encoders are installed.
            leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



            // Define and initialize ALL installed servos.

        }

        /***
         *
         * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
         * periodic tick.  This is used to compensate for varying processing times for each cycle.
         * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
         *
         * @param periodMs  Length of wait cycle in mSec.
         * @throws InterruptedException
         */
        public void waitForTick(long periodMs)  throws InterruptedException {

            long  remaining = periodMs - (long)period.milliseconds();

            // sleep for the remaining portion of the regular cycle period.
            if (remaining > 0)
                Thread.sleep(remaining);

            // Reset the cycle clock for the next pass.
            period.reset();
        }
    }

