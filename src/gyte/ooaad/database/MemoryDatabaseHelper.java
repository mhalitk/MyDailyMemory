package gyte.ooaad.database;

import gyte.ooaad.application.Memory;
import gyte.ooaad.application.User;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;

public class MemoryDatabaseHelper extends SQLiteDataService {

	public MemoryDatabaseHelper(Context context) {
		super(context);
	}

	public List<Memory> getUserMemories(User user) {
		List<Memory> memories = new ArrayList<Memory>();

		// Veritabani ile baðlantý yapýlacak

		return memories;
	}

	public boolean addMemory(User user, Memory memory) {
		return false;
	}

	public boolean deleteMemory(User user, Memory memory) {
		return false;
	}

	private Memory cursorToMemory(Cursor cursor) {
		Memory memory = new Memory();

		return memory;
	}
}
