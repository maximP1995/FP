package com.maximtreasure.fantasyprogress.base;

import android.app.Application;

import com.maximtreasure.fantasyprogress.base.data.DBManager;
import com.maximtreasure.fantasyprogress.base.entity.BaseDataEntity;

/**
 * Created by zhengmj on 19-4-2.
 */

public class BaseApplication extends Application {
    public static boolean hasSave;
    @Override
    public void onCreate() {
        super.onCreate();
        getBaseDataFromDB();
    }
    private void getBaseDataFromDB(){
        DBManager dbManager = DBManager.getInstance(this);
        BaseDataEntity entity = dbManager.getBaseDataFromDb();
        hasSave = entity != null;
    }
}
