package com.example.graveyard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int screenWidth, screenHeight;
    ConstraintLayout backGround;
    Ghost[] ghosts = new Ghost[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenWidth = metrics.widthPixels;
        screenHeight = metrics.heightPixels;

        backGround = findViewById(R.id.grave);

        for (int i = 0; i < ghosts.length; i++) {
            ghosts[i] = new Ghost();
        }

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < ghosts.length; i++) {
                    ghosts[i].move();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 10);
    }

    class Ghost {
        float x, y;
        float vx, vy;
        int width, height;
        ImageView image;

        Ghost() {
            Random rnd  = new Random();
            width = rnd.nextInt(100)+50;
            height = (int)(width*1.55);
            x = screenWidth/2 - width/2;
            y = screenHeight/2 - height/2;
            vx = rnd.nextFloat()*11-5;
            vy = rnd.nextFloat()*11-5;
            image = new ImageView(getApplicationContext());
            image.setImageResource(R.drawable.ghost3);
            image.setX(x);
            image.setY(y);
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(width, height);
            image.setLayoutParams(params);
            backGround.addView(image);
        }

        void move() {
            x += vx;
            if(x > screenWidth - width || x < 0) vx = -vx;
            image.setX(x);

            y += vy;
            if(y > screenHeight - height || y < 0) vy = -vy;
            image.setY(y);
        }
    }
}