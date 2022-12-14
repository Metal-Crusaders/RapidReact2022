// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SlowMode extends CommandBase {
  private boolean isSlow = false;
  private boolean isFinished = false;
  
  /** Creates a new SlowMode. */
  public SlowMode() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    if (isSlow == false) {
      ArcadeDrive.setSpeed(0.45); //0.4 seems to be too slow, 0.5 is okay, testing 0.45 
      TankDrive.setSpeed(0.45);
      isSlow = true;              //(0.45 with shooter doesn't move, so choosing 0.5)
      isFinished = true;
    } else if (isSlow == true) {
      ArcadeDrive.setSpeed(1);
      TankDrive.setSpeed(1);
      isSlow = false;
      isFinished = true;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("isSlow", isSlow);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
}
