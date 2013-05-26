package gyte.ooaad.mydailymemory;

import java.io.IOException;

import gyte.ooaad.application.ConcreteDiary;
import gyte.ooaad.application.Diary;
import gyte.ooaad.application.PhotoDiary;
import gyte.ooaad.application.SoundDiary;
import gyte.ooaad.application.VideoDiary;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DiaryDetail extends Activity {
	public static Diary currentDiary = null;

	private String videoPath;
	private String soundPath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diarydetail);

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		TextView username = (TextView) findViewById(R.id.top_username);
		username.setText(Session.user.getName());
		username.setVisibility(View.VISIBLE);

		Button leftButton = (Button) findViewById(R.id.top_leftButton);
		leftButton.setText("Geri");
		leftButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				onBackPressed();
			}
		});
		leftButton.setVisibility(View.VISIBLE);
	}

	@Override
	public void onResume() {
		super.onResume();

		TextView header = (TextView) findViewById(R.id.diarydetail_header);
		header.setText(currentDiary.getDate().getDate());

		while (!(currentDiary instanceof ConcreteDiary)) {
			if (currentDiary instanceof VideoDiary) {
				LinearLayout layout = (LinearLayout) findViewById(R.id.diarydetail_videosplitter1);
				layout.setVisibility(View.VISIBLE);

				TextView videoText = (TextView) findViewById(R.id.diarydetail_videotextview);
				videoText.setVisibility(View.VISIBLE);

				LinearLayout layout2 = (LinearLayout) findViewById(R.id.diarydetail_videosplitter2);
				layout2.setVisibility(View.VISIBLE);

				Button watchButton = (Button) findViewById(R.id.diarydetail_watch);
				watchButton.setVisibility(View.VISIBLE);
				videoPath = ((VideoDiary) currentDiary).getVideo().getMedia();

				currentDiary = ((VideoDiary) currentDiary).getDiary();
			}

			if (currentDiary instanceof PhotoDiary) {
				TextView imageText = (TextView) findViewById(R.id.diarydetail_imagetextview);
				imageText.setVisibility(View.VISIBLE);

				ImageView imageView = (ImageView) findViewById(R.id.diarydetail_image);
				imageView.setImageBitmap(BitmapFactory
						.decodeFile(((PhotoDiary) currentDiary).getPhoto()
								.getMedia()));
				imageView.setVisibility(View.VISIBLE);

				LinearLayout layout = (LinearLayout) findViewById(R.id.diarydetail_imagesplitter);
				layout.setVisibility(View.VISIBLE);
				currentDiary = ((PhotoDiary) currentDiary).getDiary();
			}

			if (currentDiary instanceof SoundDiary) {
				LinearLayout layout = (LinearLayout) findViewById(R.id.diarydetail_soundsplitter1);
				layout.setVisibility(View.VISIBLE);

				TextView soundText = (TextView) findViewById(R.id.diarydetail_soundtextview);
				soundText.setVisibility(View.VISIBLE);

				LinearLayout layout2 = (LinearLayout) findViewById(R.id.diarydetail_soundsplitter2);
				layout2.setVisibility(View.VISIBLE);

				Button listenButton = (Button) findViewById(R.id.diarydetail_listen);
				listenButton.setVisibility(View.VISIBLE);

				soundPath = ((SoundDiary) currentDiary).getSound().getMedia();

				currentDiary = ((SoundDiary) currentDiary).getDiary();
			}
		}

		TextView text = (TextView) findViewById(R.id.diarydetail_text);
		text.setText(((ConcreteDiary) currentDiary).getText().getMedia());
	}

	public void listen(View view) {
		MediaPlayer mp = new MediaPlayer();
		try {
			mp.setDataSource(soundPath);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mp.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mp.start();
	}

	public void watch(View view) {
		// TODO Video will play here
		Intent intent = new Intent(DiaryDetail.this, WatchVideo.class);
		intent.putExtra("VIDEO_PATH", videoPath);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.diarydetail, menu);
		return true;
	}

}
