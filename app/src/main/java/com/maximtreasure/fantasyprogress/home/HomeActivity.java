package com.maximtreasure.fantasyprogress.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.maximtreasure.fantasyprogress.R;
import com.maximtreasure.fantasyprogress.base.BaseActivity;
import com.maximtreasure.fantasyprogress.core.CoreTimer;
import com.maximtreasure.fantasyprogress.room.CharacterInitActivity;

/**
 * Created by maxim on 19-4-2.
 */

public class HomeActivity extends BaseActivity implements View.OnClickListener{
    private TextView tv_start;
    private TextView tv_continue;
    private CoreTimer coreTimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv_start = (TextView) findViewById(R.id.tv_start);
        tv_start.setOnClickListener(this);
        tv_continue = (TextView) findViewById(R.id.tv_continue);
        tv_continue.setOnClickListener(this);
        coreTimer = CoreTimer.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_start:
                Intent intent = new Intent(HomeActivity.this, CharacterInitActivity.class);
                startActivity(intent);

                break;
            case R.id.tv_continue:

                break;
        }
    }

}
