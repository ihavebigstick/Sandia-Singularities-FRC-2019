/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Add your docs here.
 * For the dumb people: this makes the robot drive... yay.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static final XboxController logitech1 = new XboxController(0);
  private static final PWMVictorSPX motor1 = new PWMVictorSPX(0);
  private static final PWMVictorSPX motor2 = new PWMVictorSPX(1);
  private static final PWMVictorSPX motor3 = new PWMVictorSPX(2);
  private static final PWMVictorSPX motor4 = new PWMVictorSPX(3);
  SpeedControllerGroup leftmotors = new SpeedControllerGroup(motor1, motor2);
  SpeedControllerGroup rightmotors = new SpeedControllerGroup(motor3, motor4);
  DifferentialDrive maindrive = new DifferentialDrive(leftmotors, rightmotors);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void driveSystem() {
    double analogLY = logitech1.getY(Hand.kLeft);
    double analogLX = logitech1.getX(Hand.kLeft);
    double forwardDrive = analogLY * -1;
    maindrive.arcadeDrive(forwardDrive, analogLX);
  }
}
