package com.example.bouncingball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Rahul on 11/25/2016.
 */

public class MyView extends TextView {
    
    private Paint paint;
    int x = 10, y = 10, rad = 30 , dx,dy;
    
    
    public MyView(Context context) {
        super(context);
        
        paint = new Paint();
        paint.setColor(Color.RED);

        new MyTask().execute(getWidth(),getHeight());

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(x,y,rad,paint);

    }

    private class MyTask extends AsyncTask<Integer,Float,Void>{

        @Override
        protected Void doInBackground(Integer... params) {

            while(true)
            {
                if(x>= getWidth()) dx= -5; // if(x>=params[0])
                if(x<= 0) dx = 5;
                if(y>= getHeight()) dy= -5;  // if(y>=params[1])
                if(y<= 0) dy = 5;

                x +=dx;
                y +=dy;

                publishProgress();

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            super.onProgressUpdate(values);

            invalidate();
        }
    }

}
