package com.example.sadikuchan.practicesqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASS = "pass";

    SQLiteDatabase sqLiteDatabase;
    private static final String TABLE_CREATE = "create table contacts (id int primary key not null, name text not null, email text not null, pass text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "Drop table if exists " + TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        this.onCreate(sqLiteDatabase);
    }

    public void insertContact(Contact contact) {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, contact.getName());
        values.put(COLUMN_EMAIL, contact.getEmail());
        values.put(COLUMN_PASS, contact.getPass());

        sqLiteDatabase.insert(TABLE_NAME, null, values);
        sqLiteDatabase.close();
    }

    public String searchPass(String name){

        sqLiteDatabase = this.getReadableDatabase();
        String query = "select name,pass from " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        String sname, pass;
        pass = "Not Found";
        if(cursor.moveToFirst()){
            do {
                sname = cursor.getString(0);
                pass = cursor.getString(1);

                if(sname.equals(name)){
                    pass = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return pass;
    }

    public Cursor getListContents(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "select *from " + TABLE_NAME;
        Cursor data = sqLiteDatabase.rawQuery(query, null);
        return data;
    }
}
