package com.maximtreasure.fantasyprogress.core;

import android.os.Handler;
import android.os.Message;

import com.maximtreasure.fantasyprogress.core.interfaces.TimeNotifiable;

/**
 * Created by maxim on 19-4-9.
 */

public class UITimeManager implements TimeNotifiable{
    private static UITimeManager instance;
    private boolean isTimePause = false;
    private CoreTimer coreTimer;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    public static UITimeManager getInstance(){
        if (instance == null) {
            synchronized (UITimeManager.class) {
                if (instance == null) {
                    instance = new UITimeManager();
                }
            }
        }
        return instance;
    }
    private UITimeManager(){
        coreTimer = CoreTimer.getInstance();
        coreTimer.registerObserver(this);
    }
    public void stopAll(){
        isTimePause = true;
        
    }
    @Override
    public void onTimePause() {
        isTimePause = true;
    }

    @Override
    public void onTimeResume() {
        isTimePause = false;
    }
}
