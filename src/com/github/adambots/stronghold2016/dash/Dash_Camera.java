package com.github.adambots.stronghold2016.dash;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.FlipAxis;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ROI;
import com.ni.vision.NIVision.ShapeMode;

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
			System.out.println("cam0 " + e.toString());
		}
		try {
			sessionback = NIVision.IMAQdxOpenCamera("cam1",
					NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		} catch (Exception e) {
			System.out.println("cam1 " + e.toString());
		}

		currSession = sessionfront;

		try {
			NIVision.IMAQdxConfigureGrab(currSession);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void cameras(boolean toggle) {
		NIVision.Rect rect = new NIVision.Rect(300, 200, 100, 100);
		NIVision.Rect rect2 = new NIVision.Rect(298, 198, 104, 104);
		if (toggle) {
			if (currSession != 0 && currSession == sessionfront) {
				try {
					NIVision.IMAQdxStopAcquisition(currSession);
					currSession = sessionback;
					NIVision.IMAQdxConfigureGrab(currSession);
					rect.write();
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			} else if (currSession != 0 && currSession == sessionback) {
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
			if (currSession == sessionback) {
				NIVision.imaqFlip(frame, frame, FlipAxis.HORIZONTAL_AXIS);
				NIVision.imaqDrawShapeOnImage(frame, frame, rect, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_RECT, 1);
				NIVision.imaqDrawShapeOnImage(frame, frame, rect2, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_RECT, 1);
			}

			CameraServer.getInstance().setImage(frame);

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
