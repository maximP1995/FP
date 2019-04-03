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
 * Created by zhengmj on 19-4-2.
 */

public class DBManager {
    private static final String TAG = DBManager.class.getSimpleName();
    private static final String DATABASE_NAME = "fp.db";
    private static final String TABLE_NAME = "base_data";
    private static final String CHAR_LIFE_TIME = "time_character_life";
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ( "+CHAR_LIFE_TIME+" INTEGER DEFAULT 0 )";
    private static int DATABASE_VERSION = 1;
    private DataBaseHelper mOpenHelper = null;
    private volatile static DBManager instance = null;

    private DBManager(Context context){
        mOpenHelper = new DataBaseHelper(context);
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

    public SQLiteDatabase getDbOppType(boolean writeable) {
        if (writeable) {
            return mOpenHelper.getWritableDatabase();
        } else {
            return mOpenHelper.getReadableDatabase();
        }
    }
    public BaseDataEntity getBaseDataFromDb(){
        BaseDataEntity entity = null;
        try{
            SQLiteDatabase db = getDbOppType(true);
            Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
            while (cursor.moveToNext()){
                Log.d("120","cursor getLong == "+cursor.getLong(0));
                Long life_time = cursor.getLong(0);
                if (life_time!=null){
                    entity = new BaseDataEntity();
                    entity.life = life_time;
                }
            }
            cursor.close();
            db.close();
        }catch (Exception e){

        }
        return entity;
    }
    public void updateTable(@NonNull Bundle bundle) {
        SQLiteDatabase db = getDbOppType(true);
        //这里不能用replace 因为会把 recentTime 清掉
        BaseDataEntity baseData = null;
        if (bundle.containsKey(ConstKey.KEY_BASE_DATA)){
            baseData = bundle.getParcelable(ConstKey.KEY_BASE_DATA);
        }
        if (baseData!=null){
//            ContentValues cv = new ContentValues();
//            cv.put(CHAR_LIFE_TIME,baseData.life);
            db.execSQL("INSERT INTO "+TABLE_NAME+" ("+CHAR_LIFE_TIME+") VALUES("+baseData.life+")");
            db.close();
        }
//        CircleRel circleRel = getCircleRel(circleId, userId);
//        ContentValues cv = new ContentValues();
//        cv.put(CircleRelTable.CIRCLE_ID, circleId);
//        cv.put(CircleRelTable.MYUSERID, userId);
//        cv.put(CircleRelTable.ROLE, role);
//        if (circleRel != null) {//更新
//            db.update(CircleRelTable.TABLENAME, cv, CircleRelTable.CIRCLE_ID + "=? and " + CircleRelTable.MYUSERID + "=?", new String[]{circleId, String.valueOf(userId)});
//        } else {//插入
//            db.insert(CircleRelTable.TABLENAME, null, cv);
//        }
    }
//    public BaseDataEntity getCircleRel(String circleNum, long userId) {
//        SQLiteDatabase db = getDbOppType(true);
//        Cursor cursor = db.query(TABLE_NAME, null, CircleRelTable.CIRCLE_ID + "=? and " + CircleRelTable.MYUSERID + "=?", new String[]{circleNum, String.valueOf(userId)}, null, null, null);
//        return CircleRelTable.convertToCircleRel(cursor);
//    }
    private static class DataBaseHelper extends SQLiteOpenHelper{

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
            Log.d("120","create_table version == "+db.getVersion()+" path == "+db.getPath()+" pageSize == "+db.getPageSize());
        }
    }
}
