package com.maximtreasure.fantasyprogress.base.data.user;

import android.content.ContentValues;
import android.content.Context;

import com.maximtreasure.fantasyprogress.base.data.interfaces.SafeWritePermission;
import com.maximtreasure.fantasyprogress.base.data.interfaces.SafeWriteOnly;

public class UserTotalInfoDB extends UserDB implements SafeWriteOnly {
    private static final String TABLE_NAME = "user_total_info";
    private static final String KEY_CHARACTER_TYPE = "user_char_type";
    private static final String CREATE_TABLE = "create table "+TABLE_NAME+" if not exists("+KEY_CHARACTER_TYPE+" integer not null)";
    private ContentValues contentValues = null;
    public UserTotalInfoDB(Context context) {
        super(context);
        setTableName(TABLE_NAME);
        createTable(CREATE_TABLE);
        if (context instanceof SafeWritePermission){
            contentValues = ((SafeWritePermission)context).provideValue();
        }
    }
    private void update(){
        getDB().update(getTableName(),contentValues,getSelection(),getSelectionArgs());
    }
    @Override
    public void safeWrite() {
        if (contentValues!=null)update();
    }
}
