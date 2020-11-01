package com.example.asylumescape;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    protected static final String DATABASE_NAME = "leaderboard.db";
    private static final String column = "TIME";
    private static final String RETime = "RETime";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + RETime + "(" + column + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + RETime + "(" + column + ");");
    }

    public void insertData(String time){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(column, time);
        db.insert(RETime, null, contentValues);
        db.close();
    }

    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery("SELECT " + column +" FROM " + RETime + " ORDER BY " + column + " ASC ", null);
        return c;
    }
}
