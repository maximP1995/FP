package com.maximtreasure.fantasyprogress.core;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;

import com.maximtreasure.fantasyprogress.core.interfaces.ActionListener;
import com.maximtreasure.fantasyprogress.core.interfaces.TimeNotifiable;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by maxim on 19-4-9.
 */

public class UITimeManager {
    private static UITimeManager instance;
    private boolean isTimePause = false;
    private HashMap<Integer,View> callMap;
    private ExecutorService pool;
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
        callMap = new HashMap<>();
        pool = Executors.newCachedThreadPool();

    }
    public void registerUI(ActionListener instance,final long delay){

    }
    public void registerUI(View view, final long delay){
        if (!callMap.containsKey(view.getId())){
            callMap.put(view.getId(),view);
        }
        final ProgressBar bar = (ProgressBar) view;
            bar.setMax((int) delay);
            Timer time = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    if (bar.getProgress()<delay){
                        bar.setProgress(bar.getProgress()+100);
                    }else {
                        cancel();
                    }
                }
            };
            time.schedule(timerTask,0,100);
    }
    public void resetView(int id){
        if (callMap.containsKey(id)){
            ProgressBar bar = (ProgressBar) callMap.get(id);
            bar.setProgress(0);
        }
    }

}
