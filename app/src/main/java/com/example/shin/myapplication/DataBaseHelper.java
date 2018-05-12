package com.example.shin.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SmartPhones.db";
    public static final String TABLE_NAME = "phones_table";
    public static final String COL_1 = "id";
    public static final String COL_2 = "brand";
    public static final String COL_3 = "name";
    public static final String COL_4 = "price";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        // SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, BRAND TEXT, NAME TEXT, PRICE, INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String brand, String name, String price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put(COL_2, brand);
        contentValues.put(COL_3, name);
        contentValues.put(COL_4, price);
        long  result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) return false;
        else return true;
    }
}