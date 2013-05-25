package gyte.ooaad.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public abstract class SQLiteDataService {

	protected SQLiteDatabase database;
	protected SQLiteConnection dbHelper;

	public SQLiteDataService(Context context) {
		dbHelper = new SQLiteConnection(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void open_r() throws SQLException {
		database = dbHelper.getReadableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

}
