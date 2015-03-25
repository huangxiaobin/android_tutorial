package com.example.android_tutorial_111_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class HotOrNot {
	public static String KEY_ID = "person_id";
	public static String KEY_NAME = "person_name";
	public static String KEY_HOTNESS = "person_hotness";

	public static String DATABASE_NAME = "HotOrNotDB";
	public static String DATABASE_TABLE = "people_table";
	public static int    DATABASE_VERSION = 1;

	private DbHelper myHelper;
	Context myContext;
	SQLiteDatabase myDatabase;
	
	class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
						KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
						KEY_NAME + " TEXT NOT NULL, " +
						KEY_HOTNESS + " TEXT NOT NULL);");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXIST " + DATABASE_TABLE);
			onCreate(db);
		}
	}
	
	HotOrNot(Context c) {
		myContext = c;
	}
	
	public HotOrNot open() throws SQLException{
		myHelper = new DbHelper(myContext);
		myDatabase = myHelper.getWritableDatabase(); 
		return this;
	}
	
	public void close() {
		myHelper.close();
	}
	
	public long createEntry(String name, String hotness) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_NAME, name);
		cv.put(KEY_HOTNESS, hotness);
		return myDatabase.insert(DATABASE_TABLE, null, cv);
	}

	public String getData() {
		// TODO Auto-generated method stub
		String[] column = new String[] {KEY_ID, KEY_NAME, KEY_HOTNESS};
		String reults = "";
		
		Cursor cur = myDatabase.query(DATABASE_TABLE, column, null, null, null, null, null);
		
		int iId = cur.getColumnIndex(KEY_ID);
		int iName = cur.getColumnIndex(KEY_NAME);
		int iHotness = cur.getColumnIndex(KEY_HOTNESS);
		
		for (cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext()) {
			reults += cur.getString(iId) + "\t\t" + cur.getString(iName) + " " + cur.getString(iHotness) + "\n";
		}
		return reults;
	}

	public void update(long mId, String mName, String mHotness) throws SQLException{
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		//cv.put(KEY_ID, mId);
		cv.put(KEY_NAME, mName);
		cv.put(KEY_HOTNESS, mHotness);
		myDatabase.update(DATABASE_TABLE, cv, KEY_ID + "=" + mId, null);
	}
	
	public void delete(long idDel) throws SQLException{
		// TODO Auto-generated method stub
		myDatabase.delete(DATABASE_TABLE, KEY_ID + "=" + idDel, null);
	}
}
