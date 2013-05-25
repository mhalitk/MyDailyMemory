package gyte.ooaad.mydailymemory;

import gyte.ooaad.application.ConcreteDiary;
import gyte.ooaad.application.Diary;
import gyte.ooaad.application.PhotoDiary;
import gyte.ooaad.application.SoundDiary;
import gyte.ooaad.application.VideoDiary;
import gyte.ooaad.database.MemoryDatabaseHelper;
import gyte.ooaad.database.SQLiteConnection;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView username = (TextView) findViewById(R.id.top_username);
		username.setText(Session.user.getName());

		Button leftButton = (Button) findViewById(R.id.top_leftButton);
		leftButton.setText("Çýkýþ");
		leftButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Çýkýþ tuþuna basýldýðýnda yapýlacaklar

				// log out
				Session.user.setId(-1);
				startActivity(new Intent(MainActivity.this, Login.class));
			}
		});
		leftButton.setVisibility(View.VISIBLE);

		Button rightButton = (Button) findViewById(R.id.top_rightButton);
		rightButton.setText("Yeni");
		rightButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Yeni tuþuna basýldýðýnda yapýlacaklar
				startActivity(new Intent(MainActivity.this, NewMemory.class));
			}
		});
		rightButton.setVisibility(View.VISIBLE);
	}

	@Override
	public void onResume() {
		super.onResume();

		setMemoryAdapter();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onBackPressed() {

	}

	private void setMemoryAdapter() {
		ListView listView = (ListView) findViewById(R.id.main_memoryList);
		MemoryDatabaseHelper memoDBHelp = new MemoryDatabaseHelper(
				MainActivity.this);
		Session.user.setMemory(memoDBHelp.getUserMemories(Session.user));

		final List<Diary> diaries = Session.user.getMemory().getDiaries();
		listView.setAdapter(new ArrayAdapter<Diary>(this, R.layout.memlistitem,
				diaries) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View row;

				if (convertView == null) {
					LayoutInflater inflater = (LayoutInflater) MainActivity.this
							.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					convertView = inflater.inflate(R.layout.memlistitem, null);
				}
				row = convertView;

				TextView header = (TextView) row
						.findViewById(R.id.memlistitem_header);
				TextView text = (TextView) row
						.findViewById(R.id.memlistitem_text);
				TextView tools = (TextView) row
						.findViewById(R.id.memlistitem_tools);
				tools.setText("");

				Diary diary = diaries.get(position);
				header.setText(diary.getDate().getDate());

				while (!(diary instanceof ConcreteDiary)) {
					if (diary instanceof VideoDiary) {
						tools.setText(tools.getText().toString() + "Video, ");
						diary = ((VideoDiary) diary).getDiary();
					}

					if (diary instanceof PhotoDiary) {
						tools.setText(tools.getText().toString() + "Resim, ");
						diary = ((PhotoDiary) diary).getDiary();
					}

					if (diary instanceof SoundDiary) {
						tools.setText(tools.getText().toString() + "Ses, ");
						diary = ((SoundDiary) diary).getDiary();
					}
				}

				text.setText(((ConcreteDiary) diary).getText().getMedia());

				return row;

			}
		});
	}
}
