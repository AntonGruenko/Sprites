package com.example.sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.sprites.AppView;

public class Sprite {
    AppView surfaceView;
    Bitmap image;
    float currentx, currenty, targetx, targety, speedx = 0, speedy = 0;
    int columns = 5, rows = 2, width_1, height_1;
    Paint paint= new Paint();
    int currentFrame=0, direction=0;
    int cadrx, cadry;


    public Sprite (AppView surfaceView, Bitmap image, float x, float y) {
        this.surfaceView = surfaceView;
        this.image = image;
        currentx = x;
        currenty = y;
        width_1 = image.getWidth() / columns;
        height_1 = image.getHeight() / rows;
    }

    void draw(Canvas canvas) {
        currentx += speedx;
        currenty += speedy;
        checkWall();
        currentFrame = ++currentFrame % columns;
        cadrx = currentFrame * width_1;
        cadry = direction * height_1;
        Rect src = new Rect(cadrx, cadry, cadrx+width_1, cadry+height_1);
        Rect dst = new Rect((int) currentx, (int) currenty, (int) currentx + width_1, (int) currenty + height_1);
        canvas.drawBitmap(image, src, dst, paint);
    }

    public void setTarget(float targetx, float targety) {
        this.targetx = targetx;
        this.targety = targety;
        speedx = (targetx - currentx) / surfaceView.getWidth() * 50;
        speedy = (targety - currenty) / surfaceView.getHeight() * 50;
        if (speedy/speedx>1 ) {direction=3;}
        else {if (speedy/speedx<1 & speedy/speedx>-1) direction=0;
        else {
            if (speedy/speedx<-1){direction=1;}
        }}
    }

    void checkWall(){
        if (currentx <=0 || currentx+width_1>=surfaceView.getWidth()) speedx=-speedx;
        if (currenty <=0 || currenty+height_1>=surfaceView.getHeight()) speedy=-speedy;
    }
}

