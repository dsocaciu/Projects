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

public class BrewSessionData extends SQLiteOpenHelper {
	
	  private static final String DATABASE_NAME = "brews.db";
	  private static final int DATABASE_VERSION = 4;
	  public static final String TABLE_NAME = "brews";
	  public static final String _ID = BaseColumns._ID;
	  public static final String NAME = "name";
	  public static final String BREW_DATE = "brew_date";
	  public static final String BREW_TYPE = "brew_type";
	  public static final String BREW_APE = "brew_ape"; //String for All-Grain, Partial Mash, Extract
	  public static final String BREW_OG = "brew_og";
	  public static final String BREW_FG = "brew_fg";
	  

	public BrewSessionData(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public BrewSessionData(Context context, String name, CursorFactory factory,
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
		      + BREW_DATE + " TEXT NOT NULL, "
		      + BREW_TYPE + " TEXT, "
		      + BREW_APE + " TEXT, "
		      + BREW_OG + " TEXT, "
		      + BREW_FG + " TEXT "
		      + ");";

	  db.execSQL(sql);
	}
	@Override

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	 // db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	 // onCreate(db);
		
		
		
		if (oldVersion < 2) {
            final String ALTER_TBL1 = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + BREW_APE + " TEXT ; ";  
            db.execSQL(ALTER_TBL1);
        }
		
		if(oldVersion < 3) {
			final String ALTER_TBL2 = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + BREW_OG + " TEXT ; "; 
		    db.execSQL(ALTER_TBL2);
            
		}
		
		if(oldVersion < 4){
			final String ALTER_TBL3 = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + BREW_FG + " TEXT ;";
			db.execSQL(ALTER_TBL3);
	        
		}
		
		onCreate(db);
		
	}
	
	/*
	 *  @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_TBL =
            "create table " + ANIMALS_TABLE +
            " (_id integer primary key autoincrement, " + 
            "animal_name text not null, " +
            "biography text not null);";
             db.execSQL(CREATE_TBL);
    }
	 * 
	 * @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            final String ALTER_TBL = 
                "ALTER TABLE " + ANIMALS_TABLE +
                " ADD COLUMN biography text not null;";
            db.execSQL(ALTER_TBL);
        }
    }
	 * 
	 */

	
	public long insert(String name, String brewDate, String brewType, String brewApe, String brewOg, String brewFg ) {
	  SQLiteDatabase db = getWritableDatabase();
	  ContentValues values = new ContentValues();
	  
	  values.put(NAME, name);
	  values.put(BREW_DATE, brewDate);
	  values.put(BREW_TYPE, brewType);
	  values.put(BREW_APE, brewApe);
	  values.put(BREW_OG, brewOg);
	  values.put(BREW_FG, brewFg);

	  
	  return db.insertOrThrow(TABLE_NAME, null, values);
	}
	
	public int update(long rowId, String name, String brewDate, String brewType, String brewApe, String brewOg, String brewFg) {
		  SQLiteDatabase db = getWritableDatabase();
		  ContentValues values = new ContentValues();
		  values.put(NAME, name);
		  values.put(BREW_DATE, brewDate);
		  values.put(BREW_TYPE, brewType);
		  values.put(BREW_APE, brewApe);
		  values.put(BREW_OG, brewOg);
		  values.put(BREW_FG, brewFg);
		  
		  return db.update(TABLE_NAME, values, _ID + "=" + rowId, null);
		}
	
	public Cursor all(Activity activity) {
		  //String[] from = { _ID, NAME, BREW_DATE, BREW_TYPE, BREW_APE, BREW_OG, BREW_FG };
		  String[] from = { _ID, NAME, BREW_DATE, BREW_TYPE, BREW_APE, BREW_OG, BREW_FG};
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
	
	public int deleteLog(int name) 
	{
		SQLiteDatabase db = getWritableDatabase();
	    return db.delete(TABLE_NAME, _ID + "=" + name, null);
	}

}
