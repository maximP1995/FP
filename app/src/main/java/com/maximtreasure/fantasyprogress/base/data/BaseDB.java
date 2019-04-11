package com.maximtreasure.fantasyprogress.base.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

/**
 * Created by zhengmj on 19-4-11.
 */

public abstract class BaseDB {
    private SQLiteDBHelper helper;
    public BaseDB(Context context){
        helper = new SQLiteDBHelper(context);
    }
    protected SQLiteDatabase getDB(){
        return helper.getWritableDatabase();
    }
    protected void createTable(String sql){
        getDB().execSQL(sql);
    }
    private class SQLiteDBHelper extends SQLiteOpenHelper {
        private static final String DB_NAME = "fpdb.db";
        private static final int DB_VERSION = 1;
        public SQLiteDBHelper(Context context){
            this(context,DB_NAME,null,DB_VERSION);
        }
        public SQLiteDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        public SQLiteDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
            super(context, name, factory, version, errorHandler);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        @Override
        public void onOpen(SQLiteDatabase db) {
            super.onOpen(db);
        }
    }
}
