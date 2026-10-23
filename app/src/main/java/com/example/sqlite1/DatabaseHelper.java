package com.example.sqlite1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper( Context context) {
        super(context,"UDB",null,1); //context,database name, factory or company. version of db
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(

                "CREATE TABLE Student (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT NOT NULL)"

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { // for upgrading or updating the table contents
        if (oldVersion < 2) {

            db.execSQL(
                    "ALTER TABLE Student ADD COLUMN email TEXT"
            );
        }
    }

    public boolean addName(String name) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        long result = db.insert("Student", null, values);
        return result != -1;

    }
    public String getAllNames() {

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT name FROM Student", null);

        StringBuilder names = new StringBuilder();

        try {
            while (cursor.moveToNext()) {
                names.append(cursor.getString(0)).append("\n");
            }

        } finally {

            cursor.close();
        }

        if (names.length() == 0) {

            return "No names found";
        }

        return names.toString();

    }
}
