package com.example.graveyard;

import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.graveyard.MainActivity;
import com.example.graveyard.R;

import java.util.Random;

public class Ghost {
    protected MainActivity activity;
    protected float x, y;
    protected float vx, vy;
    protected int width, height;
    protected ImageView image;

    public Ghost(MainActivity activity) {
        this.activity = activity;
        Random rnd  = new Random();
        width = rnd.nextInt(100)+50;
        height = (int)(width*1.55);
        x = activity.screenWidth/2f - width/2f;
        y = activity.screenHeight/2f - height/2f;
        vx = rnd.nextFloat()*6-3;
        vy = rnd.nextFloat()*6-3;
        image = new ImageView(activity.getApplicationContext());
        image.setImageResource(R.drawable.ghost3);
        image.setX(x);
        image.setY(y);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(width, height);
        image.setLayoutParams(params);
        activity.backGround.addView(image);
    }

    public void move() {
        x += vx;
        if(x > activity.screenWidth - width || x < 0) vx = -vx;
        image.setX(x);

        y += vy;
        if(y > activity.screenHeight - height || y < 0) vy = -vy;
        image.setY(y);
    }
}