package gyte.ooaad.database;

import gyte.ooaad.application.Diary;
import gyte.ooaad.application.Memory;
import gyte.ooaad.application.User;

import java.util.ArrayList;
import java.util.List;

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
		List<Diary> diaries = new ArrayList<Diary>();

		open();

		Cursor cursor = database.query(SQLiteConnection.T_MEMORY, columns,
				SQLiteConnection.C_USERID + "=\"" + user.getUserId() + "\"",
				null, null, null, null);

		close();

		return memory;
	}

	public boolean addMemory(User user, Memory memory) {
		return false;
	}

	public boolean deleteMemory(User user, Memory memory) {
		return false;
	}

	private Diary cursorToDiary(Cursor cursor) {
		// Diary diary = new Diary();

		return null;
	}
}
