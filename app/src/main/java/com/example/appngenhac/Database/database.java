package com.example.appngenhac.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {
    public database(Context context) {
        super(context, "Login.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(account text primary key, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

    public boolean insert(String account,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("account",account);
        contentValues.put("password",password);
        long ins = db.insert("user",null,contentValues);
        if(ins==-1)return false;
        else return true;
    }
    public boolean chkacc(String account){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where account=?",new String[]{account});
        if(cursor.getCount()>0)return false;
        else return true;
    }
    public boolean check(String account,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where account=? and password=?",new String[]{account,password});
        if(cursor.getCount()>0)return true;
        else return false;
    }

}
