package gyte.ooaad.mydailymemory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class TakePicture extends Activity {
	private static final String TAG = "TakePicture";

	public static final String IMAGE_PATH = "imagepath";

	private Preview preview;
	private Button buttonClick;
	private TextView nameView;
	int pictureId;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.takepicture);

		nameView = (TextView) findViewById(R.id.tp_name);

		preview = new Preview(this); // <3>
		preview.pm = getPackageManager();
		((FrameLayout) findViewById(R.id.preview)).addView(preview); // <4>

		buttonClick = (Button) findViewById(R.id.buttonClick);
		buttonClick.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				preview.camera.takePicture(null, null, jpegCallback);
			}
		});
	}

	public void onPause() {
		super.onPause();
		try {
			preview.camera.stopPreview();
			preview.camera.release();
		} catch (RuntimeException e) {

		}
	}

	PictureCallback jpegCallback = new PictureCallback() {
		public void onPictureTaken(byte[] data, Camera camera) {
			FileOutputStream outStream = null;
			String path = Environment.getExternalStorageDirectory()
					+ "/MyDailyMemory/" + Session.user.getUserId() + "/";
			Intent intent = new Intent();
			try {
				Bitmap bitmapOrg = BitmapFactory.decodeByteArray(data, 0,
						data.length);

				int width = bitmapOrg.getWidth();
				int height = bitmapOrg.getHeight();
				int newWidth = 320;
				int newHeight = 240;

				float scaleWidth = ((float) newWidth) / width;
				float scaleHeight = ((float) newHeight) / height;

				Matrix matrix = new Matrix();
				matrix.postScale(scaleWidth, scaleHeight);
				matrix.postRotate(270);
				Bitmap resizedBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0,
						width, height, matrix, true);

				File pictureDir = new File(path);
				pictureDir.mkdirs();
				pictureId = Session.user.getMemory().getDiaries().size();
				outStream = new FileOutputStream(path + pictureId + ".jpg");
				resizedBitmap.compress(CompressFormat.JPEG, 100, outStream);
				// outStream.write(data);
				outStream.close();
				intent.putExtra(IMAGE_PATH, path + pictureId + ".jpg");
				setResult(RESULT_OK, intent);
			} catch (FileNotFoundException e) { // <10>
				Log.e(TAG, "onPictureTaken: File not found");
				e.printStackTrace();
				setResult(RESULT_CANCELED);
			} catch (IOException e) {
				Log.e(TAG, "onPictureTaken: ioexception ");
				e.printStackTrace();
				setResult(RESULT_CANCELED);
			} finally {
				preview.camera.stopPreview();
				preview.camera.release();
				finish();
			}
		}
	};

	public void pictureSaved(String path) {
		if (path == null)
			setResult(RESULT_CANCELED);
		else {
			Intent intent = new Intent();
			intent.putExtra(IMAGE_PATH, path + pictureId + ".jpg");
			setResult(RESULT_OK, intent);
		}
		finish();
	}

}
