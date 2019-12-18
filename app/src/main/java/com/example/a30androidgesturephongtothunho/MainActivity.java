package com.example.a30androidgesturephongtothunho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    ImageView imageView1;
    ScaleGestureDetector scaleGestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1 = findViewById(R.id.imageView1);

        scaleGestureDetector = new ScaleGestureDetector(MainActivity.this, new MyGesture());
        imageView1.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                scaleGestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    class MyGesture extends ScaleGestureDetector.SimpleOnScaleGestureListener
    {
        float scale = 1.0F, onScaleStart = 0, onScaleEnd = 0;
        @Override
        public boolean onScale(ScaleGestureDetector detector)
        {
            scale *= detector.getScaleFactor();
            imageView1.setScaleX(scale);
            imageView1.setScaleY(scale);
            return super.onScale(detector);
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector)
        {
            Toast.makeText(MainActivity.this, "onScaleStart", Toast.LENGTH_SHORT).show();
            onScaleStart = scale;
            return super.onScaleBegin(detector);
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector)
        {
            Toast.makeText(MainActivity.this, "onScaleEnd", Toast.LENGTH_SHORT).show();
            onScaleEnd = scale;
            super.onScaleEnd(detector);
        }
    }
}
