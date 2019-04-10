package com.maximtreasure.fantasyprogress.room;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.maximtreasure.fantasyprogress.R;
import com.maximtreasure.fantasyprogress.base.BaseActivity;
import com.maximtreasure.fantasyprogress.base.ConstKey;
import com.maximtreasure.fantasyprogress.base.DefaultDataGenerator;
import com.maximtreasure.fantasyprogress.base.entity.BaseDataEntity;
import com.maximtreasure.fantasyprogress.core.UITimeManager;
import com.maximtreasure.fantasyprogress.view.SkillProgress;

/**
 * Created by zhengmj on 19-4-4.
 */

public class CharacterInitActivity extends BaseActivity implements View.OnClickListener {
    private TextView tv_select;
    private TextView tv_name;
    private SkillProgress id_test;
    private DefaultDataGenerator dataGenerator;
    private BaseDataEntity entity;
//    private ProgressBar test_pb;
    private UITimeManager uiTimeManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_init);
        id_test = (SkillProgress) findViewById(R.id.id_test);
        tv_select = (TextView) findViewById(R.id.tv_select);
        tv_select.setOnClickListener(this);
        tv_name = (TextView) findViewById(R.id.tv_name);
//        test_pb = (ProgressBar) findViewById(R.id.test_pb);
//        uiTimeManager = UITimeManager.getInstance();
//        uiTimeManager.registerUI(test_pb,2000);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_select:
                if (!id_test.isStop()){
                    id_test.stop();
                }else {
                    id_test.reboot();
                }
//                uiTimeManager.resetView(test_pb.getId());
//                Bundle bundle = new Bundle();
//                bundle.putParcelable(ConstKey.KEY_BASE_DATA,entity);
//                Intent intent = new Intent(CharacterInitActivity.this,PlayRoomActivity.class);
//                startActivity(intent);
//                finish();
                break;
        }
    }
}
