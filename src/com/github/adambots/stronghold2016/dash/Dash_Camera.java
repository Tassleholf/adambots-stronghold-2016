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
		try {
			sessionfront = NIVision.IMAQdxOpenCamera("cam0",
					NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		try {
			sessionback = NIVision.IMAQdxOpenCamera("cam1",
					NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		currSession = sessionfront;
		try {
			NIVision.IMAQdxConfigureGrab(currSession);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void cameras(boolean toggle) {
		if (toggle) {
			if (currSession == sessionfront) {
				try {
					NIVision.IMAQdxStopAcquisition(currSession);
					currSession = sessionback;
					NIVision.IMAQdxConfigureGrab(currSession);
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			} else if (currSession == sessionback) {
				try {
					NIVision.IMAQdxStopAcquisition(currSession);
					currSession = sessionfront;
					NIVision.IMAQdxConfigureGrab(currSession);
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		}
		try {
			NIVision.IMAQdxGrab(currSession, frame, 1);
			CameraServer.getInstance().setImage(frame);

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
