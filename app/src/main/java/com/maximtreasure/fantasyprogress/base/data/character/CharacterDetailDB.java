package com.maximtreasure.fantasyprogress.base.data.character;

import android.content.Context;

/**
 * Created by zhengmj on 19-4-13.
 */

public class CharacterDetailDB extends CharacterDB {
    private final static String TABLE_NAME = "char_detail_table";
    public CharacterDetailDB(Context context) {
        super(context);
        setTableName(TABLE_NAME);
    }

    @Override
    public <T> T query() {
        return null;
    }
}
