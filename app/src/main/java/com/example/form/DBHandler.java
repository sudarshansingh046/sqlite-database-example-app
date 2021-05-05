package com.example.form;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME="demodb";
    private static final int DB_VERSION=1;
    private static final String TABLE_NAME="record";
    private static final String Name="name";
    private static final String Email="email";
    private static final String Password="pwd";
    private static final String Gender="gender";
    private static final String Education="education";
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TABLE_NAME+" ("+Name+ " TEXT PRIMARY KEY,"+Email+" TEXT,"+Password+" TEXT,"+Gender+" TEXT,"+Education+" TEXT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            // Create table again
            onCreate(db);
        }
        public void insertRecord(String name,String email,String pwd,String gender,String education){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put(Name,name);
            values.put(Email,email);
            values.put(Password,pwd);
            values.put(Gender,gender);
            values.put(Education,education);
            db.insert(TABLE_NAME,null,values);
            db.close();
        }


}
