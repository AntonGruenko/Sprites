package com.example.sprites;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;


import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

class AppView extends SurfaceView implements SurfaceHolder.Callback {

    Resources resources;
    Bitmap img, sprite_image;
    SurfaceThread thread;
    Paint paint;
    float currentx = 0, currenty = 0, stepx = 0, stepy = 0, touchx, touchy;
    float width, height;
    boolean touchEvent = false;
    //Sprites sprite;
    ArrayList<Sprite> sprite = new ArrayList<Sprite>();

    public AppView(Context context) {
        super(context);
        getHolder().addCallback(this);
        resources = getResources();
        img = BitmapFactory.decodeResource(resources, R.drawable.sprites);
        sprite_image = BitmapFactory.decodeResource(resources, R.drawable.sprites);
        setFocusable(true);
        sprite.add(0, new Sprite(this, sprite_image, currentx, currenty));
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new SurfaceThread(getHolder(), this);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    void checkWall() {
        if (currentx <= 0 || currentx + img.getWidth() >= width) stepx = -stepx;
        if (currenty <= 0 || currenty + img.getHeight() >= height) stepy = -stepy;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        thread.running = false;
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int j;
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            touchEvent = true;
            touchx = event.getX();
            touchy = event.getY();
            for (j = 0; j < sprite.size(); j++)
                sprite.get(j).setTarget(touchx, touchy);
            sprite.add(j, new Sprite(this, sprite_image, touchx, touchy));

        }

        return true;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        width = canvas.getWidth();
        height = canvas.getHeight();
        canvas.drawARGB(0, 0, 0, 0);

        for (int i=0; i<sprite.size(); i++){
            sprite.get(i).draw(canvas);
        }
    }
}