package com.maximtreasure.fantasyprogress.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.maximtreasure.fantasyprogress.R;
import com.maximtreasure.fantasyprogress.base.BaseActivity;
import com.maximtreasure.fantasyprogress.base.BaseApplication;

/**
 * Created by zhengmj on 19-4-2.
 */

public class HomeActivity extends BaseActivity implements View.OnClickListener{
    private TextView tv_start;
    private TextView tv_continue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv_start = (TextView) findViewById(R.id.tv_start);
        tv_start.setOnClickListener(this);
        tv_continue = (TextView) findViewById(R.id.tv_continue);
        tv_continue.setEnabled(BaseApplication.hasSave);
        tv_continue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_start:
                break;
            case R.id.tv_continue:
                break;
        }
    }
}
