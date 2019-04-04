package com.maximtreasure.fantasyprogress.room;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.maximtreasure.fantasyprogress.R;
import com.maximtreasure.fantasyprogress.base.BaseActivity;
import com.maximtreasure.fantasyprogress.base.DefaultDataGenerator;
import com.maximtreasure.fantasyprogress.base.entity.BaseDataEntity;

/**
 * Created by zhengmj on 19-4-4.
 */

public class CharacterInitActivity extends BaseActivity {
    private TextView tv_select;
    private TextView tv_name;
    private DefaultDataGenerator dataGenerator;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_init);
        tv_select = (TextView) findViewById(R.id.tv_select);
        tv_name = (TextView) findViewById(R.id.tv_name);
        dataGenerator = new DefaultDataGenerator(this,1);
        BaseDataEntity entity = dataGenerator.generate();
        if (entity!=null){
            tv_name.setText(String.valueOf(entity.life));
        }else {
            Log.d("120","default entity is null");
        }
    }
}
