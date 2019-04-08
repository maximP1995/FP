package com.maximtreasure.fantasyprogress.base.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.maximtreasure.fantasyprogress.base.ConstKey;
import com.maximtreasure.fantasyprogress.base.entity.BaseDataEntity;

/**
 * Created by Maxim on 19-4-2.
 * 生成角色基础数据
 */

public class DBManager {
    private static final String TABLE_NAME = "base_data_table";
    private static final String KEY_CHAR_TYPE = "key_char_type";
    private static final String KEY_CHAR_TYPE_LEVEL = "key_char_type_level";
    private static final String KEY_CHAR_LIFE = "key_char_life";
    private static final String KEY_CHAR_TYPE_NAME = "key_char_type_name";
    private volatile static DBManager instance = null;
    private SQLiteDBHelper dbHelper;

    private DBManager(Context context){
        dbHelper = new SQLiteDBHelper(context);
    }
    public static DBManager getInstance(Context context) {
        if (instance == null) {
            synchronized (DBManager.class) {
                if (instance == null) {
                    instance = new DBManager(context);
                }
            }
        }
        return instance;
    }
    public String getTableName(){
        return TABLE_NAME;
    }
    public SQLiteDatabase getDatabase(){
        return dbHelper.getWritableDatabase();
    }
    public BaseDataEntity queryBaseData(){
        return queryData(null,null,null,null,null,null);
    }
    private BaseDataEntity queryData(String[] columns,String selection,String[] selectionArgs,String groupBy,String having,String orderBy){
        BaseDataEntity entity = null;
        Cursor cursor = getDatabase().query(getTableName(),columns,selection,selectionArgs,groupBy,having,orderBy);
        if (cursor.moveToNext()){
            entity = new BaseDataEntity();
            entity.typeName = cursor.getString(cursor.getColumnIndex(KEY_CHAR_TYPE_NAME));
            entity.charType = cursor.getInt(cursor.getColumnIndex(KEY_CHAR_TYPE));
            entity.charTypeLevel = cursor.getInt(cursor.getColumnIndex(KEY_CHAR_TYPE_LEVEL));
            entity.life = cursor.getLong(cursor.getColumnIndex(KEY_CHAR_LIFE));
        }
        return entity;
    }
    public boolean deleteBaseData(int charType){
        try {
            getDatabase().delete(getTableName(),KEY_CHAR_TYPE+" = ?",new String[]{String.valueOf(charType)});
            return true;
        }catch (Exception e){
            return false;
        }
    }
    private boolean insertData(@NonNull BaseDataEntity entity){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_CHAR_TYPE,entity.charType);
        contentValues.put(KEY_CHAR_TYPE_LEVEL,entity.charTypeLevel);
        contentValues.put(KEY_CHAR_TYPE_NAME,entity.typeName);
        contentValues.put(KEY_CHAR_LIFE,entity.life);
        try{
            getDatabase().insert(getTableName(),null,contentValues);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    private class SQLiteDBHelper extends SQLiteOpenHelper{
        private static final String DB_NAME = "fpdb.db";
        private static final int DB_VERSION = 1;
        private static final String CREATE_TABLE = "create table "+TABLE_NAME+" (" +
                ""+KEY_CHAR_TYPE+" integer not null," +
                ""+KEY_CHAR_TYPE_LEVEL+" integer not null," +
                ""+KEY_CHAR_LIFE+" long default 0," +
                ""+KEY_CHAR_TYPE_NAME+" varchar(12))";
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
            db.execSQL(CREATE_TABLE);
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
