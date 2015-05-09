package com.example.alan.draw_circles;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import java.util.Random;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SpecialView miVista = new SpecialView(this);
        setContentView(miVista);
    }



    class SpecialView extends View {
        float x = -30;
        float y = -30;
        int radius = 10;
        String action = "Accion";
        String text = "Evento";
        Path path = new Path();

        public SpecialView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Random rnd = new Random();
            radius = rnd.nextInt(40) + 15;
            canvas.drawColor(Color.WHITE);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(4);
            paint.setColor(Color.BLUE);
            path.addCircle(x, y, radius, Path.Direction.CW);
            canvas.drawPath(path, paint);
            paint.setColor(Color.BLACK);
            paint.setTextSize(20);
            paint.setStrokeWidth(2);
            canvas.drawText(text, 100, 130, paint); canvas.drawText("x = " + x +
                    "  y = " + y, 100, 50, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = event.getX();
            y = event.getY();
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                action = "down";
                text = "Action Down";
            }
            if (event.getAction() == MotionEvent.ACTION_UP) {
                text = "Action Up";
            }
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                action = "move";
                text = "Action Move";
            }
            invalidate();
            return true;
        }
    }
}
