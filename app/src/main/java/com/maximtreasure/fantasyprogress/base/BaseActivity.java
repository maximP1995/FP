package com.maximtreasure.fantasyprogress.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.maximtreasure.fantasyprogress.base.data.DBManager;
import com.maximtreasure.fantasyprogress.base.entity.BaseDataEntity;
import com.maximtreasure.fantasyprogress.core.UITimeManager;

/**
 * Created by maxim on 19-4-2.
 */

public class BaseActivity extends AppCompatActivity {
    private DBManager dbManager;
    private UITimeManager uiTimeManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = DBManager.getInstance(this);
        uiTimeManager = UITimeManager.getInstance();
    }
    public UITimeManager getUiTimeManager(){
        return uiTimeManager;
    }
    public void saveData(@NonNull BaseDataEntity entity){
        showSavingProgress();
        if (dbManager.updateData(entity)){
         dismissSavingProgress(true);
        }else {
            dismissSavingProgress(false);
        }
    }
    public void showSavingProgress(){

    }
    public void dismissSavingProgress(boolean saveSuccess){

    }
}
