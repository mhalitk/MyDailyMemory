package gyte.ooaad.mydailymemory;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class WatchVideo extends Activity {

	private VideoView mVideoView;
	private static final String VIDEO_PATH = "VIDEO_PATH";
	private String videoPath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_watch_video);

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		videoPath = getIntent().getExtras().getString("VIDEO_PATH");

		mVideoView = (VideoView) findViewById(R.id.surface_view);
		mVideoView.setVideoPath(videoPath);
		mVideoView.setMediaController(new MediaController(this));
		mVideoView.requestFocus();
		mVideoView.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.watch_video, menu);
		return true;
	}

}
