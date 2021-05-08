// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.RunBucket;

/** Add your docs here. */
public class Bucket extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
    public static WPI_TalonFX bucketMotor = null;
    private boolean isBreaking = true;

    public Bucket() {
        bucketMotor = new WPI_TalonFX(Constants.BUCKET_MOTOR);



        bucketMotor.config_kP(0, 0.05);
        bucketMotor.config_kI(0,0);
        bucketMotor.config_kD(0,0.45);

        bucketMotor.setNeutralMode(NeutralMode.Brake);
        bucketMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
        bucketMotor.configPeakOutputForward(.1);
        bucketMotor.setSelectedSensorPosition(0);





    }

    public void runBucket(int position) {
        bucketMotor.set(ControlMode.Position,position);
//        bucketMotor.set(.2);
    }

    public void neutralBucket(){
        bucketMotor.set(ControlMode.Position,0);
    }

    public void toggleBrake(){
        if(isBreaking){
            bucketMotor.setNeutralMode(NeutralMode.Coast);
            isBreaking = false;
        } else{
            bucketMotor.setNeutralMode(NeutralMode.Brake);
            isBreaking = true;
        }
    }
    @Override
    public void periodic() {
        bucketMotor.feed();
    }
}
