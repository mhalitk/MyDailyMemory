package gyte.ooaad.mydailymemory;

import gyte.ooaad.application.ConcreteDiary;
import gyte.ooaad.application.Diary;
import gyte.ooaad.application.PhotoDiary;
import gyte.ooaad.application.SoundDiary;
import gyte.ooaad.application.VideoDiary;
import android.app.Activity;
import android.graphics.BitmapFactory;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diarydetail);

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

				currentDiary = ((SoundDiary) currentDiary).getDiary();
			}
		}

		TextView text = (TextView) findViewById(R.id.diarydetail_text);
		text.setText(((ConcreteDiary) currentDiary).getText().getMedia());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.diarydetail, menu);
		return true;
	}

}
