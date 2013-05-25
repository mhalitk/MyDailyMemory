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

	public static final String COLUMN_ID = "id";

	public static final String TABLE_LECTURES = "lectures";
	public static final String TABLE_STUDENTS = "students";
	public static final String TABLE_RELATION = "relation";
	public static final String TABLE_INSTRUCTOR = "instructor";
	public static final String TABLE_ROLLCALL = "rollcall";
	public static final String TABLE_ROLLCALL_RELATION = "rollcallrel";
	public static final String TABLE_SYLLABUS = "syllabus";

	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_CODE = "code";
	public static final String COLUMN_COURSES = "numberofcourses";
	public static final String COLUMN_PERCENT = "percent";
	public static final String COLUMN_INSTRUCTOR = "instructor";
	public static final String COLUMN_NUMBER = "number";
	public static final String COLUMN_STUDENT_ID = "sid";
	public static final String COLUMN_LECTURE_ID = "lid";
	public static final String COLUMN_ATTENDANCE = "attendance";
	public static final String COLUMN_PASS = "password";
	public static final String COLUMN_DATE = "date";
	public static final String COLUMN_ROLLCALL_ID = "rollcallid";
	public static final String COLUMN_CONTROL = "control";
	public static final String COLUMN_ATTENDED = "attended";
	public static final String COLUMN_IMAGEPATH = "imagepath";
	public static final String COLUMN_DAY = "day";
	public static final String COLUMN_FROMTIME = "fromtime";
	public static final String COLUMN_TOTIME = "totime";
	public static final String COLUMN_TYPE = "type";
	public static final String COLUMN_SYNC = "sync";

	private static final String CREATE_LECTURES = "CREATE TABLE "
			+ TABLE_LECTURES + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_NAME
			+ " text not null, " + COLUMN_CODE + " text not null, "
			+ COLUMN_PERCENT + " integer not null, " + COLUMN_INSTRUCTOR
			+ " integer default -1, " + COLUMN_COURSES + " integer default 0,"
			+ COLUMN_SYNC + " integer default 0);";

	private static final String CREATE_STUDENTS = "CREATE TABLE "
			+ TABLE_STUDENTS + "(" + COLUMN_ID + " integer primary key, "
			+ COLUMN_NAME + " text not null, " + COLUMN_NUMBER
			+ " integer not null," + COLUMN_SYNC + " integer default 0);";

	private static final String CREATE_RELATION = "CREATE TABLE "
			+ TABLE_RELATION + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_STUDENT_ID
			+ " integer not null, " + COLUMN_LECTURE_ID + " integer not null, "
			+ COLUMN_ATTENDANCE + " integer default 0, " + COLUMN_PERCENT
			+ " integer default 100," + COLUMN_SYNC + " integer default 0);";

	private static final String CREATE_INSTRUCTOR = "CREATE TABLE "
			+ TABLE_INSTRUCTOR + "(" + COLUMN_ID + " integer primary key, "
			+ COLUMN_NAME + " text not null, " + COLUMN_PASS
			+ " text not null);";

	private static final String CREATE_ROLLCALL = "CREATE TABLE "
			+ TABLE_ROLLCALL + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_LECTURE_ID
			+ " integer not null, " + COLUMN_INSTRUCTOR + " integer not null, "
			+ COLUMN_DATE + " text not null, " + COLUMN_CONTROL
			+ " integer default 0, " + COLUMN_TYPE + " integer not null,"
			+ COLUMN_SYNC + " integer default 0);";

	private static final String CREATE_ROLLCALL_REL = "CREATE TABLE "
			+ TABLE_ROLLCALL_RELATION + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_LECTURE_ID
			+ " integer, " + COLUMN_ROLLCALL_ID + " integer not null, "
			+ COLUMN_STUDENT_ID + " integer not null, " + COLUMN_ATTENDED
			+ " integer default 0, " + COLUMN_IMAGEPATH + " text not null,"
			+ COLUMN_SYNC + " integer default 0);";

	private static final String CREATE_SYLLABUS = "CREATE TABLE "
			+ TABLE_SYLLABUS + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_CODE
			+ " text not null, " + COLUMN_DAY + " text not null, "
			+ COLUMN_FROMTIME + " text not null, " + COLUMN_TOTIME
			+ " text not null," + COLUMN_SYNC + " integer default 0);";

	private static final String DATABASE_NAME = "yoklama.db";
	private static final int DATABASE_VERSION = 2;

	public SQLiteConnection(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(CREATE_LECTURES);
		database.execSQL(CREATE_STUDENTS);
		database.execSQL(CREATE_RELATION);
		database.execSQL(CREATE_INSTRUCTOR);
		database.execSQL(CREATE_ROLLCALL);
		database.execSQL(CREATE_ROLLCALL_REL);
		database.execSQL(CREATE_SYLLABUS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(SQLiteConnection.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LECTURES + ";");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS + ";");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_RELATION + ";");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_INSTRUCTOR + ";");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROLLCALL + ";");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROLLCALL_RELATION + ";");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SYLLABUS + ";");
		onCreate(db);
	}

}
