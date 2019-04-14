package com.maximtreasure.fantasyprogress.base.data;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Created by zhengmj on 19-4-11.
 */

public abstract class BaseDB {
    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public void setSelectionArgs(String[] selectionArgs) {
        this.selectionArgs = selectionArgs;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public void setHaving(String having) {
        this.having = having;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String[] getColumns() {
        return columns;
    }

    public String getSelection() {
        return selection;
    }

    public String[] getSelectionArgs() {
        return selectionArgs;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public String getHaving() {
        return having;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public Cursor sqlQuery(){
        return getDB().query(getTableName(),getColumns(), TextUtils.isEmpty(getSelection())?null:getSelection()+" = ?",getSelectionArgs(),getGroupBy(),getHaving(),getOrderBy());
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    private String tableName = null;
    private String[] columns = null;
    private String selection = null;
    private String[] selectionArgs = null;
    private String groupBy = null;
    private String having = null;
    private String orderBy = null;
    private SQLiteDBHelper helper;
    public BaseDB(Context context){
        helper = new SQLiteDBHelper(context.getApplicationContext());
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
