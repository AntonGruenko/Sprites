package com.example.sprites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new AppView(this));
    }
}
/*class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceThread thread;
    private Sprite sprite;

    public MySurfaceView(Context context){
        super(context);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_launcher_background);
        sprite = new Sprite(this,
                new Pair<Float, Float>(-1000f, -1000f),bitmap);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event){
        Pair<Float, Float> target = new Pair<>(event.getX(), event.getY());
        sprite.setTarget(target);
        return super.onTouchEvent(event);
    }
    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);

        canvas.drawColor(Color.WHITE);
        sprite.draw(canvas);
    }
}

    class Sprite{
        MySurfaceView surfaceView;
        Pair<Float, Float> current, target, speed;
        Bitmap image;
        Paint paint = new Paint();
        int direction = 0;
        int frameX = 0, frameY = 0, frame = 0;
        int rows = 3, columns = 4;
        float widthUnit, heightUnit;
        float scaling  = 1.0f;

        public Sprite(MySurfaceView surfaceView, Pair<Float, Float> current, Pair<Float, Float> target, Bitmap image) {
            this.current = current;
            this.surfaceView = surfaceView;
            this.target = target;
            this.image = image;
            widthUnit = image.getWidth() / columns;
            heightUnit = image.getHeight() / rows;
        }

        void draw(Canvas canvas){
            current = new Pair<>(
                    current.first + speed.first,
                    current.second + speed.second
            );
            checkWall();
            frame = ++frame % columns;
            frameX = frame * widthUnit;
            frameY = direction * heightUnit;
            Rect src = new Rect(frameX, FrameY,
                    frameX + widthUnit, FrameY + heightUnit );
            Rect dst = new Rect(current.first.intValue(), current.second.intValue(),
                    (int)(current.first + scaling * widthUnit),
                    (int)(current.second + scaling * heightUnit)
            );
            //todo change sprites sizes
            canvas.drawBitmap(image,src,dst, paint);

        }

        public void setTarget(){
            this.target = new Pair<>(target.first, target.second);
            speed = new Pair<>(
                    (target.first - current.first) / surfaceView.getWidth,
                    (target.second - current.second) / surfaceView.getHeight()

            );
        }

        public void checkWall(){//TODO}

    }
}*/
