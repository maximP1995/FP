package com.maximtreasure.fantasyprogress.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.maximtreasure.fantasyprogress.R;
import com.maximtreasure.fantasyprogress.base.BaseActivity;
import com.maximtreasure.fantasyprogress.core.CoreTimer;
import com.maximtreasure.fantasyprogress.room.CharacterInitActivity;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by maxim on 19-4-2.
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
        tv_continue.setOnClickListener(this);
//        testPool();
    }

    private void testPool() {
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        for (int i = 0;i<10;i++){
            final int index = i;
            try{
                Thread.sleep(index*100);
                Log.d("120","pool 循环  isMain? "+(Thread.currentThread() == getMainLooper().getThread()));
            }catch (Exception e){

            }
            cacheThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Log.d("120","pool i == "+index+" 当前线程 == "+Thread.currentThread().getName()+" isMain? "+(Thread.currentThread() == getMainLooper().getThread()));
                }
            });
        }
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
