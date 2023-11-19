package com.example.graveyard;

public class Dementor extends Ghost {

    public Dementor(MainActivity activity) {
        super(activity);
        image.setImageResource(R.drawable.ghost2);
    }

    @Override
    public void move() {
        x += vx;
        if(x > activity.screenWidth) x = -width;
        if(x < -width) x = activity.screenWidth;
        image.setX(x);

        y += vy;
        if(y > activity.screenHeight) y = -height;
        if(y < -height) y = activity.screenHeight;
        image.setY(y);
    }
}
