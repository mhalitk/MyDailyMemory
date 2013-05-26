package gyte.ooaad.mydailymemory;

import gyte.ooaad.application.ConcreteDiary;
import gyte.ooaad.application.Date;
import gyte.ooaad.application.Diary;
import gyte.ooaad.application.Photo;
import gyte.ooaad.application.PhotoDiary;
import gyte.ooaad.application.Sound;
import gyte.ooaad.application.SoundDiary;
import gyte.ooaad.application.Text;
import gyte.ooaad.application.Video;
import gyte.ooaad.application.VideoDiary;
import gyte.ooaad.database.MemoryDatabaseHelper;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewMemory extends Activity {

	private static final int PHOTO = 444;
	private static final int SOUND = 445;
	private static final int VIDEO = 446;
	private static String imagePath = null;
	private static String soundPath = null;
	private static String videoPath = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newmemory);

		TextView username = (TextView) findViewById(R.id.top_username);
		username.setText(Session.user.getName());

		Button leftButton = (Button) findViewById(R.id.top_leftButton);
		leftButton.setText("Ýptal");
		leftButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
		leftButton.setVisibility(View.VISIBLE);

		Button rightButton = (Button) findViewById(R.id.top_rightButton);
		rightButton.setText("Kaydet");
		rightButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				save();
			}
		});
		rightButton.setVisibility(View.VISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.newmemory, menu);
		return true;
	}

	private void save() {
		// TODO Kayýt için yapýlacaklar
		TextView date = (TextView) findViewById(R.id.newmemory_date);
		TextView text = (TextView) findViewById(R.id.newmemory_text);

		MemoryDatabaseHelper memoryDBHelp = new MemoryDatabaseHelper(
				NewMemory.this);

		Diary diaryInstance = new ConcreteDiary();
		diaryInstance.setDate(new Date(date.getText().toString()));
		((ConcreteDiary) diaryInstance).setText(new Text(text.getText()
				.toString()));

		if (soundPath != null) {
			diaryInstance = new SoundDiary(diaryInstance);
			((SoundDiary) diaryInstance).setSound(new Sound(soundPath));
		}

		if (imagePath != null) {
			diaryInstance = new PhotoDiary(diaryInstance);
			((PhotoDiary) diaryInstance).setPhoto(new Photo(imagePath));
		}

		if (videoPath != null) {
			diaryInstance = new VideoDiary(diaryInstance);
			((VideoDiary) diaryInstance).setVideo(new Video(videoPath));
		}

		memoryDBHelp.addDiary(Session.user, diaryInstance);
		onBackPressed();
	}

	public void addPicture(View view) {
		Intent intent = new Intent(NewMemory.this, TakePicture.class);
		startActivityForResult(intent, PHOTO);
	}

	public void addSound(View view) {
		Intent intent = new Intent(NewMemory.this, RecordSound.class);
		startActivityForResult(intent, SOUND);
	}

	public void addVideo(View view) {
		Intent intent = new Intent(NewMemory.this, CaptureVideo.class);
		startActivityForResult(intent, VIDEO);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case PHOTO:
			if (resultCode == RESULT_OK) {
				imagePath = data.getStringExtra(TakePicture.IMAGE_PATH);
				Toast.makeText(this, "Resim eklendi", Toast.LENGTH_LONG).show();
			}
			break;
		case SOUND:
			if (resultCode == RESULT_OK) {
				soundPath = data.getStringExtra(RecordSound.SOUND_PATH);
				Toast.makeText(this, "Ses eklendi", Toast.LENGTH_LONG).show();
			}
			break;
		case VIDEO:
			if (resultCode == RESULT_OK) {
				videoPath = data.getStringExtra(CaptureVideo.VIDEO_PATH);
				Toast.makeText(this, "Video eklendi", Toast.LENGTH_LONG).show();
			}
			break;
		}
	}

}
