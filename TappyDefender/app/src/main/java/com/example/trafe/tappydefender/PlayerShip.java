package com.example.trafe.tappydefender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

/**
 * Created by Trajon Felton on 3/3/2017.
 */

public class PlayerShip {
    private final int gravity = -12;
    //Stop ship leaving the screen
    private int maxY;
    private int minY;
    //Limit the bounds of the ship's speed
    private final int min_speed = 1;
    private final int max_speed = 20;

    private Bitmap bitmap;
    private int x, y;
    private int speed = 0;
    private boolean boosting;

    //Constructor
    public PlayerShip(Context context, int screenX, int screenY){
        x = 50;
        y = 50;
        speed = 1;
        //This represents the appearance of the ship
        //To load bitmaps, we need to receive a context object from android
        //drawable ship is the name of the image we want to appear on the screen
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ship);
        boosting = false;
        maxY = screenY - bitmap.getHeight();
        minY = 0;
    }

    public void update() {
        //Are we boosting
        if (boosting) {
            //Speed up
            speed += 2;
        } else {
            //Slow down
            speed -= 5;
        }

        //Constrain top speed
        if (speed > max_speed){
            speed = max_speed;
        }

        //Never stop completely
        if (speed < min_speed){
            speed = min_speed;
        }

        //move the ship up or down
        y -= speed + gravity;

        //Never let the ship go off the screen
        if (y < minY){
            y = minY;
        }

        if (y > maxY){
            y = maxY;
        }
        x++;
    }
    public void setBoosting(){
        boosting = true;
    }

    public void stopBoosting(){
        boosting = false;
    }

    //Getters
    public Bitmap getBitmap(){
        return bitmap;
    }
    public int getSpeed(){
        return speed;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
