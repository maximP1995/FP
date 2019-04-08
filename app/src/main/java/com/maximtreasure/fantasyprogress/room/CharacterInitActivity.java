package com.maximtreasure.fantasyprogress.room;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.maximtreasure.fantasyprogress.R;
import com.maximtreasure.fantasyprogress.base.BaseActivity;
import com.maximtreasure.fantasyprogress.base.ConstKey;
import com.maximtreasure.fantasyprogress.base.DefaultDataGenerator;
import com.maximtreasure.fantasyprogress.base.entity.BaseDataEntity;

/**
 * Created by zhengmj on 19-4-4.
 */

public class CharacterInitActivity extends BaseActivity implements View.OnClickListener {
    private TextView tv_select;
    private TextView tv_name;
    private DefaultDataGenerator dataGenerator;
    private BaseDataEntity entity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_init);
        tv_select = (TextView) findViewById(R.id.tv_select);
        tv_select.setOnClickListener(this);
        tv_name = (TextView) findViewById(R.id.tv_name);
        dataGenerator = new DefaultDataGenerator(this,1);
        entity = dataGenerator.generate();
        if (entity!=null){
            tv_name.setText(entity.typeName);
        }else {

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_select:
                Bundle bundle = new Bundle();
                bundle.putParcelable(ConstKey.KEY_BASE_DATA,entity);
                Intent intent = new Intent(CharacterInitActivity.this,PlayRoomActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
