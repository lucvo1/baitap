package com.example.appngenhac.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbmusic extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "Nhac";
    public static final String COL_1 = "id";
    public static final String COL_2 = "Name";

    public dbmusic(Context context) {
        super(context, "music.db", null, 1);
    }

    public void Querrydata(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public Cursor Getdata(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"("+COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT , "+COL_2+" VARCHAR(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
    public boolean add(String tenbh){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,tenbh);
        long ins = db.insert(TABLE_NAME,null,contentValues);
        if(ins==-1)return false;
        else return true;
    }
    public boolean update(String id, String tenbh){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,tenbh);
        long result = db.update(TABLE_NAME,contentValues, COL_1+"=?",new String[]{id} );
        if(result==-1)return false;
        else return true;
    }
    public boolean delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, COL_1+"=?",new String[]{id} );
        if(result==-1)return false;
        else return true;
    }
}

