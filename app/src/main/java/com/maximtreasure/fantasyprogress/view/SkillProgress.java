package com.maximtreasure.fantasyprogress.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.text.DecimalFormat;
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
    private int nameTextSize = 20;
    private int progressTextSize = 30;
    private int hopeWidth = 600;
    private int hopeHeight = 100;
    private int spacePadding = (hopeHeight - progressTextSize - nameTextSize - 10)/2;
    private int height;
    private int width;
    private float max;
    private float progress;
    private float experience;
    private float totalExperience = 10;
    private  int level;

    private int skillId = -1;
    private String skillName;

    public SkillProgress(Context context) {
        this(context,null);
    }

    public SkillProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public int getSkillId(){
        return skillId;
    }
    public String getSkillName(){
        return skillName;
    }
    private void init(){
        Log.d("120","surfaceinit");
        holder = getHolder();
        holder.addCallback(this);
        initSkill();
    }
    private void initSkill(){

    }
    public void stop(){
        isDrawing = false;
        timer.cancel();
    }
    public boolean isStop(){
        return !isDrawing;
    }
    public void reboot(){
        isDrawing = true;
        progress = 0;
        run();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST||MeasureSpec.getMode(heightMeasureSpec)==MeasureSpec.AT_MOST){
            setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
        }
    }
    private int measureHeight(int value){
        int size = MeasureSpec.getSize(value);
        return Math.min(size, hopeHeight);
    }
    private int measureWidth(int value){
        int size = MeasureSpec.getSize(value);
        return Math.min(size, hopeWidth);
    }
    private void run(){
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (isDrawing){
                    progress += 0.1;
                    canvas = holder.lockCanvas();
                    height = canvas.getHeight();
                    width = canvas.getWidth();
                    canvas.drawColor(Color.parseColor("#ffffff"));
                    drawEdge();
                    drawProgress();
                    drawExperienceProgress();
                    drawText();
                    Log.d("120","text == "+progress);
                    holder.unlockCanvasAndPost(canvas);
                }else {
                    timer.cancel();
                }
            }
        }, 0, 100);
    }
    private void drawEdge(){
        RectF rectF = new RectF(0,0,width,height);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#232323"));
        canvas.drawRoundRect(rectF,20,20,paint);
    }
    private void drawText(){
        String text = null;
        max = 2.0f;
        DecimalFormat df = new DecimalFormat("#.00");
        String sMax = String.valueOf(df.format(max));
        String sProgress = String.valueOf(df.format(progress));
        text = "( "+sProgress+" / "+sMax+" s )";
        Paint progressPaint = new Paint();
        progressPaint.setAntiAlias(true);
        progressPaint.setTextSize(progressTextSize);
        progressPaint.setTextAlign(Paint.Align.LEFT);
        String name = null;
        if (level == 0){
             name = "九阳神功";
        }else {
             name = "九阳神功 +"+level;
        }
        Paint namePaint = new Paint();
        namePaint.setAntiAlias(true);
        namePaint.setTextSize(nameTextSize);
        namePaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(name,spacePadding,spacePadding,namePaint);
        canvas.drawText(text,spacePadding,spacePadding*2+nameTextSize,progressPaint);
        if (progress>=max){
            experience += 1;
            stop();
        }
    }
    private void drawProgress(){
        float percent = progress/max;
        int progressWidth = (int) (width*percent);
        RectF rectF = new RectF(0,0,progressWidth,height);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#7FFFAA"));
        canvas.drawRoundRect(rectF,20,20,paint);
    }
    private void drawExperienceProgress(){
        float percent = experience/totalExperience;
        int progressWidth = (int) (width*percent);
        RectF rectF = new RectF(0,0,progressWidth,height);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#994B0082"));
        canvas.drawRoundRect(rectF,20,20,paint);
        if (experience == totalExperience){
            experience = 0;
            level += 1;
        }
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
