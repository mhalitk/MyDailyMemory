package gyte.ooaad.mydailymemory;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class RecordSound extends Activity {

	MediaRecorder recorder;
	File audiofile = null;
	private static final String TAG = "SoundRecordingActivity";
	public static final String SOUND_PATH = "soundpath";
	private String soundPath;
	private View startButton;
	private View stopButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_record_sound);
		startButton = findViewById(R.id.start);
		stopButton = findViewById(R.id.stop);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.record_sound, menu);
		return true;
	}

	public void startRecording(View view) throws IOException {

		startButton.setEnabled(false);
		stopButton.setEnabled(true);

		String path = Environment.getExternalStorageDirectory()
				+ "/MyDailyMemory/" + Session.user.getUserId() + "/";

		File sampleDir = new File(path);
		try {
			audiofile = File.createTempFile("sound", ".3gp", sampleDir);
		} catch (IOException e) {
			Log.e(TAG, "sdcard access error");
			return;
		}
		recorder = new MediaRecorder();
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		recorder.setOutputFile(audiofile.getAbsolutePath());
		soundPath = audiofile.getAbsolutePath();
		recorder.prepare();
		recorder.start();
	}

	public void stopRecording(View view) {
		startButton.setEnabled(true);
		stopButton.setEnabled(false);
		recorder.stop();
		recorder.release();
		addRecordingToMediaLibrary();

		Intent intent = new Intent();
		intent.putExtra(SOUND_PATH, soundPath);
		setResult(RESULT_OK, intent);

		finish();
	}

	protected void addRecordingToMediaLibrary() {
		ContentValues values = new ContentValues(4);
		long current = System.currentTimeMillis();
		values.put(MediaStore.Audio.Media.TITLE, "audio" + audiofile.getName());
		values.put(MediaStore.Audio.Media.DATE_ADDED, (int) (current / 1000));
		values.put(MediaStore.Audio.Media.MIME_TYPE, "audio/3gpp");
		values.put(MediaStore.Audio.Media.DATA, audiofile.getAbsolutePath());
		ContentResolver contentResolver = getContentResolver();

		Uri base = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
		Uri newUri = contentResolver.insert(base, values);

		sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, newUri));
	}
}