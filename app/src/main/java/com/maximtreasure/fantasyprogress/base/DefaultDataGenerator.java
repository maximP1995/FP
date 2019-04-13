package com.maximtreasure.fantasyprogress.base;

import android.content.Context;

import com.maximtreasure.fantasyprogress.base.data.DefaultDataTable;
import com.maximtreasure.fantasyprogress.base.entity.BaseDataEntity;

/**
 * Created by zhengmj on 19-4-4.
 */

public class DefaultDataGenerator {
    private int charType;
    private DefaultDataTable defaultDataTable;
    private Context context;
    public DefaultDataGenerator(Context context, int charType){
        this.context = context;
        this.charType = charType;
        defaultDataTable = DefaultDataTable.getInstance(context);
    }
    public BaseDataEntity generate(){
        BaseDataEntity entity = defaultDataTable.getSpecifyData(charType);;
        return entity;
    }
}
