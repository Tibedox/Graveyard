package com.example.graveyard;

import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class Ghost {
    MainActivity activity;
    float x, y;
    float vx, vy;
    int width, height;
    ImageView image;

    Ghost(MainActivity activity) {
        this.activity = activity;
        Random rnd  = new Random();
        width = rnd.nextInt(100)+50;
        height = (int)(width*1.55);
        x = activity.screenWidth/2 - width/2;
        y = activity.screenHeight/2 - height/2;
        vx = rnd.nextFloat()*11-5;
        vy = rnd.nextFloat()*11-5;
        image = new ImageView(activity.getApplicationContext());
        image.setImageResource(R.drawable.ghost3);
        image.setX(x);
        image.setY(y);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(width, height);
        image.setLayoutParams(params);
        activity.backGround.addView(image);
    }

    void move() {
        x += vx;
        if(x > activity.screenWidth - width || x < 0) vx = -vx;
        image.setX(x);

        y += vy;
        if(y > activity.screenHeight - height || y < 0) vy = -vy;
        image.setY(y);
    }
}