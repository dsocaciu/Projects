package com.dmsbrews.brewmasterlite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.provider.BaseColumns;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class BrewReviewData extends SQLiteOpenHelper {
	
	  private static final String DATABASE_NAME = "reviews.db";
	  private static final int DATABASE_VERSION = 1;
	  public static final String TABLE_NAME = "reviews";
	  public static final String _ID = BaseColumns._ID;
	  public static final String NAME = "name";
	  public static final String APPEARANCE = "appearance";
	  public static final String SMELL = "smell";
	  public static final String TASTE = "taste";
	  public static final String MOUTHFEEL = "mouthfeel";
	  public static final String OVERALL = "overall";
	  public static final String OVERALL_RATING = "overall_rating";
	  

	public BrewReviewData(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public BrewReviewData(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
	// CREATE TABLE teas (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, brew_time INTEGER);
	String sql = "CREATE TABLE " + TABLE_NAME + " ("
		      + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
		      + NAME + " TEXT NOT NULL, "
		      + APPEARANCE + " TEXT, "
		      + SMELL + " TEXT, "
		      + TASTE + " TEXT, "
		      + MOUTHFEEL + " TEXT, "
		      + OVERALL + " TEXT, "
		      + OVERALL_RATING + " REAL NOT NULL"
		      + ");";

	  db.execSQL(sql);
	}
	@Override

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	  db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	  onCreate(db);
	}

	
	public long insert(String name, String appearance, String smell, String taste, String mouthfeel, String overall, float overall_rating ) {
	  SQLiteDatabase db = getWritableDatabase();
	  ContentValues values = new ContentValues();
	  values.put(NAME, name);
	  values.put(APPEARANCE, appearance);
	  values.put(SMELL, smell);
	  values.put(TASTE, taste);
	  values.put(MOUTHFEEL, mouthfeel);
	  values.put(OVERALL, overall);
	  values.put(OVERALL_RATING, overall_rating);
	  return db.insertOrThrow(TABLE_NAME, null, values);
	}
	
	public int update(long rowId, String name, String appearance, String smell, String taste, String mouthfeel, String overall, float overall_rating ) {
		  SQLiteDatabase db = getWritableDatabase();
		  ContentValues values = new ContentValues();
		  values.put(NAME, name);
		  values.put(APPEARANCE, appearance);
		  values.put(SMELL, smell);
		  values.put(TASTE, taste);
		  values.put(MOUTHFEEL, mouthfeel);
		  values.put(OVERALL, overall);
		  values.put(OVERALL_RATING, overall_rating);
		  return db.update(TABLE_NAME, values, _ID + "=" + rowId, null);
		}
	
	public Cursor all(Activity activity) {
		  String[] from = { _ID, NAME, APPEARANCE, SMELL, TASTE, MOUTHFEEL, OVERALL, OVERALL_RATING };
		  String order = NAME;
		  SQLiteDatabase db = getReadableDatabase();
		  Cursor cursor = db.query(TABLE_NAME, from, null, null, null, null, order);
		  activity.startManagingCursor(cursor);
		  return cursor;
	}
	
	public long count() {
		    SQLiteDatabase db = getReadableDatabase();
		    return DatabaseUtils.queryNumEntries(db, TABLE_NAME);
	}
	
	public int deleteReview(int name) 
	{
		SQLiteDatabase db = getReadableDatabase();
	    return db.delete(TABLE_NAME, _ID + "=" + name, null);
	}

}
