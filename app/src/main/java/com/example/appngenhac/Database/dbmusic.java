package com.example.appngenhac.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbmusic extends SQLiteOpenHelper {
    public dbmusic(Context context) {
        super(context, "Music.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table music(ID text primary key, TenBH text, TenCS text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists music");
    }
}
