package com.maximtreasure.fantasyprogress.base.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.maximtreasure.fantasyprogress.base.ConstKey;
import com.maximtreasure.fantasyprogress.base.entity.BaseDataEntity;

/**
 * Created by zhengmj on 19-4-4.
 */

public class DefaultDataTable {
    private static final String TAG = DefaultDataTable.class.getSimpleName();
    private static final String DATABASE_NAME = "fpddt.db";
    private static final String TABLE_NAME = "default_data";
    private static final String CHAR_LIFE_TIME = "time_character_life";
    private static final String CHAR_TYPE = "char_type";
    private static final String CHAR_TYPE_LEVEL = "char_type_level";
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ( "+CHAR_TYPE+" INTEGER DEFAULT 0 , "+CHAR_TYPE_LEVEL+" INTEGER , "+CHAR_LIFE_TIME+" LONG )";
    private static int DATABASE_VERSION = 1;
    private DataBaseHelper mOpenHelper = null;
    private volatile static DefaultDataTable instance = null;
    private DefaultDataTable(Context context){
        mOpenHelper = new DataBaseHelper(context);
    }

    public static DefaultDataTable getInstance(Context context) {
        if (instance == null) {
            synchronized (DefaultDataTable.class) {
                if (instance == null) {
                    instance = new DefaultDataTable(context);
                }
            }
        }
        return instance;
    }
    private static class DataBaseHelper extends SQLiteOpenHelper {

        public DataBaseHelper(Context context) {
            this(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            doCreateTable(sqLiteDatabase);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
        private void doCreateTable(SQLiteDatabase db){
            db.execSQL(CREATE_TABLE);
            generateDefaultData(db);
        }
        public void generateDefaultData(SQLiteDatabase db) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(CHAR_TYPE, 1);
            contentValues.put(CHAR_TYPE_LEVEL, 1);
            contentValues.put(CHAR_LIFE_TIME, 28000);
            db.insert(TABLE_NAME,null,contentValues);
            db.close();
        }
    }
    public SQLiteDatabase getDbOppType(boolean writeable) {
        if (writeable) {
            return mOpenHelper.getWritableDatabase();
        } else {
            return mOpenHelper.getReadableDatabase();
        }
    }
    public BaseDataEntity getSpecifyData(int charType){
        BaseDataEntity entity = null;
        try{
            SQLiteDatabase db = getDbOppType(true);
            Cursor cursor = db.query(TABLE_NAME,null,CHAR_TYPE,new String[]{charType+""},null,null,null);
            while (cursor.moveToNext()){
                    entity = new BaseDataEntity();
                    entity.life = cursor.getLong(cursor.getColumnIndex(CHAR_LIFE_TIME));
                    entity.charType = cursor.getInt(cursor.getColumnIndex(CHAR_TYPE));
                    entity.charTypeLevel = cursor.getInt(cursor.getColumnIndex(CHAR_TYPE_LEVEL));
                    Log.d("120","get life == "+entity.life+" charType == "+entity.charType+" charTypeLevel == "+entity.charTypeLevel);
            }
            cursor.close();
            db.close();
        }catch (Exception e){

        }
        return entity;
    }
}
