package gyte.ooaad.database;

import gyte.ooaad.application.ConcreteDiary;
import gyte.ooaad.application.Date;
import gyte.ooaad.application.Diary;
import gyte.ooaad.application.Memory;
import gyte.ooaad.application.Photo;
import gyte.ooaad.application.PhotoDiary;
import gyte.ooaad.application.Sound;
import gyte.ooaad.application.SoundDiary;
import gyte.ooaad.application.Text;
import gyte.ooaad.application.User;
import gyte.ooaad.application.Video;
import gyte.ooaad.application.VideoDiary;

import java.util.Calendar;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class MemoryDatabaseHelper extends SQLiteDataService {

	private String[] columns = { SQLiteConnection.C_DIARYID,
			SQLiteConnection.C_USERID, SQLiteConnection.C_DATE,
			SQLiteConnection.C_DATEADDED, SQLiteConnection.C_DELETED,
			SQLiteConnection.C_PHOTO, SQLiteConnection.C_SOUND,
			SQLiteConnection.C_TEXT, SQLiteConnection.C_VIDEO };

	public MemoryDatabaseHelper(Context context) {
		super(context);
	}

	public Memory getUserMemories(User user) {
		Memory memory = new Memory();

		open();

		Cursor cursor = database.query(SQLiteConnection.T_MEMORY, columns,
				SQLiteConnection.C_USERID + "=\"" + user.getUserId() + "\"",
				null, null, null, null);

		if (cursor.getCount() == 0) {
			cursor.close();
			close();
			return memory;
		}

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			memory.addDiary(cursorToDiary(cursor));
			cursor.moveToNext();
		}

		cursor.close();
		close();

		return memory;
	}

	public boolean addMemory(User user, Memory memory) {
		open();
		close();
		return false;
	}

	public boolean addDiary(User user, Diary diary) {
		open();

		ContentValues contentValues = new ContentValues();
		contentValues.put(SQLiteConnection.C_USERID, user.getUserId());
		contentValues.put(SQLiteConnection.C_DATE, diary.getDate().getDate());
		contentValues.put(SQLiteConnection.C_DATEADDED,
				Calendar.getInstance(Locale.getDefault()).getTime().toString());

		while (!(diary instanceof ConcreteDiary)) {
			if (diary instanceof VideoDiary) {
				contentValues.put(SQLiteConnection.C_VIDEO,
						((VideoDiary) diary).getVideo().getMedia());
				diary = ((VideoDiary) diary).getDiary();
			}

			if (diary instanceof SoundDiary) {
				contentValues.put(SQLiteConnection.C_SOUND,
						((SoundDiary) diary).getSound().getMedia());
				diary = ((SoundDiary) diary).getDiary();
			}

			if (diary instanceof PhotoDiary) {
				contentValues.put(SQLiteConnection.C_PHOTO,
						((PhotoDiary) diary).getPhoto().getMedia());
				diary = ((PhotoDiary) diary).getDiary();
			}

		}

		contentValues.put(SQLiteConnection.C_TEXT, ((ConcreteDiary) diary)
				.getText().getMedia());

		long insertId = database.insert(SQLiteConnection.T_MEMORY, null,
				contentValues);

		close();

		if (insertId == -1)
			return false;

		return true;
	}

	public boolean deleteMemory(User user, Memory memory) {
		return false;
	}

	private Diary cursorToDiary(Cursor cursor) {
		Diary diary = new ConcreteDiary();
		diary.setDate(new Date(cursor.getString(cursor
				.getColumnIndexOrThrow(SQLiteConnection.C_DATE))));
		Text text = new Text();
		text.setMedia(cursor.getString(cursor
				.getColumnIndexOrThrow(SQLiteConnection.C_TEXT)));

		((ConcreteDiary) diary).setText(text);
		if (!cursor.isNull(cursor
				.getColumnIndexOrThrow(SQLiteConnection.C_SOUND))) {
			diary = new SoundDiary(diary);
			((SoundDiary) diary).setSound(new Sound(cursor.getString(cursor
					.getColumnIndexOrThrow(SQLiteConnection.C_SOUND))));
		}
		if (!cursor.isNull(cursor
				.getColumnIndexOrThrow(SQLiteConnection.C_PHOTO))) {
			diary = new PhotoDiary(diary);
			((PhotoDiary) diary).setPhoto(new Photo(cursor.getString(cursor
					.getColumnIndexOrThrow(SQLiteConnection.C_PHOTO))));
		}
		if (!cursor.isNull(cursor
				.getColumnIndexOrThrow(SQLiteConnection.C_VIDEO))) {
			diary = new VideoDiary(diary);
			((VideoDiary) diary).setVideo(new Video(cursor.getString(cursor
					.getColumnIndexOrThrow(SQLiteConnection.C_VIDEO))));
		}
		return diary;
	}
}
