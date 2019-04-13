package com.maximtreasure.fantasyprogress.core;

import android.util.Log;

import com.maximtreasure.fantasyprogress.core.interfaces.TimeNotifiable;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by maxim on 19-4-9.
 */

public class CoreTimer {
    private volatile static CoreTimer instance = null;
    private TimeNotifiable timeNotifiable;
    private CoreTimer(){

    }
    public static CoreTimer getInstance(){
        if (instance == null) {
            synchronized (CoreTimer.class) {
                if (instance == null) {
                    instance = new CoreTimer();
                }
            }
        }
        return instance;
    }
    public void registerObserver(TimeNotifiable timeNotifiable){
        this.timeNotifiable = timeNotifiable;
    }
    public void start(){
        if (timeNotifiable!=null)timeNotifiable.onTimeResume();
    }
    public void pause(){
        if (timeNotifiable!=null)timeNotifiable.onTimePause();
    }
    private class CoreTimeTask extends TimerTask{

        @Override
        public void run() {
            Date date = new Date(this.scheduledExecutionTime());
            Log.d("120","本次执行该线程的时间为：" + date);
        }
    }
}
