package com.maximtreasure.fantasyprogress.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.maximtreasure.fantasyprogress.base.data.DBManager;
import com.maximtreasure.fantasyprogress.base.entity.BaseDataEntity;

/**
 * Created by zhengmj on 19-4-2.
 */

public class BaseActivity extends AppCompatActivity {
    private DBManager dbManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = DBManager.getInstance(this);
        BaseDataEntity entity = dbManager.getBaseDataFromDb();
        Log.d("120","before update entity == null ? "+(entity == null));
        if (entity == null){
            Bundle bundle = new Bundle();
            BaseDataEntity defaultEntity = new BaseDataEntity();
            defaultEntity.life = 28000;
            bundle.putParcelable(ConstKey.KEY_BASE_DATA,defaultEntity);
            dbManager.updateTable(bundle);
            BaseDataEntity entity2 = dbManager.getBaseDataFromDb();
            Log.d("120","after update entity == null ? "+(entity2 == null?" null ":entity2.life));
        }else {
            Log.d("120","entity life == "+entity.life);
        }
    }
}
