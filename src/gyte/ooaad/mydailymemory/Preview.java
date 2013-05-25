package gyte.ooaad.mydailymemory;

import java.io.IOException;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Preview extends SurfaceView implements SurfaceHolder.Callback { // <1>
	private static final String TAG = "Preview";

	SurfaceHolder mHolder;
	public Camera camera;
	public PackageManager pm;

	public Preview(Context context) {
		super(context);

		mHolder = getHolder();
		mHolder.addCallback(this);
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

	}

	public void surfaceCreated(SurfaceHolder holder) {
		camera = null;
		try {
			CameraInfo camInfo = new CameraInfo();
			for (int i = 0; i < Camera.getNumberOfCameras(); ++i) {
				Camera.getCameraInfo(i, camInfo);
				if (camInfo.facing == CameraInfo.CAMERA_FACING_BACK)
					camera = Camera.open(i);
			}
			if (camera == null)
				camera = Camera.open();
			camera.setPreviewDisplay(holder);
			camera.setDisplayOrientation(90);
			camera.startPreview();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void surfaceDestroyed(SurfaceHolder holder) {

	}

	public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {

	}
}