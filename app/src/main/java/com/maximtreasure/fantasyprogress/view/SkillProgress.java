package com.maximtreasure.fantasyprogress.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.maximtreasure.fantasyprogress.core.interfaces.ActionListener;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhengmj on 19-4-10.
 */

public class SkillProgress extends SurfaceView implements SurfaceHolder.Callback{
    private SurfaceHolder holder;
    private Canvas canvas;
    private Timer timer;
    private boolean isDrawing;
    private Paint paint;
    private int text;
    public SkillProgress(Context context) {
        this(context,null);
    }

    public SkillProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        Log.d("120","surfaceinit");
        holder = getHolder();
        holder.addCallback(this);
        paint = new Paint();
        paint.setTextSize(15);
        paint.setTextAlign(Paint.Align.LEFT);
    }
    public void stop(){
        isDrawing = false;
    }
    public boolean isStop(){
        return !isDrawing;
    }
    public void reboot(){
        isDrawing = true;
        text = 0;
        run();
    }
    private void run(){
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (isDrawing){
                    text += 100;
                    canvas = holder.lockCanvas();
                    canvas.drawColor(Color.parseColor("#ffffff"));
                    canvas.drawText(String.valueOf(text),100,100,paint);
                    holder.unlockCanvasAndPost(canvas);
                }else {
                    timer.cancel();
                }
            }
        }, 0, 100);
    }
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.d("120","surfaceCreated");
        isDrawing = true;
        run();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        isDrawing = false;
        timer.cancel();
    }
}
