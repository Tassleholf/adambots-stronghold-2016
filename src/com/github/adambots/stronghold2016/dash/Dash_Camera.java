package com.github.adambots.stronghold2016.dash;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;

public class Dash_Camera {
	static int currSession;
	static int sessionfront;
	static int sessionback;
	static Image frame;

	public static void camerasInit() {
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		sessionfront = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		sessionback = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		currSession = sessionfront;
		NIVision.IMAQdxConfigureGrab(currSession);
	}

	public static void cameras(boolean toggle) {
		if (toggle) {
			if (currSession == sessionfront) {
				NIVision.IMAQdxStopAcquisition(currSession);
				currSession = sessionback;
				NIVision.IMAQdxConfigureGrab(currSession);
			} else if (currSession == sessionback) {
				NIVision.IMAQdxStopAcquisition(currSession);
				currSession = sessionfront;
				NIVision.IMAQdxConfigureGrab(currSession);
			}
		}
		NIVision.IMAQdxGrab(currSession, frame, 1);
		CameraServer.getInstance().setImage(frame);
	}
}
