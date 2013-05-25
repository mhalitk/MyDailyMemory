package gyte.ooaad.database;

import gyte.ooaad.application.User;
import android.content.Context;
import android.database.Cursor;

public class UserDatabaseHelper extends SQLiteDataService {

	private String[] columns = { SQLiteConnection.C_USERID,
			SQLiteConnection.C_PASSWORD, SQLiteConnection.C_USERNAME };

	public UserDatabaseHelper(Context context) {
		super(context);
	}

	public int getUserId(User user) {
		Cursor cursor = database.query(SQLiteConnection.T_USER, columns,
				SQLiteConnection.C_USERNAME + "=\"" + user.getName() + "\"",
				null, null, null, null);
		return -1;
	}

	public int registerUser(User user) {
		int result = getUserId(user);
		if (result >= 0)
			return -1;

		// Veritabaný ile baglantý yapýlacak - kaydetme iþlemi

		return -1;
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
