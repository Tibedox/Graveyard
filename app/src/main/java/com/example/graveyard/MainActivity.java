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
            ghosts[i] = new Ghost(this);
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
}