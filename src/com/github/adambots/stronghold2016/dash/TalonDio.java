package com.github.adambots.stronghold2016.dash;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDeviceStatus;

public class TalonDio {
	public static String talonEncodDio(CANTalon cT1) {
		FeedbackDeviceStatus status = cT1.isSensorPresent(FeedbackDevice.CtreMagEncoder_Absolute);
		String out = "";
		switch (status) {
		case FeedbackStatusPresent:
			out = "Present";
			break;
		case FeedbackStatusNotPresent:
			out = "NotPresent";
			break;
		case FeedbackStatusUnknown:
			out = "Unknown";
			break;
		}
		return out;
	}

	public static boolean talonConectionDio(CANTalon CANTalon1) {
		double outputCurrent = CANTalon1.getOutputCurrent();
		boolean connected = false;
		if (outputCurrent >= 0) {
			connected = true;
		}
		return connected;

	}
}
