package com.example.bd_bay_list;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHolper  extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME = "mypurshase.db";
    public static  final int DATABASE_VERSION = 1;
    public static  final String DATABASE_TABLE = "mypurshase";
    public static  final String COLUMN_ID = "_id";
    public static  final String COLUMN_PRODUCT = "PRODUCT";
    public static  final String COLUMN_COL= "COL";
    public static  final String COLUMN_TYPE = "TYPE";
    public static  final String COLUMN_COST = "COST";
    public static  final String COLUMN_CATEGORY = "CATEGORY";



    public SQLiteHolper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String  createQuery = "CREATE TABLE "+DATABASE_TABLE+"("+COLUMN_ID+" iteger primary key autoincrement,"+
            COLUMN_PRODUCT+" text not null, "+
            COLUMN_COL + " text not null, "+
            COLUMN_TYPE +" text, "+
            COLUMN_COST+ " real not null," +
            COLUMN_CATEGORY+" text not null default \"продукт\")";
        sqLiteDatabase.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
