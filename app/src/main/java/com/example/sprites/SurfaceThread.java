package com.example.sprites;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.example.sprites.AppView;

class SurfaceThread extends Thread {
    SurfaceHolder Holder;
    AppView view;
    long Time;
    boolean running = true;

    public SurfaceThread(SurfaceHolder holder, AppView view) { //constructor
        Holder = holder;
        this.view = view;
        Time = System.currentTimeMillis();
    }

    @Override
    public void run() {
        while (running) {
            //super.run();
            Canvas canvas = null;
            long Time0 = System.currentTimeMillis();
            long Time_ = Time0 - Time;

            if (Time_ > 30) {
                Time = Time0;
                canvas = Holder.lockCanvas();
                synchronized (Holder) {
                    this.view.draw(canvas);

                }

                if (canvas != null) Holder.unlockCanvasAndPost(canvas);
            }
        }
    }




}
