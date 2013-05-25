package gyte.ooaad.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 
 * @author halit
 */
public class SQLiteConnection extends SQLiteOpenHelper {

	public static final String C_ID = "id";

	public static final String T_USER = "user";
	public static final String T_MEMORY = "memory";

	public static final String C_USERID = "uid";
	public static final String C_USERNAME = "uname";
	public static final String C_PASSWORD = "upass";

	public static final String C_DIARYID = "did";
	public static final String C_DATE = "date";
	public static final String C_DATEADDED = "dateadded";
	public static final String C_DELETED = "deleted";
	public static final String C_TEXT = "text";
	public static final String C_PHOTO = "photo";
	public static final String C_SOUND = "sound";
	public static final String C_VIDEO = "video";

	private static final String CREATE_USER = "create table " + T_USER + " ("
			+ C_USERID + " integer primary key autoincrement, " + C_USERNAME
			+ " text not null, " + C_PASSWORD + " text not null);";

	private static final String CREATE_MEMORY = "create table " + T_MEMORY
			+ " (" + C_DIARYID + " integer primary key autoincrement, "
			+ C_USERID + " integer not null, " + C_DATE + " text not null, "
			+ C_DATEADDED + " text not null, " + C_DELETED
			+ " integer default 0, " + C_TEXT + " text not null, " + C_PHOTO
			+ " text not null, " + C_SOUND + " text not null, " + C_VIDEO
			+ " text not null);";

	private static final String DATABASE_NAME = "mydailymemory.db";
	private static final int DATABASE_VERSION = 1;

	public SQLiteConnection(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(CREATE_USER);
		database.execSQL(CREATE_MEMORY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(SQLiteConnection.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + T_USER + ";");
		db.execSQL("DROP TABLE IF EXISTS " + T_MEMORY + ";");
		onCreate(db);
	}

}
