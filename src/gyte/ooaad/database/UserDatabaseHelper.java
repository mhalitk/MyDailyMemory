package gyte.ooaad.database;

import gyte.ooaad.application.User;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class UserDatabaseHelper extends SQLiteDataService {

	private String[] columns = { SQLiteConnection.C_USERID,
			SQLiteConnection.C_PASSWORD, SQLiteConnection.C_USERNAME };

	public UserDatabaseHelper(Context context) {
		super(context);
	}

	public int getUserId(User user) {
		open();
		Cursor cursor = database.query(SQLiteConnection.T_USER, columns,
				SQLiteConnection.C_USERNAME + "=\"" + user.getName() + "\" AND " + SQLiteConnection.C_PASSWORD + "=\"" + user.getPassword() + "\"",
				null, null, null, null);

		if (cursor.getCount() == 0) {
			cursor.close();
			close();
			return -1;
		}

		cursor.moveToFirst();
		User tempUser = cursorToUser(cursor);

		close();

		return tempUser.getUserId();
	}

	public int registerUser(User user) {

		open();
		ContentValues contentValues = new ContentValues();
		contentValues.put(SQLiteConnection.C_USERNAME, user.getName());
		contentValues.put(SQLiteConnection.C_PASSWORD, user.getPassword());
		long databaseInsert = database.insert(SQLiteConnection.T_USER, null,
				contentValues);

		close();

		return (int) databaseInsert;
	}

	public boolean checkUsername(User user) {
		open();
		Cursor cursor = database.query(SQLiteConnection.T_USER, columns,
				SQLiteConnection.C_USERNAME + "=\"" + user.getName() + "\"",
				null, null, null, null);

		if (cursor.getCount() == 0) {
			cursor.close();
			close();
			return false;
		}

		cursor.moveToFirst();
		User tempUser = cursorToUser(cursor);

		close();

		return true;
	}
	
	private User cursorToUser(Cursor cursor) {
		User user = new User();
		user.setId(cursor.getInt(cursor
				.getColumnIndexOrThrow(SQLiteConnection.C_USERID)));
		user.setName(cursor.getString(cursor
				.getColumnIndexOrThrow(SQLiteConnection.C_USERNAME)));
		user.setPassword(cursor.getString(cursor
				.getColumnIndexOrThrow(SQLiteConnection.C_PASSWORD)));
		return user;
	}
}
